package com.vel9.generativemusic.core.pitch;

/**
 * Provides sequence of intervals,
 * an implementation could return an int array of [-1, -1, 1]
 * which to the caller could mean: generate two pitches which go down and one that goes up
 *
 * Of course, the array could also be interpreted more strictly by the caller
 * go down 1 pitch (semitone), go down 1 pitch and go up 1 pitch
 */
public interface IntervalSequence {
    int[] getIntervalSequence();
}
