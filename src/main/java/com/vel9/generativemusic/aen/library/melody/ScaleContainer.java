package com.vel9.generativemusic.aen.library.melody;

import com.vel9.generativemusic.aen.core.pitch.BaseScale;
import com.vel9.generativemusic.aen.core.pitch.Note;
import com.vel9.generativemusic.aen.core.pitch.NoteType;

import java.util.List;

/**
 * Simple container for BaseScale, NoteType and available notes in the scale
 */
public class ScaleContainer {

    private BaseScale baseScale;
    private NoteType noteType;
    private List<Note> notes;

    ScaleContainer(BaseScale baseScale, NoteType noteType, List<Note> notes) {
        this.baseScale = baseScale;
        this.noteType = noteType;
        this.notes = notes;
    }

    public BaseScale getBaseScale() {
        return baseScale;
    }

    public NoteType getNoteType() {
        return noteType;
    }

    public List<Note> getNotes() {
        return notes;
    }

    @Override
    public String toString(){
        StringBuilder sb = new StringBuilder();
        sb.append("BaseScale:").append(baseScale);
        sb.append(", NoteType: ").append(noteType);
        return sb.toString();
    }
}
