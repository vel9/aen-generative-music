package com.vel9.generativemusic.aen.library.time;

import com.vel9.generativemusic.aen.core.support.DaemonCallback;
import com.vel9.generativemusic.aen.core.support.Direction;
import com.vel9.generativemusic.aen.core.support.RegularIntervalDaemon;
import com.vel9.generativemusic.aen.core.time.TempoStrategy;
import com.vel9.generativemusic.aen.core.util.Log;
import com.vel9.generativemusic.aen.core.util.Util;

/**
 * Impl of TempoStrategy which gradually moves from a min to a max temp
 * The min and max values are selected from a range of min an max values
 */
public class VariablePeakTempoStrategy implements TempoStrategy, DaemonCallback {

    private static final String TAG = VariablePeakTempoStrategy.class.getSimpleName();

    private int minBpmLower;
    private int minBpmUpper;
    private int maxBpmLower;
    private int maxBpmUpper;

    private int bpm;
    private int minBpm;
    private int maxBpm;
    
    private Direction direction;

    public VariablePeakTempoStrategy(int minBpmLower,
                                     int minBpmUpper,
                                     int maxBpmLower,
                                     int maxBpmUpper,
                                     int rateInMillis){
        
        validate(minBpmLower, minBpmUpper, maxBpmLower, maxBpmUpper);
                
        this.minBpmLower = minBpmLower;
        this.minBpmUpper = minBpmUpper;
        this.maxBpmLower = maxBpmLower;
        this.maxBpmUpper = maxBpmUpper;

        this.minBpm = getNewMinBpm();
        this.maxBpm = getNewMaxBpm();
        
        this.direction = Direction.UP;

        this.bpm = getStartingBpm();

        RegularIntervalDaemon regularIntervalDaemon = new RegularIntervalDaemon(this, rateInMillis);
        regularIntervalDaemon.start();
    }

    /* if direction is UP minBpm is used as starting point, otherwise maxBpm is used */
    private int getStartingBpm() {
        return this.direction == Direction.UP? this.minBpm : this.maxBpm;
    }

    @Override
    public int getBpm(){
        return this.bpm;
    }

    public void call(){
        // when peak is reached, set a new valley
        if (this.bpm == this.maxBpm){
            this.direction = Direction.DOWN;
            this.minBpm = getNewMinBpm();
            Log.config(TAG, "at the peak, new minBpm: " + this.minBpm);
        }
        // when valley is reached, set a new peak
        if (this.bpm == this.minBpm){
            this.direction = Direction.UP;
            this.maxBpm = getNewMaxBpm();
            Log.config(TAG, "at the valley, new maxBpm: " + this.maxBpm);
        }

        if (this.direction == Direction.UP){
            this.bpm++;
        } else {
            this.bpm--;
        }

        Log.config(TAG, "current bpm: " + this.bpm);
    }

    private int getNewMaxBpm() {
        return Util.getRandom(this.maxBpmLower, this.maxBpmUpper);
    }

    private int getNewMinBpm() {
        return Util.getRandom(this.minBpmLower, this.minBpmUpper);
    }

    private void validate(int minBpmLower,
                          int minBpmUpper,
                          int maxBpmLower,
                          int maxBpmUpper) {
        Util.state(minBpmLower <= minBpmUpper, "min lower bound must be less than or equal to min upper bound");
        Util.state(maxBpmLower <= maxBpmUpper, "max lower bound must be less than or equal to max upper bound");
        Util.state(minBpmUpper <= maxBpmLower, "min upper bound must be less than or equal to max lower bound");
    }

}
