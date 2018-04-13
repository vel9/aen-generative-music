package com.vel9.generativemusic.aen.core.melody;

import com.vel9.generativemusic.aen.core.pitch.Note;
import com.vel9.generativemusic.aen.core.time.RhythmicElement;
import com.vel9.generativemusic.aen.core.util.Util;

import java.util.ArrayList;
import java.util.List;

/**
 * A grouping of melody elements representing a melody, theme or a melodic sequence
 */
public class MelodySequence {

    private List<MelodyElement> melodyElements;

    public MelodySequence(List<MelodyElement> melodyElements){
        Util.state(melodyElements != null && melodyElements.size() > 1, "Must provide more than 1 element");
        this.melodyElements = melodyElements;
    }

    /* Provides a copy of the local list */
    public List<MelodyElement> getMelodyElements() {
        List<MelodyElement> melodyElementsCopy = new ArrayList<>();
        melodyElementsCopy.addAll(this.melodyElements);
        return melodyElementsCopy;
    }

    public int[] getRelativeIntervalSequence() {
        return findRelativeIntervalSequence(this.melodyElements);
    }

    public static MelodySequence buildMelodySequence(int[] noteVals, RhythmicElement[] rhythmicElements){
        Util.state(noteVals.length == rhythmicElements.length, "noteVals and rhythmicElements must have same length");
        List<MelodyElement> elements = new ArrayList<>();
        for (int i = 0; i < noteVals.length; i++){
            elements.add(new MelodyElement(Note.create(noteVals[i]),
                    rhythmicElements[i]));
        }
        return new MelodySequence(elements);
    }

    /* find the relative internal sequence of the melody sequence, starting with 0 */
    static int[] findRelativeIntervalSequence(List<MelodyElement> elements) {
        int[] relativeIntervalDiff = new int[elements.size()];
        relativeIntervalDiff[0] = 0; // just being explicit
        for (int i = 1; i < elements.size(); i++){
            int diff = elements.get(i).getNote().getValue() - elements.get(i - 1).getNote().getValue();
            relativeIntervalDiff[i] = diff;
        }
        return relativeIntervalDiff;
    }

    @Override
    public String toString(){
        return this.melodyElements.toString();
    }
}
