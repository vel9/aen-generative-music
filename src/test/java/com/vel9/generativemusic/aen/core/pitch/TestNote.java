package com.vel9.generativemusic.aen.core.pitch;

import org.junit.Assert;
import org.junit.Test;

public class TestNote {

    // ref: https://www.midikits.net/midi_analyser/midi_note_numbers_for_octaves.htm
    @Test
    public void create_middleC_returnsMiddleCValue() {
        Note note = Note.create(NoteType.C, 5);
        Assert.assertTrue("Expected middle C value of 60", note.getValue() == 60);
    }

    @Test
    public void create_middleCSharp_returnsMiddleCSharp() {
        Note note = Note.create(NoteType.C_SHARP, 5);
        Assert.assertTrue("Expected value of 61", note.getValue() == 61);
    }

    @Test
    public void create_middleDflat_returnsMiddleDflat() {
        Note note = Note.create(NoteType.D_FLAT, 5);
        Assert.assertTrue("Expected value of 61", note.getValue() == 61);
    }

    @Test
    public void create_middleD_returnsMiddleD() {
        Note note = Note.create(NoteType.D, 5);
        Assert.assertTrue("Expected value of 62", note.getValue() == 62);
    }

    @Test
    public void create_middleDSharp_returnsMiddleDSharp() {
        Note note = Note.create(NoteType.D_SHARP, 5);
        Assert.assertTrue("Expected value of 63", note.getValue() == 63);
    }

    @Test
    public void create_middleDFlat_returnsMiddleDFlat() {
        Note note = Note.create(NoteType.E_FLAT, 5);
        Assert.assertTrue("Expected value of 63", note.getValue() == 63);
    }

    @Test
    public void create_middleE_returnsMiddleE() {
        Note note = Note.create(NoteType.E, 5);
        Assert.assertTrue("Expected value of 64", note.getValue() == 64);
    }

    @Test
    public void create_middleF_returnsMiddleF() {
        Note note = Note.create(NoteType.F, 5);
        Assert.assertTrue("Expected value of 65", note.getValue() == 65);
    }

    @Test
    public void create_middleFSharp_returnsMiddleFSharp() {
        Note note = Note.create(NoteType.F_SHARP, 5);
        Assert.assertTrue("Expected value of 66", note.getValue() == 66);
    }

    @Test
    public void create_middleGFlat_returnsMiddleGFlat() {
        Note note = Note.create(NoteType.G_FLAT, 5);
        Assert.assertTrue("Expected value of 66", note.getValue() == 66);
    }

    @Test
    public void create_middleG_returnsMiddleG() {
        Note note = Note.create(NoteType.G, 5);
        Assert.assertTrue("Expected value of 67", note.getValue() == 67);
    }

    @Test
    public void create_middleGSharp_returnsMiddleGSharp() {
        Note note = Note.create(NoteType.G_SHARP, 5);
        Assert.assertTrue("Expected value of 68", note.getValue() == 68);
    }

    @Test
    public void create_middleAFlat_returnsMiddleAFlat() {
        Note note = Note.create(NoteType.A_FLAT, 5);
        Assert.assertTrue("Expected value of 68", note.getValue() == 68);
    }

    @Test
    public void create_middleA_returnsMiddleA() {
        Note note = Note.create(NoteType.A, 5);
        Assert.assertTrue("Expected value of 69", note.getValue() == 69);
    }

    @Test
    public void create_middleASharp_returnsMiddleASharp() {
        Note note = Note.create(NoteType.A_SHARP, 5);
        Assert.assertTrue("Expected value of 70", note.getValue() == 70);
    }

    @Test
    public void create_middleBFlat_returnsMiddleBFlat() {
        Note note = Note.create(NoteType.B_FLAT, 5);
        Assert.assertTrue("Expected value of 70", note.getValue() == 70);
    }

    @Test
    public void create_middleB_returnsMiddleB() {
        Note note = Note.create(NoteType.B, 5);
        Assert.assertTrue("Expected value of 71", note.getValue() == 71);
    }

    @Test(expected = IllegalArgumentException.class)
    public void create_tooLargeValue_throwsIllegalArgumentException() {
        Note.create(128);
    }

    @Test(expected = IllegalArgumentException.class)
    public void create_tooSmall_throwsIllegalArgumentException() {
        Note.create(-1);
    }

}
