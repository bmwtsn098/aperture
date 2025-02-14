package jobs

import (
	"context"
	"strings"
	"sync/atomic"
	"testing"
	"time"

	"github.com/stretchr/testify/require"
	"google.golang.org/protobuf/proto"
	"google.golang.org/protobuf/types/known/anypb"
	"google.golang.org/protobuf/types/known/emptypb"
	"google.golang.org/protobuf/types/known/wrapperspb"

	statusv1 "github.com/fluxninja/aperture/api/gen/proto/go/aperture/status/v1"
	"github.com/fluxninja/aperture/pkg/config"
	"github.com/fluxninja/aperture/pkg/log"
	"github.com/fluxninja/aperture/pkg/status"
)

var (
	jobGroup, err = createJobGroup() // Job group is created globally so that it can be used to schedule jobs contained in all tests, otherwise a jobgroup per test needs to be created
	jws           JobWatchers
	gws           GroupWatchers
	jobConfig     = JobConfig{ // Job configuration can be manipulated in each test to test different scenarios, no need to create new job config for each test
		InitialDelay:     config.MakeDuration(0),
		ExecutionPeriod:  config.MakeDuration(time.Millisecond * 200),
		ExecutionTimeout: config.MakeDuration(time.Millisecond * 200),
		InitiallyHealthy: false,
	}
	registry = status.NewRegistry(log.GetGlobalLogger()).Child("jobs")
)

var _ JobWatcher = (*groupConfig)(nil)

type groupConfig struct {
	jobs               []Job
	jobRunConfig       jobRunConfig
	expectedScheduling bool // to be used to check if sleeping/stuck jobs are getting stuck or not
}

type jobRunConfig struct {
	expectedStatusMsg string        // expected Registry result for liveness check
	sleepTime         time.Duration // time to sleep before checking results
	expectedNoOfRuns  int           // Based on provided configuration, estimate the expected number of runs for the job
}

// When a job is only scheduled and not run, it's number of run should be 0
func (jws *groupConfig) OnJobScheduled() {
	for _, job := range jws.jobs {
		jobInfo := jobGroup.JobInfo(job.Name())
		if jobInfo.RunCount > 0 {
			log.Error().Msgf("Expected run count to be 0, got %d", jobInfo.RunCount)
		}
	}
}

// Estimate the number of runs for the job based on the provided configuration and compare with the actual result
func (jws *groupConfig) OnJobCompleted(_ *statusv1.Status, _ JobStats) {
	for _, job := range jws.jobs {
		jobInfo := jobGroup.JobInfo(job.Name())
		if jobInfo.RunCount != jws.jobRunConfig.expectedNoOfRuns {
			log.Error().Msgf("Expected run count to be %d, got %d", jws.jobRunConfig.expectedNoOfRuns, jobInfo.RunCount)
		}
	}
}

func createJobGroup() (*JobGroup, error) {
	return NewJobGroup(registry, 10, RescheduleMode, gws)
}

func runTest(t *testing.T, groupConfig *groupConfig) {
	err = jobGroup.Start()
	require.NoError(t, err)

	for _, job := range groupConfig.jobs {
		err = jobGroup.RegisterJob(job, jobConfig)
		require.NoError(t, err)
	}

	if jobGroup.IsHealthy() != jobConfig.InitiallyHealthy {
		t.Error("Job health status has changed")
	}
	time.Sleep(groupConfig.jobRunConfig.sleepTime)

	for _, job := range groupConfig.jobs {
		livenessReg := registry.Root().
			Child("liveness").
			Child("job_groups").
			Child(registry.Key()).
			Child(job.Name())

		if groupConfig.jobRunConfig.expectedStatusMsg == "Timeout" {
			checkStatusMessage(t, livenessReg, groupConfig.jobRunConfig.expectedStatusMsg, true)
			jobGroup.TriggerJob(job.Name())
		} else {
			checkStatusMessage(t, livenessReg, groupConfig.jobRunConfig.expectedStatusMsg, false)
		}

		groupConfig.OnJobCompleted(nil, JobStats{})

		groupConfigExpectedScheduling := groupConfig.expectedScheduling
		_, val := jobGroup.Results()
		if val != groupConfigExpectedScheduling {
			t.Errorf("Expected scheduling to be %v, got %v", groupConfigExpectedScheduling, val)
		}
		checkStatusBeforeDeregister(t, []string{job.Name()}, groupConfigExpectedScheduling)
	}
	if len(groupConfig.jobs) > 1 {
		jobGroup.DeregisterAll()
	} else {
		err = jobGroup.DeregisterJob(groupConfig.jobs[0].Name())
		require.NoError(t, err)
	}
}

func checkStatusMessage(t *testing.T, registry status.Registry, protoMsg string, hasError bool) {
	var gotStatusMsg, expectedStatusMsg *anypb.Any
	if hasError {
		require.True(t, registry.HasError())
	} else {
		require.False(t, registry.HasError())
	}
	gotStatusMsg = registry.GetStatus().GetMessage()
	if protoMsg == "" {
		expectedStatusMsg, _ = anypb.New(&emptypb.Empty{})
	} else {
		expectedStatusMsg, _ = anypb.New(wrapperspb.String(protoMsg))
	}
	if !proto.Equal(gotStatusMsg, expectedStatusMsg) {
		t.Errorf("Expected status message to be %v, got %v", expectedStatusMsg, gotStatusMsg)
	}
}

func checkStatusBeforeDeregister(t *testing.T, names []string, expectedScheduling bool) {
	for _, name := range names {
		jobRegistry := registry.ChildIfExists(name)
		require.NotNil(t, jobRegistry)
		require.Equal(t, jobRegistry.Key(), name)

		if strings.Split(name, "-")[0] == "multi" {
			checkStatusMessage(t, jobRegistry, "MultiJob", false)
			continue
		}
		if expectedScheduling {
			checkStatusMessage(t, jobRegistry, "", false)
		} else {
			require.True(t, jobRegistry.HasError())
		}
	}
}

func checkStatusAfterDeregister(t *testing.T, names []string) {
	for _, name := range names {
		jobRegistry := registry.ChildIfExists(name)
		require.Nil(t, jobRegistry)
	}
}

func checkResults(t *testing.T, counter int32, counterMatch int32) {
	if counter != counterMatch {
		t.Errorf("Expected counter to be %d, got %d", counterMatch, counter)
	}
}

// TestInstantRunJob tests the run of a simple basic job.
func TestInstantRunJob(t *testing.T) {
	var counter int32
	job := &BasicJob{
		JobBase: JobBase{
			JobName: "instant-run-job",
		},
		JobFunc: func(ctx context.Context) (proto.Message, error) {
			select {
			case <-ctx.Done():
				return &emptypb.Empty{}, nil
			default:
				atomic.AddInt32(&counter, 1)
				return &emptypb.Empty{}, nil
			}
		},
	}
	groupConfig := &groupConfig{
		jobs: []Job{job},
		jobRunConfig: jobRunConfig{
			sleepTime:         time.Millisecond * 300,
			expectedStatusMsg: "OK",
			expectedNoOfRuns:  2,
		},
		expectedScheduling: true,
	}

	runTest(t, groupConfig)
	checkResults(t, counter, int32(2))
	checkStatusAfterDeregister(t, []string{job.JobName})
}

// TestTimeoutJob tests the liveness of the job, when the job is stuck.
func TestTimeoutJob(t *testing.T) {
	var counter int32
	jobConfig.InitialDelay = config.MakeDuration(time.Millisecond * 100)
	job := &BasicJob{
		JobBase: JobBase{
			JobName: "timeout-job",
		},
		JobFunc: func(ctx context.Context) (proto.Message, error) {
			time.Sleep(time.Millisecond * 4000)
			select {
			case <-ctx.Done():
				return &emptypb.Empty{}, nil
			default:
				atomic.AddInt32(&counter, 1)
				return &emptypb.Empty{}, nil
			}
		},
	}

	groupConfig := &groupConfig{
		jobs: []Job{job},
		jobRunConfig: jobRunConfig{
			sleepTime:         time.Millisecond * 2000,
			expectedStatusMsg: "Timeout",
			expectedNoOfRuns:  11, // Job gets scheduled 10 times within 2 seconds + 1 scheduling caused by manual trigger if job is stuck
		},
		expectedScheduling: false,
	}
	runTest(t, groupConfig)
	checkResults(t, counter, int32(0))
	checkStatusAfterDeregister(t, []string{job.JobName})
}

// TestMultiJobRun tests the scheduling of a multi-job containing a basic job.
func TestMultiJobRun(t *testing.T) {
	var counter int32
	var counter2 int32
	jobConfig.InitialDelay = config.MakeDuration(0)
	multiJob := NewMultiJob(jobGroup.GetStatusRegistry().Child("multi-job"), jws, gws)
	job := &BasicJob{
		JobBase: JobBase{
			JobName: "test-job",
		},
		JobFunc: func(ctx context.Context) (proto.Message, error) {
			select {
			case <-ctx.Done():
				return &emptypb.Empty{}, nil
			default:
				atomic.AddInt32(&counter, 1)
				return &emptypb.Empty{}, nil
			}
		},
	}
	job2 := &BasicJob{
		JobBase: JobBase{
			JobName: "test-job2",
		},
		JobFunc: func(ctx context.Context) (proto.Message, error) {
			select {
			case <-ctx.Done():
				return &emptypb.Empty{}, nil
			default:
				atomic.AddInt32(&counter2, 5)
				return &emptypb.Empty{}, nil
			}
		},
	}
	groupConfig := &groupConfig{
		jobs: []Job{job, job2},
		jobRunConfig: jobRunConfig{
			sleepTime:         time.Millisecond * 300,
			expectedStatusMsg: "OK",
			expectedNoOfRuns:  2,
		},
		expectedScheduling: true,
	}
	multiJob.RegisterJob(job)
	multiJob.RegisterJob(job2)

	runTest(t, groupConfig)
	checkResults(t, counter, int32(2))
	checkResults(t, counter2, int32(10))

	err = multiJob.DeregisterJob(job.Name())
	require.NoError(t, err)
	multiJob.DeregisterAll()
	checkStatusAfterDeregister(t, []string{job.JobName, job2.JobName})
}

// TestMultipleBasicJobs tests the scheduling and parallel run of multiple basic jobs.
func TestMultipleBasicJobs(t *testing.T) {
	var counter int32
	var counter2 int32
	job := &BasicJob{
		JobBase: JobBase{
			JobName: "test-job",
		},
		JobFunc: func(ctx context.Context) (proto.Message, error) {
			select {
			case <-ctx.Done():
				return &emptypb.Empty{}, nil
			default:
				atomic.AddInt32(&counter, 1)
				return &emptypb.Empty{}, nil
			}
		},
	}
	job2 := &BasicJob{
		JobBase: JobBase{
			JobName: "test-job2",
		},
		JobFunc: func(ctx context.Context) (proto.Message, error) {
			select {
			case <-ctx.Done():
				return &emptypb.Empty{}, nil
			default:
				atomic.AddInt32(&counter2, 5)
				return &emptypb.Empty{}, nil
			}
		},
	}
	groupConfig := &groupConfig{
		jobs: []Job{job, job2},
		jobRunConfig: jobRunConfig{
			sleepTime:         time.Millisecond * 300,
			expectedStatusMsg: "OK",
			expectedNoOfRuns:  2,
		},
		expectedScheduling: true,
	}
	runTest(t, groupConfig)
	checkResults(t, counter, int32(2))
	checkResults(t, counter2, int32(10))
	checkStatusAfterDeregister(t, []string{job.JobName, job2.JobName})
}

// TestMultipleMultiJobs tests the scheduling and parallel run of multiple multi-jobs containing multiple basic jobs.
func TestMultipleMultiJobs(t *testing.T) {
	var counter int32
	var counter2 int32
	var counter3 int32
	multiJob := NewMultiJob(jobGroup.GetStatusRegistry().Child("multi-job1"), jws, gws)
	multiJob2 := NewMultiJob(jobGroup.GetStatusRegistry().Child("multi-job2"), jws, gws)
	job := &BasicJob{
		JobBase: JobBase{
			JobName: "test-job",
		},
		JobFunc: func(ctx context.Context) (proto.Message, error) {
			select {
			case <-ctx.Done():
				return &emptypb.Empty{}, nil
			default:
				atomic.AddInt32(&counter, 1)
				return &emptypb.Empty{}, nil
			}
		},
	}
	job2 := &BasicJob{
		JobBase: JobBase{
			JobName: "test-job2",
		},
		JobFunc: func(ctx context.Context) (proto.Message, error) {
			select {
			case <-ctx.Done():
				return &emptypb.Empty{}, nil
			default:
				atomic.AddInt32(&counter2, 5)
				return &emptypb.Empty{}, nil
			}
		},
	}

	job3 := &BasicJob{
		JobBase: JobBase{
			JobName: "test-job3",
		},
		JobFunc: func(ctx context.Context) (proto.Message, error) {
			select {
			case <-ctx.Done():
				return &emptypb.Empty{}, nil
			default:
				atomic.AddInt32(&counter3, 10)
				return &emptypb.Empty{}, nil
			}
		},
	}

	multiJob.RegisterJob(job)
	multiJob.RegisterJob(job2)
	multiJob2.RegisterJob(job3)
	groupConfig := &groupConfig{
		jobs: []Job{multiJob, multiJob2},
		jobRunConfig: jobRunConfig{
			sleepTime:         time.Millisecond * 300,
			expectedStatusMsg: "OK",
			expectedNoOfRuns:  2,
		},
		expectedScheduling: true,
	}
	runTest(t, groupConfig)
	checkResults(t, counter, int32(2))
	checkResults(t, counter2, int32(10))
	checkResults(t, counter3, int32(20))
	checkStatusAfterDeregister(t, []string{job.JobName, job2.JobName, job3.JobName})
}

// TestSameJobTwice returns error when scheduling job with same name.
func TestSameJobTwiceAndSchedulingErrors(t *testing.T) {
	var counter int32
	job := &BasicJob{
		JobBase: JobBase{
			JobName: "test-job",
		},
		JobFunc: func(ctx context.Context) (proto.Message, error) {
			select {
			case <-ctx.Done():
				return &emptypb.Empty{}, nil
			default:
				atomic.AddInt32(&counter, 1)
				return &emptypb.Empty{}, nil
			}
		},
	}
	job2 := job
	err = jobGroup.RegisterJob(job, jobConfig)
	require.NoError(t, err)

	err = jobGroup.RegisterJob(job2, jobConfig)
	require.Error(t, err)
	checkStatusBeforeDeregister(t, []string{job.JobName, job2.JobName}, false)

	jobGroup.DeregisterAll()
	checkStatusAfterDeregister(t, []string{job.JobName, job2.JobName})
	// error when registering job multiple times, written here to achieve more coverage
	err = jobGroup.DeregisterJob(job.Name())
	require.Errorf(t, err, "Expected error when deregistering job multiple times")
	require.Empty(t, jobGroup.JobInfo(job.Name()), "Expected error when getting job info, because job was already deregistered")
}

func TestEmptyJobFunc(t *testing.T) {
	job := &BasicJob{
		JobBase: JobBase{
			JobName: "test-job",
		},
		JobFunc: nil,
	}
	err = jobGroup.RegisterJob(job, jobConfig)
	if err == nil {
		t.Log("Expected log message when registering job with nil job func")
	}
	checkStatusBeforeDeregister(t, []string{job.JobName}, false)
	jobGroup.DeregisterAll()
	checkStatusAfterDeregister(t, []string{job.JobName})
}
