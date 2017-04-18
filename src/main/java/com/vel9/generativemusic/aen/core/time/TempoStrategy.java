package com.vel9.generativemusic.aen.core.time;

/**
 * Provides the current tempo in bpm
 *
 * Implementations, for example, could provide the same tempo over and over
 * or the tempo could change over time.
 */
public interface TempoStrategy {
    int getBpm();
}
