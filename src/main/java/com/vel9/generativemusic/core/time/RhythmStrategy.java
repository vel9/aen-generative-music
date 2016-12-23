package com.vel9.generativemusic.core.time;

import com.vel9.generativemusic.core.support.DurationVelocity;

/* Provides the duration and velocity of the next note */
public interface RhythmStrategy {
    DurationVelocity next();
}
