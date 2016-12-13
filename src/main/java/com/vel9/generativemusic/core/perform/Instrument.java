package com.vel9.generativemusic.core.perform;

import com.vel9.generativemusic.core.MelodySource;
import com.vel9.generativemusic.core.pitch.NoteContainer;
import com.vel9.generativemusic.core.support.DurationVelocity;
import com.vel9.generativemusic.core.util.Log;

import java.util.Timer;
import java.util.TimerTask;

/**
 * Created by levani on 12/6/16.
 */
public class Instrument {

    private static final String TAG = Instrument.class.getSimpleName();

    private MelodySource melodySource;
    private Performer performer;

    private Instrument(MelodySource melodySource, int midiChannel){
        this.performer = PerformanceSupport.getInstrument(midiChannel);
        this.melodySource = melodySource;
    }

    public static void play(MelodySource melodySource, int midiChannel){
        Instrument instrument = new Instrument(melodySource, midiChannel);
        instrument.play();
    }

    public void play(){
        Timer timer = new Timer();
        timer.schedule(new Instrument.PlayNoteTask(timer), 0);
    }

    //ref: https://docs.oracle.com/javase/tutorial/java/javaOO/nested.html
    private class PlayNoteTask extends TimerTask {
        private Timer timer;

        public PlayNoteTask(Timer timer){
            this.timer = timer;
        }

        @Override
        public void run(){
            NoteContainer noteContainer = Instrument.this.melodySource.next();
            DurationVelocity durationVelocity = noteContainer.getDurationVelocity();
            Log.config(TAG, "duration: " + durationVelocity.getDuration() + ", velocity: " + durationVelocity.getVelocity() + ", " +  noteContainer.getNote());
            Instrument.this.performer.playNote(durationVelocity.getVelocity(), noteContainer.getNote());
            timer.schedule(new Instrument.PlayNoteTask(timer), durationVelocity.getDuration());
        }
    }
}
