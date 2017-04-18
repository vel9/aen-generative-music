package com.vel9.generativemusic.aen.core.dynamics;

import com.vel9.generativemusic.aen.core.time.RhythmicSequence;

/**
 * Implementations should provide an algorithm for
 * determining the current velocity value, the algorithm is
 * provided with the current rhythmic sequence as well as the
 * the position in the given sequence.
 */
public interface DynamicsStrategy {
    /* returns velocity value */
    int getVelocity(int sequenceElementIndex, RhythmicSequence rhythmicSequence);
}
