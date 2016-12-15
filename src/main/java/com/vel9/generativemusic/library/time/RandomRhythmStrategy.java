package com.vel9.generativemusic.library.time;

import com.vel9.generativemusic.core.dynamics.DynamicsStrategy;
import com.vel9.generativemusic.core.support.DurationVelocity;
import com.vel9.generativemusic.core.time.RhythmStrategy;
import com.vel9.generativemusic.core.time.RhythmicElement;
import com.vel9.generativemusic.core.time.RhythmicSequence;
import com.vel9.generativemusic.core.time.TempoStrategy;
import com.vel9.generativemusic.core.util.Log;
import com.vel9.generativemusic.core.util.Util;

import java.util.List;

/**
 * Created by levani on 12/5/16.
 */
public class RandomRhythmStrategy implements RhythmStrategy {

    private static final String TAG = RandomRhythmStrategy.class.getSimpleName();

    private TempoStrategy tempoStrategy;
    private DynamicsStrategy dynamicsStrategy;
    private List<RhythmicSequence> rhythmicSequences;

    private int sequenceIndex = 0;
    private int sequenceElementIndex = 0;

    public RandomRhythmStrategy(TempoStrategy tempoStrategy,
                                DynamicsStrategy dynamicsStrategy,
                                List<RhythmicSequence> rhythmicSequences){
        this.dynamicsStrategy = dynamicsStrategy;
        this.tempoStrategy = tempoStrategy;
        this.rhythmicSequences = rhythmicSequences;
    }

    public DurationVelocity next() {
        RhythmicSequence rhythmicSequence = this.rhythmicSequences.get(this.sequenceIndex);
        if (this.sequenceElementIndex == 0){
            Log.config(TAG, rhythmicSequence);
        }
        RhythmicElement[] elements = rhythmicSequence.getRhythmicSequence();
        RhythmicElement element = elements[this.sequenceElementIndex];
        updateIndexes(elements);

        // note that since we don't do any logic off whether the sequence is a silence or not
        final int bpm = this.tempoStrategy.getBpm();
        final int velocity = this.dynamicsStrategy.getVelocity(this.sequenceElementIndex, rhythmicSequence);

        return new DurationVelocity(element.getDuration(bpm), velocity, rhythmicSequence.isSilence());
    }

    private void updateIndexes(RhythmicElement[] elements) {
        this.sequenceElementIndex++;
        if (this.sequenceElementIndex == elements.length){
            this.sequenceElementIndex = 0; // reset
            this.sequenceIndex = Util.getRandom(0, this.rhythmicSequences.size() - 1);
        }
    }

    public boolean hasNext(){
        return true;
    }

}