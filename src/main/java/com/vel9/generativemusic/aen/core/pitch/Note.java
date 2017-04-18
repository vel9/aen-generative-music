/*
<This Java Class is part of the jMusic API version 1.5, March 2004.>

Copyright (C) 2000 Andrew Sorensen & Andrew Brown

This program is free software; you can redistribute it and/or modify
it under the terms of the GNU General Public License as published by
the Free Software Foundation; either version 2 of the License, or any
later version.
This program is distributed in the hope that it will be useful, but
WITHOUT ANY WARRANTY; without even the implied warranty of
MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the
GNU General Public License for more details.
You should have received a copy of the GNU General Public Licens
along with this program; if not, write to the Free Software
Foundation, Inc., 675 Mass Ave, Cambridge, MA 02139, USA.
*/
package com.vel9.generativemusic.aen.core.pitch;

import com.vel9.generativemusic.aen.core.util.Log;

public class Note {

    private static final String TAG = Note.class.getSimpleName();

    private int value;

    public static Note create(NoteType noteType, int octave){
        return new Note(noteType, octave);
    }

    public Note(int value){
        this.value = value;
    }

    private Note(NoteType noteType, int octave){
        this.value = calculateNoteValue(noteType.getValue(), octave);
    }

    private int calculateNoteValue(int baseNoteValue, int octave){
        int value = baseNoteValue + (12 * octave);
        if (value < 0 || value > 127){
            throw new IllegalArgumentException("Note value can only be between 0 and 127, inclusive");
        }
        return value;
    }

    public int getValue(){
        return this.value;
    }

    public void setValue(int value){
        this.value = value;
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

    public static void main(String[] args) {
        Note note = new Note(60);
        Log.config(TAG, note);
    }

}