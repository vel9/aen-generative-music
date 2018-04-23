package com.vel9.generativemusic.aen.core.perform;

import com.vel9.generativemusic.aen.core.pitch.Note;

public class SimpleInstrument {

    private Performer performer;

    public SimpleInstrument(int midiChannel){
        this.performer = PerformanceSupport.createPerformer(midiChannel);
    }

    public void play(Note note, int velocity, long millisToHoldNote){
        this.performer.playOneShotNote(note, velocity, millisToHoldNote);
    }

}
