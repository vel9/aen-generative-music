package com.vel9.generativemusic.library.dynamics;

import com.vel9.generativemusic.core.dynamics.DynamicsStrategy;
import com.vel9.generativemusic.core.support.DaemonCallback;
import com.vel9.generativemusic.core.support.Direction;
import com.vel9.generativemusic.core.support.RegularIntervalDaemon;
import com.vel9.generativemusic.core.time.RhythmicSequence;
import com.vel9.generativemusic.core.util.Log;

/**
 * Impl of DynamicsStrategy which gradually moves from provided min to max, max to min values
 * at the given rate.
 */
public class GradualDynamicsStrategy implements DynamicsStrategy, DaemonCallback {

    private static final String TAG = GradualDynamicsStrategy.class.getSimpleName();

    private static final int ACCENT = 5;

    private int velocity;
    private int minVelocity;
    private int maxVelocity;
    private Direction direction;

    public GradualDynamicsStrategy(int minVelocity, int maxVelocity, Direction direction, int rateInMillis){
        this.minVelocity = minVelocity;
        this.maxVelocity = maxVelocity;
        this.direction = direction;

        this.velocity = getStartingVelocity();

        RegularIntervalDaemon regularIntervalDaemon = new RegularIntervalDaemon(this, rateInMillis);
        regularIntervalDaemon.start();
    }

    /* accents the first element of a rhythmic sequence */
    public int getVelocity(int sequenceElementIndex, RhythmicSequence rhythmicSequence){
        return sequenceElementIndex == 0? this.velocity + ACCENT : this.velocity;
    }

    /* if direction is UP minVelocity is used as starting point, otherwise maxVelocity is used */
    private int getStartingVelocity() {
        return this.direction == Direction.UP? this.minVelocity : this.maxVelocity;
    }

    @Override
    public void call(){
        if (this.velocity == this.maxVelocity){
            this.direction = Direction.DOWN;
        }
        if (this.velocity == this.minVelocity){
            this.direction = Direction.UP;
        }

        if (this.direction == Direction.UP){
            this.velocity++;
        } else {
            this.velocity--;
        }

        Log.config(TAG, "current velocity: " + this.velocity);
    }
}
