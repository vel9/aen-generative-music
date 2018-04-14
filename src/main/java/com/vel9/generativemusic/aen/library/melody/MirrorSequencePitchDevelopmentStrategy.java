package com.vel9.generativemusic.aen.library.melody;

import com.vel9.generativemusic.aen.core.melody.MelodyElement;
import com.vel9.generativemusic.aen.core.melody.MelodySequence;
import com.vel9.generativemusic.aen.core.melody.PitchDevelopmentStrategy;

import java.util.ArrayList;
import java.util.List;

public class MirrorSequencePitchDevelopmentStrategy implements PitchDevelopmentStrategy {

    /**
     * Develops the input melody sequence by "mirroring" over time and using the last note
     * of the input melody as the reflection point, this implementation only retains the
     * mirrored portion of the theme
     *
     * for example, input theme C D E becomes C D E D C
     *
     * @param melodySequence melody sequence to be developed
     * @param scaleContainer scale information with which to develop the theme
     * @return mirrored input melody sequence
     */
    @Override
    public MelodySequence develop(MelodySequence melodySequence, ScaleContainer scaleContainer) {
        List<MelodyElement> elements = melodySequence.getMelodyElements();
        List<MelodyElement> mirrored = new ArrayList<>();
        if (elements.size() < 3){
            return melodySequence; // don't remove anything if size is less than 3
        }
        // When mirroring the sequence, start iterating at the second to last item
        // as there's no need to repeat the last element twice in the resulting sequence
        for (int i = elements.size() - 2; i >= 0; i--){
            mirrored.add(elements.get(i));
        }
        return new MelodySequence(mirrored);
    }

}
