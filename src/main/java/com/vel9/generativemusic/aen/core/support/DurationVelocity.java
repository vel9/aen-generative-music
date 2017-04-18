package com.vel9.generativemusic.aen.core.support;

/* Container for holding duration, velocity values and the silent indicator */
public class DurationVelocity {

    private int duration;
    private int velocity;
    private boolean silence;

    public DurationVelocity(int duration, int velocity, boolean silence){
        this.duration = duration;
        this.velocity = velocity;
        this.silence = silence;
    }

    public int getDuration(){
        return this.duration;
    }

    public int getVelocity(){
        return this.velocity;
    }

    public boolean isSilence() { return this.silence; }
}
