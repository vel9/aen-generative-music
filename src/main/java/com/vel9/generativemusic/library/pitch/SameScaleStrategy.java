package com.vel9.generativemusic.library.pitch;

import com.vel9.generativemusic.core.pitch.Scale;
import com.vel9.generativemusic.core.pitch.ScaleStrategy;

/**
 * Created by levani on 12/4/16.
 */
public class SameScaleStrategy implements ScaleStrategy {

    private Scale scale;

    public SameScaleStrategy(Scale scale){
        this.scale = scale;
    }

    public Scale getScale(){
        return scale;
    }
}
