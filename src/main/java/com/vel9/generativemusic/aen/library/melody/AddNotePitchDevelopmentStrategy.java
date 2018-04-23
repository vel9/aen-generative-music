package com.vel9.generativemusic.aen.library.melody;

import com.vel9.generativemusic.aen.core.melody.MelodyElement;
import com.vel9.generativemusic.aen.core.melody.MelodySequence;
import com.vel9.generativemusic.aen.core.melody.PitchDevelopmentStrategy;
import com.vel9.generativemusic.aen.core.pitch.Note;
import com.vel9.generativemusic.aen.core.util.Util;
import com.vel9.generativemusic.aen.library.pitch.PlainchantNoteStrategy;
import com.vel9.generativemusic.aen.library.pitch.RandomDirectionalJumpSelector;
import org.apache.commons.lang3.Validate;

import java.util.ArrayList;
import java.util.List;

public class AddNotePitchDevelopmentStrategy implements PitchDevelopmentStrategy {

    private int maxNumNotesToAdd;

    public AddNotePitchDevelopmentStrategy(int maxNumNotesToAdd){
        Validate.validState(maxNumNotesToAdd > 0, "maxNumNotesToAdd must be greater than 0");
        this.maxNumNotesToAdd = maxNumNotesToAdd;
    }

    /**
     * Develops the provided theme by adding 1 to maxNumNotesToAdd notes to the
     * input melody sequence at a randomly select point in the sequence
     *
     * @param melodySequence melody sequence to be developed
     * @param scaleContainer scale information with which to develop the theme
     * @return developed melody sequence
     */
    @Override
    public MelodySequence develop(MelodySequence melodySequence, ScaleContainer scaleContainer) {
        List<MelodyElement> elements = melodySequence.getMelodyElements();

        // get the index from which to develop
        int randomIndex = Util.getRandom(0, elements.size() - 1);
        MelodyElement anchorMelodyElement = elements.get(randomIndex);

        List<MelodyElement> developedElements = new ArrayList<>();
        for (int i = 0; i <= randomIndex; i++){
            developedElements.add(elements.get(i));
        }

        RandomDirectionalJumpSelector randomSelector = new RandomDirectionalJumpSelector(
                scaleContainer.getBaseScale().getBaseNotes().length - 1,
                anchorMelodyElement.getNote(),
                PlainchantNoteStrategy.getBalancedRandomIntervalSequence());

        int numNotesToAdd = Util.getRandom(1, this.maxNumNotesToAdd);
        for (int i = 0; i < numNotesToAdd; i++){
            Note nextNote = randomSelector.next(scaleContainer.getNotes());
            developedElements.add(new MelodyElement(nextNote, null));
        }

        for (int i = randomIndex + 1; i < elements.size(); i++){
            developedElements.add(elements.get(i));
        }

        return new MelodySequence(developedElements);
    }

}
