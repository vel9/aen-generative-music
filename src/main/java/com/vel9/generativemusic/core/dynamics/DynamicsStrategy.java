package com.vel9.generativemusic.core.dynamics;

import com.vel9.generativemusic.core.time.RhythmicSequence;

/**
 * Created by levani on 12/4/16.
 */
public interface DynamicsStrategy {
    int getVelocity(int sequenceElementIndex, RhythmicSequence rhythmicSequence);
}
