package com.vel9.generativemusic.aen.core.perform;

import com.vel9.generativemusic.aen.core.support.DurationVelocity;
import com.vel9.generativemusic.aen.core.MelodySource;
import com.vel9.generativemusic.aen.core.pitch.NoteContainer;

import java.util.Timer;
import java.util.TimerTask;

/**
 * Takes musical data provided by the MelodySource
 * and sends the data to the Performer (which handles more low-level detail like the MIDI communication)
 * This class contains a TimerTask which schedules an execution of a provided
 * musical event for the provided duration.
 */
public class Instrument {

    private static final String TAG = Instrument.class.getSimpleName();

    private MelodySource melodySource;
    private Performer performer;

    private Instrument(MelodySource melodySource, int midiChannel){
        this.performer = PerformanceSupport.createPerformer(midiChannel);
        this.melodySource = melodySource;
    }

    /* helper method for creating and playing an instance of Instrument */
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

        PlayNoteTask(Timer timer){
            this.timer = timer;
        }

        @Override
        public void run(){
            NoteContainer noteContainer = Instrument.this.melodySource.next();
            DurationVelocity durationVelocity = noteContainer.getDurationVelocity();
            Instrument.this.performer.playNote(durationVelocity.getVelocity(), noteContainer.getNote());
            timer.schedule(new Instrument.PlayNoteTask(timer), durationVelocity.getDuration());
        }
    }
}
