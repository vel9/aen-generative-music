package com.vel9.generativemusic.aen.library.melody;

import com.vel9.generativemusic.aen.TestHelperUtils;
import com.vel9.generativemusic.aen.core.melody.MelodySequence;
import com.vel9.generativemusic.aen.core.pitch.BaseScale;
import com.vel9.generativemusic.aen.core.pitch.Note;
import com.vel9.generativemusic.aen.core.pitch.NoteType;
import com.vel9.generativemusic.aen.core.pitch.Scale;
import org.junit.Assert;
import org.junit.Test;

import java.util.List;

public class TestStartingNoteProviderStrategy {

    @Test
    public void getPossibleStartingNotes_cScaleStart_returnsCFandGStartingNotes(){
        int[] relativeIntervalSeq = new int[]{0, 2, 2};
        int minNote = 60;
        int maxNote = 71;
        Scale scale = Scale.createTransposingScale(BaseScale.MAJOR, NoteType.C, minNote, maxNote);
        List<Note> startingNotes = StartingNoteProviderStrategy.getPossibleStartingNotes(scale.getNotes(), relativeIntervalSeq, 0, 127);

        boolean hasCStartingNote = startingNotes.get(0).getValue() == 60;
        boolean hasFStartingNote = startingNotes.get(1).getValue() == 65;
        boolean hasGStartingNote = startingNotes.get(2).getValue() == 67;

        Assert.assertTrue(hasCStartingNote && hasFStartingNote && hasGStartingNote);
    }

    @Test
    public void getPossibleStartingNotes_cScaleStart_returnsCFandGStartingNotesAcrossTwoOctaves(){
        int[] relativeIntervalSeq = new int[]{0, 2, 1}; // minor sequence
        int minNote = 60;
        int maxNote = 72;
        Scale scale = Scale.createTransposingScale(BaseScale.MAJOR, NoteType.C, minNote, maxNote);
        List<Note> startingNotes = StartingNoteProviderStrategy.getPossibleStartingNotes(scale.getNotes(), relativeIntervalSeq, 0, 127);

        boolean hasDStartingNote = startingNotes.get(0).getValue() == 62;
        boolean hasAStartingNote = startingNotes.get(1).getValue() == 69;

        Assert.assertTrue(hasDStartingNote && hasAStartingNote);
    }

    @Test
    public void buildMelodySequenceAtNote_twoNoteSequence_returnsTransposedSequence(){
        MelodySequence sequence = TestHelperUtils.getSequence(1, 2, 3);
        MelodySequence result = StartingNoteProviderStrategy.buildMelodySequenceAtNote(Note.create(60), sequence);
        MelodySequence target = TestHelperUtils.getSequence(60, 61, 62);
        Assert.assertTrue(TestHelperUtils.resultEquals(result, target));
    }

}
