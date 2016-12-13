package com.vel9.generativemusic.core.perform;

import com.vel9.generativemusic.core.pitch.Note;
import com.vel9.generativemusic.core.support.Constants;

import javax.sound.midi.Receiver;
import javax.sound.midi.ShortMessage;

// ref: https://java.net/projects/gervill/sources/Mercurial/content/src/com/sun/media/sound/SoftChannel.java?rev=289
public class Performer {

    private int channel;
    private Receiver receiver;
    private Note[] prevNotes;
    private Note prevNote;

    Performer(int channel, Receiver receiver){
        this.channel = channel;
        this.receiver = receiver;
    }

    public void playNote(int velocity, Note note){
        stopPrevious();
        if (note.getValue() != Constants.SILENT_NOTE){
            noteOn(note.getValue(), velocity);
            this.prevNote = copyNote(note);
        }
    }

    private Note copyNote(Note original){
        return new Note(original.getValue());
    }

    public void noteOn(int noteNumber, int velocity) {
        sendMessage(ShortMessage.NOTE_ON, noteNumber, velocity);
    }

    private void sendMessage(int event, int noteNumber, int velocity){
        try {
            ShortMessage message = new ShortMessage();
            message.setMessage(event, this.channel, noteNumber, velocity);
            this.receiver.send(message, -1);
        } catch (Exception e){
            throw new IllegalStateException(e);
        }
    }

    public void noteOff(int noteNumber, int velocity) {
        sendMessage(ShortMessage.NOTE_OFF, noteNumber, velocity);
    }

    public void stopPrevious(){
        if (this.prevNote == null){
            return;
        }
        noteOff(this.prevNote.getValue(), 60);
    }
}
