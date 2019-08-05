package com.vel9.generativemusic.examples.rain.library.time;

import com.vel9.generativemusic.aen.core.time.RhythmicElement;
import com.vel9.generativemusic.aen.core.time.RhythmicSequence;

import java.util.Arrays;

public enum ExampleRhythmicSequences implements RhythmicSequence {

    THREE_EIGHT(RhythmicElement.EIGHTH, RhythmicElement.EIGHTH, RhythmicElement.EIGHTH),
    THREE_EIGHT_WITH_PAUSE(RhythmicElement.EIGHTH, RhythmicElement.EIGHTH, RhythmicElement.EIGHTH_T),
    PALINDROME_FAST(RhythmicElement.SIXTEENTH, RhythmicElement.DOTTED_SIXTEENTH, RhythmicElement.SIXTEENTH),
    PALINDROME_MEDIUM(RhythmicElement.EIGHTH, RhythmicElement.SIXTEENTH, RhythmicElement.EIGHTH),
    FIVE_SIXTEENTH(RhythmicElement.SIXTEENTH,
            RhythmicElement.SIXTEENTH,
            RhythmicElement.SIXTEENTH,
            RhythmicElement.SIXTEENTH,
            RhythmicElement.SIXTEENTH);

    private RhythmicElement[] rhythmicElements;

    ExampleRhythmicSequences(RhythmicElement... rhythmicElements){
        this.rhythmicElements = rhythmicElements;
    }

    @Override
    public RhythmicElement[] getRhythmicSequence(){
        return rhythmicElements;
    }

    @Override
    public boolean isSilence(){
        return false;
    }

    @Override
    public String toString(){
        return Arrays.toString(rhythmicElements);
    }

}