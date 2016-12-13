package com.vel9.generativemusic.library.pitch;

import com.vel9.generativemusic.core.pitch.Scale;
import com.vel9.generativemusic.core.pitch.ScaleStrategy;
import com.vel9.generativemusic.core.support.DaemonCallback;
import com.vel9.generativemusic.core.support.RegularIntervalDaemon;
import com.vel9.generativemusic.core.util.Log;
import com.vel9.generativemusic.core.util.Util;

/**
 * Created by levani on 12/9/16.
 */
public class ChangeScaleStrategy implements ScaleStrategy, DaemonCallback {

    private static final String TAG = ChangeScaleStrategy.class.getSimpleName();

    private Scale scale;
    private Scale[] scales;
    private RegularIntervalDaemon regularIntervalDaemon;

    public ChangeScaleStrategy(int rateInMillis, Scale... scales){
        this.scales = scales;
        this.scale = getStartingScale();

        this.regularIntervalDaemon = new RegularIntervalDaemon(this, rateInMillis);
        regularIntervalDaemon.start();
    }

    public Scale getScale(){
        return this.scale;
    }

    /* if direction is UP minVelocity is used as starting point, otherwise maxVelocity is used */
    private Scale getStartingScale() {
        return this.scales[0];
    }

    public void call(){
        this.scale = this.scales[Util.getRandom(0, this.scales.length - 1)];
        Log.config(TAG, "current scale: " + this.scale);
    }
}
