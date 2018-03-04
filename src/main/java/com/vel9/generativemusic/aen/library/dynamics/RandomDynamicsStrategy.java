package com.vel9.generativemusic.aen.library.dynamics;

import com.vel9.generativemusic.aen.core.dynamics.DynamicsStrategy;
import com.vel9.generativemusic.aen.core.support.DaemonCallback;
import com.vel9.generativemusic.aen.core.support.RegularIntervalDaemon;
import com.vel9.generativemusic.aen.core.time.RhythmicSequence;
import com.vel9.generativemusic.aen.core.util.Util;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/* Picks a new random velocity at the provided rate */
public class RandomDynamicsStrategy implements DynamicsStrategy, DaemonCallback {

    private static final Logger LOG = LoggerFactory.getLogger(RandomDynamicsStrategy.class);

    /* note: this impl provides a strong accent on the start of a sequence */
    private static final int ACCENT = 10; //TODO: could return accent value from a method

    private final int minVelocity;
    private final int maxVelocity;

    private int velocity;

    public RandomDynamicsStrategy(int minVelocity, int maxVelocity, int rateInMillis){
        int maxPossibleVelicty = maxVelocity + ACCENT;
        if (minVelocity < 0 || maxPossibleVelicty > 127){
            throw new IllegalArgumentException("minVelocity must be 0 or greater, minVelocity: " + minVelocity
                    + ", maxVelocity plus ACCENT must be 127 or less, maxVelocity + ACCENT: " + maxPossibleVelicty);
        }

        this.minVelocity = minVelocity;
        this.maxVelocity = maxVelocity;
        this.velocity = getStartingVelocity();

        RegularIntervalDaemon regularIntervalDaemon = new RegularIntervalDaemon(this, rateInMillis);
        regularIntervalDaemon.start();
    }

    /* accents the first element of a rhythmic sequence */
    @Override
    public int getVelocity(int sequenceElementIndex, RhythmicSequence rhythmicSequence){
        return sequenceElementIndex == 0? this.velocity + ACCENT : this.velocity;
    }

    /* provide random starting velocity */
    private int getStartingVelocity() {
        return Util.getRandom(this.minVelocity, this.maxVelocity);
    }

    @Override
    public void call(){
        this.velocity = Util.getRandom(this.minVelocity, this.maxVelocity);
        LOG.debug("current velocity: " + this.velocity);
    }
}
