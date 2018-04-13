package com.vel9.generativemusic.aen.core.pitch;

import java.util.Objects;

public class Note {

    private int value;

    public static Note create(NoteType noteType, int octave){
        return new Note(noteType, octave);
    }

    public static Note create(int value){
        validate(value);
        return new Note(value);
    }

    public Note(int value){
        this.value = value;
    }

    private Note(NoteType noteType, int octave){
        this.value = calculateNoteValue(noteType.getValue(), octave);
    }

    private int calculateNoteValue(int baseNoteValue, int octave){
        int value = baseNoteValue + (12 * octave);
        validate(value);
        return value;
    }

    private static void validate(int value) {
        if (value < 0 || value > 127){
            throw new IllegalArgumentException("Note value can only be between 0 and 127, inclusive");
        }
    }

    public int getValue(){
        return this.value;
    }

    private String getNoteLiteralValue(){
        switch(this.value % 12){
            case 0: return "C";
            case 1: return "C# or Db";
            case 2: return "D";
            case 3: return "D# or Eb";
            case 4: return "E";
            case 5: return "F";
            case 6: return "F# or Gb";
            case 7: return "G";
            case 8: return "G# or Ab";
            case 9: return "A";
            case 10: return "A# or Bb";
            case 11: return "B";
        }
        return null;
    }

    @Override
    public String toString(){
        return "[Note value: " + String.valueOf(this.value) + ", " + getNoteLiteralValue() + "]";
    }

    @Override
    public boolean equals(Object other){
        // ref: https://www.sitepoint.com/implement-javas-equals-method-correctly/
        // self check
        if (this == other) {
            return true;
        }
        // null check
        if (other == null) {
            return false;
        }
        // type check and cast
        if (getClass() != other.getClass()) {
            return false;
        }
        Note otherNote = (Note) other;
        return Objects.equals(this.getValue(), otherNote.getValue());
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.getValue());
    }

}