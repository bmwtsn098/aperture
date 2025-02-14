//go:build !ignore_autogenerated
// +build !ignore_autogenerated

/*
Copyright 2022.

Licensed under the Apache License, Version 2.0 (the "License");
you may not use this file except in compliance with the License.
You may obtain a copy of the License at

    http://www.apache.org/licenses/LICENSE-2.0

Unless required by applicable law or agreed to in writing, software
distributed under the License is distributed on an "AS IS" BASIS,
WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
See the License for the specific language governing permissions and
limitations under the License.
*/

// Code generated by controller-gen. DO NOT EDIT.

package jobs

import ()

// DeepCopyInto is an autogenerated deepcopy function, copying the receiver, writing into out. in must be non-nil.
func (in *JobConfig) DeepCopyInto(out *JobConfig) {
	*out = *in
	in.InitialDelay.DeepCopyInto(&out.InitialDelay)
	in.ExecutionPeriod.DeepCopyInto(&out.ExecutionPeriod)
	in.ExecutionTimeout.DeepCopyInto(&out.ExecutionTimeout)
}

// DeepCopy is an autogenerated deepcopy function, copying the receiver, creating a new JobConfig.
func (in *JobConfig) DeepCopy() *JobConfig {
	if in == nil {
		return nil
	}
	out := new(JobConfig)
	in.DeepCopyInto(out)
	return out
}

// DeepCopyInto is an autogenerated deepcopy function, copying the receiver, writing into out. in must be non-nil.
func (in *JobGroupConfig) DeepCopyInto(out *JobGroupConfig) {
	*out = *in
	out.SchedulerConfig = in.SchedulerConfig
}

// DeepCopy is an autogenerated deepcopy function, copying the receiver, creating a new JobGroupConfig.
func (in *JobGroupConfig) DeepCopy() *JobGroupConfig {
	if in == nil {
		return nil
	}
	out := new(JobGroupConfig)
	in.DeepCopyInto(out)
	return out
}

// DeepCopyInto is an autogenerated deepcopy function, copying the receiver, writing into out. in must be non-nil.
func (in *SchedulerConfig) DeepCopyInto(out *SchedulerConfig) {
	*out = *in
}

// DeepCopy is an autogenerated deepcopy function, copying the receiver, creating a new SchedulerConfig.
func (in *SchedulerConfig) DeepCopy() *SchedulerConfig {
	if in == nil {
		return nil
	}
	out := new(SchedulerConfig)
	in.DeepCopyInto(out)
	return out
}
