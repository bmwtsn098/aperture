package scheduler

import (
	"time"
)

// WindowedCounter is a token bucket with a windowed counter.
type WindowedCounter struct {
	// stats
	nextSlotTime time.Time     // Time when we advance the slot
	counters     []uint64      // Window of counters
	slotDuration time.Duration // time duration of slot
	totalSlots   uint8         // total slots in sliding window
	currentSlot  uint8         // currentSlot being updated for counters

	bootstrapping bool
}

// NewWindowedCounter creates a new WindowedCounter with extra slot for the current window.
func NewWindowedCounter(now time.Time, totalSlots uint8, slotDuration time.Duration) *WindowedCounter {
	counter := &WindowedCounter{}

	// create an extra slot for aggregating current window
	counter.totalSlots = totalSlots + 1
	counter.slotDuration = slotDuration
	counter.counters = make([]uint64, counter.totalSlots)
	counter.currentSlot = 0
	counter.nextSlotTime = now.Add(counter.slotDuration)
	counter.bootstrapping = true
	return counter
}

// CalculateTokenRate returns the calculated token rate in the current window.
func (counter *WindowedCounter) CalculateTokenRate() float64 {
	var total uint64
	// calculate total (ignoring the currentSlot)
	for i := uint8(0); i < counter.totalSlots; i++ {
		if i != counter.currentSlot {
			total += counter.counters[i]
		}
	}
	// recalculate tokenRate
	return float64(total) * 1e9 / float64(int64(counter.totalSlots-1)*int64(counter.slotDuration))
}

// IsBootstrapping checks whether the counter is in bootstrapping mode.
func (counter *WindowedCounter) IsBootstrapping() bool {
	return counter.bootstrapping
}

// AddTokens to the counter. Return value is true when counter shifted slots and the all the slots in the counter is valid.
func (counter *WindowedCounter) AddTokens(now time.Time, tokens uint64) bool {
	shifted := false

	if now.After(counter.nextSlotTime) {
		// we are going to shift slots
		shifted = true
		delta := now.Sub(counter.nextSlotTime)
		ticks := int64(int64(delta) / int64(counter.slotDuration))
		// advance ticks by 1 slot
		ticks++

		// reset nextSlotTime
		counter.nextSlotTime = counter.nextSlotTime.Add(time.Duration((ticks) * int64(counter.slotDuration)))

		// If entire window is invalid avoid unnecessary loops
		if ticks > int64(counter.totalSlots) {
			// fast forward totalSlots
			ticks = int64(counter.totalSlots)
		}

		for i := int64(0); i < ticks; i++ {
			counter.currentSlot++
			if counter.currentSlot == counter.totalSlots {
				// reset to first slot
				counter.currentSlot = 0
				if counter.bootstrapping {
					// This is the first time window has filled, make the tokenRate valid
					// The actual value will be calculated outside for loop
					counter.bootstrapping = false
				}
			}
			// reset slot counter
			counter.counters[counter.currentSlot] = 0
		}

		// If entire window was invalidated, it's better to go back to the bootstrap mode
		// Traffic might have restarted after an outage so we shouldn't drop excessive traffic because
		// tokenRate will be calculated with incomplete counts
		if ticks >= int64(counter.totalSlots) {
			counter.currentSlot = 0
			counter.bootstrapping = true
			shifted = false
		}
	}

	// Increment counter
	counter.counters[counter.currentSlot] += tokens

	if shifted && !counter.bootstrapping {
		return true
	}

	// still bootstrapping or didn't shift slots yet
	return false
}
