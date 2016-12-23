package com.vel9.generativemusic.library.dynamics;

import com.vel9.generativemusic.core.dynamics.DynamicsStrategy;
import com.vel9.generativemusic.core.time.RhythmicSequence;

/* Impl of DynamicsStrategy which simple returns the same velocity */
public class SameDynamicsStrategy implements DynamicsStrategy {

    private int velocity;

    public SameDynamicsStrategy(int velocity){
        this.velocity = velocity;
    }

    public int getVelocity(int sequenceElementIndex, RhythmicSequence rhythmicSequence){
        return this.velocity;
    }

}
