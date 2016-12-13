package com.vel9.generativemusic.library.time;

import com.vel9.generativemusic.core.time.RhythmicElement;
import com.vel9.generativemusic.core.time.RhythmicSequence;

import java.util.Arrays;

/**
 * Created by levani on 12/12/16.
 */
public enum SilentRhythmicSequence implements RhythmicSequence {
    QUADRUPLE_WHOLE_SILENCE(RhythmicElement.WHOLE, RhythmicElement.WHOLE, RhythmicElement.WHOLE, RhythmicElement.WHOLE),
    TRIPLE_WHOLE_SILENCE(RhythmicElement.WHOLE, RhythmicElement.WHOLE, RhythmicElement.WHOLE),
    DOUBLE_WHOLE_SILENCE(RhythmicElement.WHOLE, RhythmicElement.WHOLE),
    WHOLE_SILENCE(RhythmicElement.WHOLE),
    HALF_SILENCE(RhythmicElement.HALF),
    DOTTED_HALF_SILENCE(RhythmicElement.DOTTED_HALF),
    QUARTER_SILENCE(RhythmicElement.QUARTER),
    DOTTED_QUARTER_SILENCE(RhythmicElement.DOTTED_QUARTER),
    EIGHTH_SILENCE(RhythmicElement.EIGHTH),
    DOTTED_EIGHTH_SILENCE(RhythmicElement.DOTTED_EIGHTH),
    SIXTEENTH_SILENCE(RhythmicElement.SIXTEENTH),
    DOTTED_SIXTEENTH_SILENCE(RhythmicElement.DOTTED_SIXTEENTH),
    THIRYSECOND_SILENCE(RhythmicElement.THIRYSECOND);

    private RhythmicElement[] rhythmicElements;

    SilentRhythmicSequence(RhythmicElement... rhythmicElements){
        this.rhythmicElements = rhythmicElements;
    }

    @Override
    public RhythmicElement[] getRhythmicSequence(){
        return rhythmicElements;
    }

    @Override
    public boolean isSilence(){
        return true;
    }

    @Override
    public String toString(){
        return Arrays.toString(rhythmicElements) + ", silence: " + isSilence();
    }
}
