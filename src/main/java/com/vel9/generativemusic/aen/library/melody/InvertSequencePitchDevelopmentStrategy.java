package com.vel9.generativemusic.aen.library.melody;

import com.vel9.generativemusic.aen.core.melody.MelodyElement;
import com.vel9.generativemusic.aen.core.melody.MelodySequence;
import com.vel9.generativemusic.aen.core.melody.PitchDevelopmentStrategy;
import com.vel9.generativemusic.aen.core.pitch.Note;

import java.util.ArrayList;
import java.util.List;

public class InvertSequencePitchDevelopmentStrategy implements PitchDevelopmentStrategy {

    private int minNote;
    private int maxNote;

    public InvertSequencePitchDevelopmentStrategy(int minNote, int maxNote){
        this.minNote = minNote;
        this.maxNote = maxNote;
    }

    /**
     * Develops the input melody sequence by inverting its intervals,
     * if the first interval was a major third up, the first interval will
     * now be major third down
     *
     * If the inversion takes the input melody sequence outside the min/max allowable range
     * then the development is abandoned and the input sequence is returned unchanged
     *
     * @param melodySequence melody sequence to be developed
     * @param scaleContainer scale information with which to develop the theme
     * @return developed melody sequence
     */
    @Override
    public MelodySequence develop(MelodySequence melodySequence, ScaleContainer scaleContainer) {
        List<MelodyElement> elements = melodySequence.getMelodyElements();
        int[] relativeIntervalSequence = melodySequence.getRelativeIntervalSequence();
        List<MelodyElement> inverted = new ArrayList<>();
        MelodyElement startingElement = elements.get(0);
        int lastValue = startingElement.getNote().getValue();
        inverted.add(startingElement);
        for (int i = 1; i < elements.size(); i++){
            MelodyElement element = elements.get(i);;
            int invertedValue = lastValue + relativeIntervalSequence[i] * -1;
            if (invertedValue < this.minNote || invertedValue > this.maxNote){
                return melodySequence;
            }
            inverted.add(new MelodyElement(Note.create(invertedValue), element.getRhythmicElement()));
            lastValue = invertedValue;
        }
        return new MelodySequence(inverted);
    }

}
