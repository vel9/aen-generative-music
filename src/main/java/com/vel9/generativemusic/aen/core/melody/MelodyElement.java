package com.vel9.generativemusic.aen.core.melody;

import com.vel9.generativemusic.aen.core.pitch.Note;
import com.vel9.generativemusic.aen.core.time.RhythmicElement;

/**
 * Container for Note and its associated RhythmicElement
 */
public class MelodyElement {

    private Note note;
    private RhythmicElement rhythmicElement;

    public MelodyElement(Note note, RhythmicElement rhythmicElement){
        this.note = note;
        this.rhythmicElement = rhythmicElement;
    }

    public Note getNote() {
        return note;
    }

    public RhythmicElement getRhythmicElement() {
        return rhythmicElement;
    }

    public boolean hasRhythmicElement(){
        return rhythmicElement != null;
    }

    @Override
    public String toString(){
        return "MelodyElement: [" + this.note + ", " + this.rhythmicElement  + "]";
    }

}
