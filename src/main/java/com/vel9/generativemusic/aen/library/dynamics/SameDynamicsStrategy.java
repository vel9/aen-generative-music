package com.vel9.generativemusic.aen.library.dynamics;

import com.vel9.generativemusic.aen.core.dynamics.DynamicsStrategy;
import com.vel9.generativemusic.aen.core.time.RhythmicSequence;

/* Impl of DynamicsStrategy which simple returns the same velocity */
public class SameDynamicsStrategy implements DynamicsStrategy {

    private int velocity;

    public SameDynamicsStrategy(int velocity){
        this.velocity = velocity;
    }

    @Override
    public int getVelocity(int sequenceElementIndex, RhythmicSequence rhythmicSequence){
        return this.velocity;
    }

}
