package com.vel9.generativemusic.core.time;

import com.vel9.generativemusic.core.support.DurationVelocity;

/**
 * Created by levani on 12/4/16.
 */
public interface RhythmStrategy {
    DurationVelocity next();
    boolean hasNext();
}
