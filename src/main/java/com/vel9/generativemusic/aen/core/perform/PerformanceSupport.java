package com.vel9.generativemusic.aen.core.perform;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.sound.midi.MidiDevice;
import javax.sound.midi.MidiSystem;
import javax.sound.midi.MidiUnavailableException;
import javax.sound.midi.Receiver;

/**
 * Handles more low-level detail in setting up the MIDI Receiver,
 * a representation of the server which will receive MIDI Messages send by the Performer
 *
 * Also provides a static Method for creating Performers
 */
public class PerformanceSupport {

    private static Receiver receiver;
    private static final Logger LOG = LoggerFactory.getLogger(PerformanceSupport.class);

    /* initializes the MIDI Receiver */
    static{
        initMidiReceiver();
    }

    private static void initMidiReceiver() {
        LOG.info("Available MidiDevices on System: " + printMidiDevices());
        try {
            receiver = MidiSystem.getReceiver();
        } catch (Exception e){
            e.printStackTrace();
            throw new IllegalStateException("Could not initialize Receiver", e);
        }
    }

    public static Performer createPerformer(int midiChannel) {
        return new Performer(midiChannel, receiver);
    }

    /* helper method for printing available MIDI devices on system */
    private static String printMidiDevices(){
        StringBuilder sb = new StringBuilder();
        for (MidiDevice.Info info : MidiSystem.getMidiDeviceInfo()){
            try {
                sb.append(info.getName() + " - " + MidiSystem.getMidiDevice(info).getClass().getSimpleName() + "; ");
            } catch (MidiUnavailableException e) {
                e.printStackTrace();
                throw new IllegalStateException(e);
            }
        }
        return sb.toString();
    }

}
