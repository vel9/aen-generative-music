package com.vel9.generativemusic.core.pitch;

import com.vel9.generativemusic.core.support.DurationVelocity;

/**
 * Created by levani on 12/6/16.
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
}
