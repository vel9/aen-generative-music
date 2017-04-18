package com.vel9.generativemusic.aen.library.time;

import com.vel9.generativemusic.aen.core.support.DaemonCallback;
import com.vel9.generativemusic.aen.core.support.Direction;
import com.vel9.generativemusic.aen.core.support.RegularIntervalDaemon;
import com.vel9.generativemusic.aen.core.time.TempoStrategy;

/**
 * Impl of TempoStrategy which gradually moves from provided min to max, max to min values
 * at the given rate.
 */
public class GradualTempoStrategy implements TempoStrategy, DaemonCallback {

    private static final String TAG = GradualTempoStrategy.class.getSimpleName();

    private final int minBpm;
    private final int maxBpm;
    private Direction direction;

    private int bpm;

    public GradualTempoStrategy(int minBpm, int maxBpm, Direction direction, int rateInMillis){
        this.minBpm = minBpm;
        this.maxBpm = maxBpm;
        this.direction = direction;

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
        if (this.bpm == this.maxBpm){
            this.direction = Direction.DOWN;
        }
        if (this.bpm == this.minBpm){
            this.direction = Direction.UP;
        }

        if (this.direction == Direction.UP){
            this.bpm++;
        } else {
            this.bpm--;
        }
    }

}
