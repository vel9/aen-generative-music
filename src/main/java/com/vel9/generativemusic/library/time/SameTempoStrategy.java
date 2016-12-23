package com.vel9.generativemusic.library.time;

import com.vel9.generativemusic.core.time.TempoStrategy;

/* Impl of TempoStrategy which simple returns the same tempo */
public class SameTempoStrategy implements TempoStrategy {

    private static final String TAG = SameTempoStrategy.class.getSimpleName();

    private int bpm;

    public SameTempoStrategy(int bpm){
        this.bpm = bpm;
    }

    @Override
    public int getBpm(){
        return this.bpm;
    }

}
