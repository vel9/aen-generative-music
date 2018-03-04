package com.vel9.generativemusic.aen.library.dynamics;

import com.vel9.generativemusic.aen.core.dynamics.DynamicsStrategy;
import com.vel9.generativemusic.aen.core.support.DaemonCallback;
import com.vel9.generativemusic.aen.core.support.Direction;
import com.vel9.generativemusic.aen.core.support.RegularIntervalDaemon;
import com.vel9.generativemusic.aen.core.time.RhythmicSequence;
import com.vel9.generativemusic.aen.core.util.Util;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Impl of DynamicsStrategy which gradually moves from provided min to max, max to min values
 * at the given rate.
 *
 * Each time a min or max is reached, a new min or max value is selected from a provided range
 */
public class VariablePeakDynamicsStrategy implements DynamicsStrategy, DaemonCallback {

    private static final Logger LOG = LoggerFactory.getLogger(VariablePeakDynamicsStrategy.class);

    private static final int ACCENT = 5;

    private int minVelocityLower;
    private int minVelocityUpper;
    private int maxVelocityLower;
    private int maxVelocityUpper;

    private int velocity;
    private int minVelocity;
    private int maxVelocity;

    private Direction direction;

    public VariablePeakDynamicsStrategy(int minVelocityLower,
                                        int minVelocityUpper,
                                        int maxVelocityLower,
                                        int maxVelocityUpper,
                                        int rateInMillis){
        validate(minVelocityLower, minVelocityUpper, maxVelocityLower, maxVelocityUpper);

        this.minVelocityLower = minVelocityLower;
        this.minVelocityUpper = minVelocityUpper;
        this.maxVelocityLower = maxVelocityLower;
        this.maxVelocityUpper = maxVelocityUpper;

        this.minVelocity = getNewMinVelocity();
        this.maxVelocity = getNewMaxVelocity();

        this.direction = Direction.UP;

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
        // when peak is reached, set a new valley
        if (this.velocity == this.maxVelocity){
            this.direction = Direction.DOWN;
            this.minVelocity = getNewMinVelocity();
            LOG.debug("at the peak, new minVelocity: " + this.minVelocity);
        }
        // when valley is reached, set a new peak
        if (this.velocity == this.minVelocity){
            this.direction = Direction.UP;
            this.maxVelocity = getNewMaxVelocity();
            LOG.debug("at the valley, new maxVelocity: " + this.maxVelocity);
        }

        if (this.direction == Direction.UP){
            this.velocity++;
        } else {
            this.velocity--;
        }

        LOG.debug("current velocity: " + this.velocity);
    }

    private int getNewMaxVelocity() {
        return Util.getRandom(this.maxVelocityLower, this.maxVelocityUpper);
    }

    private int getNewMinVelocity() {
        return Util.getRandom(this.minVelocityLower, this.minVelocityUpper);
    }

    private void validate(int minVelocityLower,
                          int minVelocityUpper,
                          int maxVelocityLower,
                          int maxVelocityUpper) {
        Util.state(minVelocityLower <= minVelocityUpper, "min lower bound must be less than or equal to min upper bound");
        Util.state(maxVelocityLower <= maxVelocityUpper, "max lower bound must be less than or equal to max upper bound");
        Util.state(minVelocityUpper <= maxVelocityLower, "min upper bound must be less than or equal to max lower bound");
    }

}
