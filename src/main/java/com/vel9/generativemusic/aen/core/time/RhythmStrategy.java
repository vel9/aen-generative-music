package com.vel9.generativemusic.aen.core.time;

import com.vel9.generativemusic.aen.core.support.DurationVelocity;

/* Provides the time and velocity of the next note */
public interface RhythmStrategy {
    DurationVelocity next();
}
