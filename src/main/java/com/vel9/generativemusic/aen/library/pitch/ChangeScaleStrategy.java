package com.vel9.generativemusic.aen.library.pitch;

import com.vel9.generativemusic.aen.core.pitch.Scale;
import com.vel9.generativemusic.aen.core.pitch.ScaleStrategy;
import com.vel9.generativemusic.aen.core.support.DaemonCallback;
import com.vel9.generativemusic.aen.core.support.RegularIntervalDaemon;
import com.vel9.generativemusic.aen.core.util.Util;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/* Impl of ScaleStragey which randomly selects form the provided scales at the provided rate */
public class ChangeScaleStrategy implements ScaleStrategy, DaemonCallback {

    private static final Logger LOG = LoggerFactory.getLogger(ChangeScaleStrategy.class);

    private Scale scale;
    private Scale[] scales;

    public ChangeScaleStrategy(int rateInMillis, Scale... scales){
        this.scales = scales;
        this.scale = getStartingScale();

        RegularIntervalDaemon regularIntervalDaemon = new RegularIntervalDaemon(this, rateInMillis);
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
        LOG.debug("current scale: " + this.scale);
    }
}
