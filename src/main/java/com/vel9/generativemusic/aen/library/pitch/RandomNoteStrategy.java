package com.vel9.generativemusic.aen.library.pitch;

import com.vel9.generativemusic.aen.core.pitch.Note;
import com.vel9.generativemusic.aen.core.pitch.NoteStrategy;
import com.vel9.generativemusic.aen.core.pitch.ScaleStrategy;
import com.vel9.generativemusic.aen.core.util.Util;

import java.util.List;

public class RandomNoteStrategy implements NoteStrategy {

    private ScaleStrategy scaleStrategy;

    public RandomNoteStrategy(ScaleStrategy scaleStrategy){
        this.scaleStrategy = scaleStrategy;
    }

    @Override
    public Note nextNote() {
        List<Note> notes = this.scaleStrategy.getScale().getNotes();
        int nextNoteIndex = getNextNoteIndex(notes);
        return notes.get(nextNoteIndex);
    }

    private int getNextNoteIndex(List<Note> notes){
        return Util.getRandom(0, notes.size() - 1);
    }
}
