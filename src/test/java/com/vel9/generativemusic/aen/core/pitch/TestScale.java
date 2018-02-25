package com.vel9.generativemusic.aen.core.pitch;

import org.junit.Assert;
import org.junit.Test;

import java.util.List;

public class TestScale {

    @Test
    public void createNonTransposingScale_twoValues_returnsInputVales(){
        Scale scale = Scale.createNonTransposingScale(10, 11);
        List<Note> notes = scale.getNotes();
        Note note1 = notes.get(0);
        Note note2 = notes.get(1);
        Assert.assertTrue("Expected note values of 10 and 11",
                note1.getValue() == 10 && note2.getValue() == 11);
    }

    @Test
    public void createNonTransposingScale_twoValues_returnsSizeOfTwo(){
        Scale scale = Scale.createNonTransposingScale(10, 11);
        Assert.assertTrue("Expected size of 2", scale.scaleSize() == 2);
    }

    @Test
    public void createTransposingScale_transposingCScale_returnsSizeOfSeven(){
        Scale scale = Scale.createTransposingScale(BaseScale.MAJOR, NoteType.C, 60, 71);
        Assert.assertTrue("Expected size of 7", scale.scaleSize() == 7);
    }

    @Test
    public void createTransposingScale_twoOctaveTransposingCScale_returnsSizeOf7(){
        Scale scale = Scale.createTransposingScale(BaseScale.MAJOR, NoteType.C, 60, 84);
        Assert.assertTrue("Expected size of 7", scale.scaleSize() == 7);
    }

    @Test
    public void createTransposingScale_cMajorInMiddleC_hasExpectedCScaleNotes(){
        Scale scale = Scale.createTransposingScale(BaseScale.MAJOR, NoteType.C, 60, 71);
        Assert.assertTrue("Expected scale to contain C major notes",
                containsNotes(scale, 60, 62, 64, 65, 67, 69, 71));
    }

    @Test
    public void createTransposingScale_cMajorInMiddleCAndOneExtraOctave_hasExpectedCScaleNotes(){
        Scale scale = Scale.createTransposingScale(BaseScale.MAJOR, NoteType.C, 60, 84);
        Assert.assertTrue("Expected scale to contain C major notes",
                containsNotes(scale, 60, 62, 64, 65, 67, 69, 71, 72, 74, 76, 77, 79, 81, 83, 84));
    }

    @Test
    public void createTransposingScale_cMinorInMiddleC_hasExpectedCMinorcaleNotes(){
        Scale scale = Scale.createTransposingScale(BaseScale.MINOR, NoteType.C, 60, 71);
        Assert.assertTrue("Expected scale to contain C major notes",
                containsNotes(scale, 60, 62, 63, 65, 67, 68, 70));
    }

    @Test
    public void createTransposingScale_aMinorInC4_hasExpectedAMinorScaleNotes(){
        Scale scale = Scale.createTransposingScale(BaseScale.MINOR, NoteType.A, 69, 79);
        Assert.assertTrue("Expected scale to contain A minor notes",
                containsNotes(scale, 69, 71, 72, 74, 76, 77, 79));
    }

    private static boolean containsNotes(Scale scale, int... values){
        for (int value : values){
            boolean foundNote = false;
            for (Note note : scale.getNotes()){
                if (note.getValue() == value){
                    foundNote = true;
                    break;
                }
            }
            if (!foundNote){
                return false;
            }
        }

        return true;
    }
}
