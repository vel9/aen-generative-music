package com.vel9.generativemusic.core.pitch;

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

    public Scale(BaseScale baseScale, NoteType startingNote, int minNote, int maxNote){
        this.baseNotes = baseScale.getBaseNotes();
        this.allNotes = buildAllNotes(baseNotes, startingNote, minNote, maxNote);
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

    public int scaleSize(){
        return baseNotes.length;
    }

    public List<Note> getAllNotes(){
        return allNotes;
    }

    public static void main(String[] args) {
        Scale scale = new Scale(BaseScale.MAJOR, NoteType.A, 0, 127);
        System.out.println(scale.getAllNotes());
    }

    @Override
    public String toString(){
        return Arrays.toString(this.baseNotes);
    }
}
