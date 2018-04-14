package com.vel9.generativemusic.aen.library.melody;

import com.vel9.generativemusic.aen.core.melody.MelodyElement;
import com.vel9.generativemusic.aen.core.melody.MelodySequence;
import com.vel9.generativemusic.aen.core.melody.PitchDevelopmentStrategy;
import com.vel9.generativemusic.aen.core.time.RhythmicElement;
import com.vel9.generativemusic.aen.core.util.Util;

import java.util.ArrayList;
import java.util.List;

public class ShuffleRhythmPitchDevelopmentStrategy implements PitchDevelopmentStrategy {

    /**
     * Develops the provided theme by retaining all of the pitches in their input form
     * but shuffling around the rhythms so input theme 16th note C, 8th note F, quarter note E
     * may become 8th note C, quarter note F, 16th note E
     *
     * @param melodySequence melody sequence to be developed
     * @param scaleContainer scale information with which to develop the theme
     * @return developed melody sequence
     */
    @Override
    public MelodySequence develop(MelodySequence melodySequence, ScaleContainer scaleContainer) {
        List<MelodyElement> elements = melodySequence.getMelodyElements();
        if (elements.size() < 2){
            return melodySequence;
        }

        List<RhythmicElement> rhythmicElements = new ArrayList<>();
        for (MelodyElement element : elements){
            rhythmicElements.add(element.getRhythmicElement());
        }

        List<MelodyElement> elementsWithShuffledRhythms = new ArrayList<>();
        for (MelodyElement element : elements) {
            RhythmicElement rhythmicElement = rhythmicElements.remove(Util.getRandom(0, rhythmicElements.size() - 1));
            elementsWithShuffledRhythms.add(new MelodyElement(element.getNote(), rhythmicElement));
        }

        return new MelodySequence(elementsWithShuffledRhythms);
    }

}
