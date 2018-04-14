package com.vel9.generativemusic.aen.library.dynamics;

import com.vel9.generativemusic.aen.core.dynamics.DynamicsStrategy;
import com.vel9.generativemusic.aen.core.support.DaemonCallback;
import com.vel9.generativemusic.aen.core.support.Direction;
import com.vel9.generativemusic.aen.core.support.RegularIntervalDaemon;
import com.vel9.generativemusic.aen.core.time.RhythmicSequence;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Impl of DynamicsStrategy which gradually moves from provided min to max, max to min values
 * at the given rate.
 */
public class GradualDynamicsStrategy implements DynamicsStrategy, DaemonCallback {

    private static final Logger LOG = LoggerFactory.getLogger(GradualDynamicsStrategy.class);

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
    @Override
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

        LOG.trace("current velocity: " + this.velocity);
    }
}
