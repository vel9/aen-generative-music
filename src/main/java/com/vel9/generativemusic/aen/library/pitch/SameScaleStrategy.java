package com.vel9.generativemusic.aen.library.pitch;

import com.vel9.generativemusic.aen.core.pitch.Scale;
import com.vel9.generativemusic.aen.core.pitch.ScaleStrategy;

/* Impl of ScaleStrategy which simple returns the same scale */
public class SameScaleStrategy implements ScaleStrategy {

    private Scale scale;

    public SameScaleStrategy(Scale scale){
        this.scale = scale;
    }

    public Scale getScale(){
        return scale;
    }
}
