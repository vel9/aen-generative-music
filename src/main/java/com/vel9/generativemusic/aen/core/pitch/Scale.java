package com.vel9.generativemusic.aen.core.pitch;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * When provided with the base scale (which is 12 pitches or less), and parameters
 * such as min note, max note, and the first note of scale, this class
 * returns a list of all possible notes given the parameters.
 */
public class Scale {

    private static final String TAG = Scale.class.getSimpleName();

    private final NoteType[] baseNotes;
    private final List<Note> allNotes;
    private final ScaleType scaleType;

    public static Scale createTransposingScale(BaseScale baseScale, NoteType startingNote, int minNote, int maxNote){
        return new Scale(baseScale, startingNote, minNote, maxNote);
    }

    public static Scale createNonTransposingScale(int... noteVals){
        if (noteVals == null || noteVals.length == 0){
            throw new IllegalArgumentException("Need at least one note");
        }
        return new Scale(noteVals);
    }

    //TODO: reduce visibility
    public Scale(BaseScale baseScale, NoteType startingNote, int minNote, int maxNote){
        this.scaleType = ScaleType.TRANSPOSING;
        this.baseNotes = baseScale.getBaseNotes();
        this.allNotes = buildAllNotes(baseNotes, startingNote, minNote, maxNote);
    }

    //TODO: reduce visibility
    public Scale(int... noteVals){
        this.scaleType = ScaleType.NONTRANSPOSING;
        this.baseNotes = null;
        this.allNotes = buildFixedNotes(noteVals);
    }

    /* builds a list of all notes in this scale */
    private List<Note> buildAllNotes(NoteType[] baseNotes, NoteType startingNote, int minNoteVal, int maxNoteVal) {
        /* if desired scale is A Major, starting note would be NoteType.A */
        int offset = startingNote.getValue() - baseNotes[0].getValue();
        List<Note> allNotes = new ArrayList<>();
        // i represents current octave
        for (int i = 0; i <= 10; i++){
            for (NoteType noteType : baseNotes){
                int noteVal = noteType.getValue() + (i * 12); // 12 represents number of pitches in an octave (think base12)
                final int noteValWithOffset = noteVal + offset;
                if (noteValWithOffset >= minNoteVal && noteValWithOffset <= maxNoteVal) {
                    // time: because we're starting at offset B major for example won't have
                    // any lower time in the lowest octave
                    allNotes.add(new Note(noteValWithOffset));
                }
            }
        }
        return allNotes;
    }

    private List<Note> buildFixedNotes(int... noteVals){
        List<Note> fixedNotes = new ArrayList<>();
        for (int noteVal : noteVals){
            fixedNotes.add(new Note(noteVal));
        }
        return fixedNotes;
    }

    public static Scale buildScaleFromNotes(List<Note> notes){
        int[] noteVals = new int[notes.size()];
        for (int i = 0; i < notes.size(); i++){
            noteVals[i] = notes.get(0).getValue();
        }
        return createNonTransposingScale(noteVals);
    }

    public int scaleSize(){
        if (this.scaleType == ScaleType.NONTRANSPOSING){
            return allNotes.size();
        } else if (this.scaleType == ScaleType.TRANSPOSING){
            return baseNotes.length;
        } else {
            throw new IllegalStateException("Provided scale type has not been implemented");
        }
    }

    public ScaleType getScaleType(){
        return this.scaleType;
    }

    public List<Note> getNotes(){
        return allNotes;
    }

    @Override
    public String toString(){
        return "baseNotes: " + Arrays.toString(this.baseNotes) + ", all Notes: " + getNotes();
    }

}
