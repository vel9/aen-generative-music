package com.vel9.generativemusic.aen.core.melody;

import com.vel9.generativemusic.aen.core.pitch.Note;
import com.vel9.generativemusic.aen.core.time.RhythmicElement;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TestMelodySequence {

    @Test
    public void findRelativeIntervalSequence_threeNoteSequence_returnsRelativeDifference(){
        List<MelodyElement> elements = new ArrayList<>();
        elements.add(new MelodyElement(Note.create(0), RhythmicElement.EIGHTH));
        elements.add(new MelodyElement(Note.create(3), RhythmicElement.DOTTED_QUARTER));
        elements.add(new MelodyElement(Note.create(2), RhythmicElement.SIXTEENTH));

        int[] relativeIntervalSeq = MelodySequence.findRelativeIntervalSequence(elements);
        Assert.assertTrue(Arrays.equals(relativeIntervalSeq, new int[]{0, 3, -1}));
    }

    @Test
    public void findRelativeIntervalSequence_fourNoteSequence_returnsRelativeDifference(){
        List<MelodyElement> elements = new ArrayList<>();
        elements.add(new MelodyElement(Note.create(0), RhythmicElement.EIGHTH));
        elements.add(new MelodyElement(Note.create(6), RhythmicElement.DOTTED_QUARTER));
        elements.add(new MelodyElement(Note.create(7), RhythmicElement.SIXTEENTH));
        elements.add(new MelodyElement(Note.create(4), RhythmicElement.SIXTEENTH));

        int[] relativeIntervalSeq = MelodySequence.findRelativeIntervalSequence(elements);
        Assert.assertTrue(Arrays.equals(relativeIntervalSeq, new int[]{0, 6, 1, -3}));
    }
}
