package com.vel9.generativemusic.aen.library.melody;

import com.vel9.generativemusic.aen.core.melody.MelodyElement;
import com.vel9.generativemusic.aen.core.melody.PitchDevelopmentStrategy;
import com.vel9.generativemusic.aen.core.melody.MelodySequence;
import com.vel9.generativemusic.aen.core.util.Util;

import java.util.List;

public class RemoveSingleNotePitchDevelopmentStrategy implements PitchDevelopmentStrategy {

    /**
     * Develops the input theme by removing a random single note
     *
     * @param melodySequence melody sequence to be developed
     * @param scaleContainer scale information with which to develop the theme
     * @return developed input theme
     */
    @Override
    public MelodySequence develop(MelodySequence melodySequence, ScaleContainer scaleContainer) {
        List<MelodyElement> elements = melodySequence.getMelodyElements();
        if (elements.size() < 3){
            return melodySequence; // don't remove anything if size is less than 3
        }

        int randomIndex = Util.getRandom(0, elements.size() - 1);
        elements.remove(randomIndex);
        return new MelodySequence(elements);
    }

}
