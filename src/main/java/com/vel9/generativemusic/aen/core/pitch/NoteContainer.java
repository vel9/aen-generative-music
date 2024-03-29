package com.vel9.generativemusic.aen.core.pitch;

import com.vel9.generativemusic.aen.core.support.DurationVelocity;

/**
 * Provides a holder class for all of the information which is required
 * in order to create a complete MIDI message, in addition to providing
 * the time for how long a note should be played.
 */
public class NoteContainer {
    private Note note;
    private DurationVelocity durationVelocity;

    public NoteContainer(Note note, DurationVelocity durationVelocity){
        this.note = note;
        this.durationVelocity = durationVelocity;
    }

    public Note getNote(){
        return this.note;
    }

    public DurationVelocity getDurationVelocity(){
        return this.durationVelocity;
    }

    @Override
    public String toString(){
        return note.toString() + " " + durationVelocity.toString();
    }

}
