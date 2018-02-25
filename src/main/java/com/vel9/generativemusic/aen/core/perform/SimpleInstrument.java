package com.vel9.generativemusic.aen.core.perform;

import com.vel9.generativemusic.aen.core.pitch.Note;

/**
 * Created by levani on 2/18/18.
 */
public class SimpleInstrument {

    private Performer performer;

    public SimpleInstrument(int midiChannel){
        this.performer = PerformanceSupport.createPerformer(midiChannel);
    }

    public void play(Note note, int velocity, long millisToHoldNote){
        this.performer.playOneShotNote(note, velocity, millisToHoldNote);
    }

}
