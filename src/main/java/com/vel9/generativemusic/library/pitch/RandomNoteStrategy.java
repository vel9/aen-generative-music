package com.vel9.generativemusic.library.pitch;

import com.vel9.generativemusic.core.pitch.Note;
import com.vel9.generativemusic.core.pitch.NoteStrategy;
import com.vel9.generativemusic.core.pitch.ScaleStrategy;
import com.vel9.generativemusic.core.util.Util;

import java.util.List;

/**
 * Created by levani on 12/26/16.
 */
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
