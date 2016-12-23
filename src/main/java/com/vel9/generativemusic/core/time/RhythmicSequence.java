package com.vel9.generativemusic.core.time;

/**
 * Provides a rhythmic sequence and an indicator whether the elements are silent.
 *
 * Implementations could returns the same sequence over and over,
 * or they could provide algorithms for switching between
 * various sequences.
 */
public interface RhythmicSequence {
    RhythmicElement[] getRhythmicSequence();
    boolean isSilence();
}
