package com.vel9.generativemusic.core.perform;

import com.vel9.generativemusic.core.util.Log;

import javax.sound.midi.Instrument;
import javax.sound.midi.*;

// reference for instrument numbers: https://www.midi.org/specifications/item/gm-level-1-sound-set
public class PerformanceSupport {

    private static Receiver receiver;
    private static final String TAG = PerformanceSupport.class.getSimpleName();

    static{
        Log.config(TAG, "Available MidiDevices on System: " + printMidiDevices());
        try {
            receiver = MidiSystem.getReceiver();
            Log.config(TAG, "Current Receiver: " + receiver.getClass().getSimpleName());
        } catch (Exception e){
            e.printStackTrace();
            throw new IllegalStateException(e);
        }
    }

    public static Performer getInstrument(int midiChannel) {
        return new Performer(midiChannel, receiver);
    }

    public MidiChannel getMidiChannel(int midiChannel, int instrument) throws MidiUnavailableException {
        Synthesizer synthesizer = getSynthesizer();
        MidiChannel channel = synthesizer.getChannels()[midiChannel];
        Instrument[] instruments = synthesizer.getAvailableInstruments();
        channel.programChange(instruments[instrument].getPatch().getProgram());
        return channel;
    }

    private Synthesizer getSynthesizer() throws MidiUnavailableException {
        Synthesizer synthesizer = MidiSystem.getSynthesizer();
        synthesizer.open();
        return synthesizer;
    }

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
