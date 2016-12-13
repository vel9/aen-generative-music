package com.vel9.generativemusic.library.dynamics;

import com.vel9.generativemusic.core.dynamics.DynamicsStrategy;
import com.vel9.generativemusic.core.time.RhythmicSequence;

/**
 * Created by levani on 12/6/16.
 */
public class SameDynamicsStrategy implements DynamicsStrategy {

    private int velocity;

    public SameDynamicsStrategy(int velocity){
        this.velocity = velocity;
    }

    public int getVelocity(int sequenceElementIndex, RhythmicSequence rhythmicSequence){
        return this.velocity;
    }

}
