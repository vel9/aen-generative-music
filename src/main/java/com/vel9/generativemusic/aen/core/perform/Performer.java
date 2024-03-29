package com.vel9.generativemusic.aen.core.perform;

import com.vel9.generativemusic.aen.core.pitch.Note;
import com.vel9.generativemusic.aen.core.support.Constants;

import javax.sound.midi.Receiver;
import javax.sound.midi.ShortMessage;
import java.util.Timer;
import java.util.TimerTask;

// ref: https://java.net/projects/gervill/sources/Mercurial/content/src/com/sun/media/sound/SoftChannel.java?rev=289

/**
 * Provides low-level implementation for sending MIDI messages to a Receiver
 */
public class Performer {

    private static final int NOTE_OFF_VELOCITY_VALUE = 60;

    private int channel;
    private Receiver receiver;
    private Note prevNote;

    Performer(int channel, Receiver receiver){
        this.channel = channel;
        this.receiver = receiver;
    }

    /* bridge between framework's Note object and the MIDI message */
    public void playNote(int velocity, Note note){
        stopPrevious();
        if (note.getValue() != Constants.SILENT_NOTE){
            noteOn(note.getValue(), velocity);
            this.prevNote = copyNote(note);
        }
    }

    public void playOneShotNote(Note note, int velocity, long millisToHoldNote){
        noteOn(note.getValue(), velocity);
        scheduleNoteOff(note.getValue(), millisToHoldNote);
    }

    private void scheduleNoteOff(int noteToShutOff, long millisToHoldNote){
        Timer timer = new Timer();
        timer.schedule(new NoteOffTask(noteToShutOff), millisToHoldNote);
    }

    /* starts playing provided note at provided velocity */
    private void noteOn(int noteNumber, int velocity) {
        sendMessage(ShortMessage.NOTE_ON, noteNumber, velocity);
    }

    /* sends any midi message, uses ShortMessage impl */
    private void sendMessage(int event, int noteNumber, int velocity){
        try {
            ShortMessage message = new ShortMessage();
            message.setMessage(event, this.channel, noteNumber, velocity);
            this.receiver.send(message, -1);
        } catch (Exception e){
            throw new IllegalStateException(e);
        }
    }

    /* stop note from playing */
    private void noteOff(int noteNumber, int velocity) {
        sendMessage(ShortMessage.NOTE_OFF, noteNumber, velocity);
    }

    /* sends noteOff signal to stop previously playing note from playing */
    private void stopPrevious(){
        if (this.prevNote == null){
            return;
        }
        noteOff(this.prevNote.getValue(), NOTE_OFF_VELOCITY_VALUE);
    }

    private Note copyNote(Note original){
        return new Note(original.getValue());
    }

    private class NoteOffTask extends TimerTask {
        private int noteToShutOff;

        NoteOffTask(int noteToShutOff){
            this.noteToShutOff = noteToShutOff;
        }

        @Override
        public void run(){
            noteOff(noteToShutOff, 0);
        }
    }

}
