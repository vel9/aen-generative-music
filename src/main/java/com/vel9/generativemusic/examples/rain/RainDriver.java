package com.vel9.generativemusic.examples.rain;

import com.vel9.generativemusic.aen.core.perform.Instrument;
import com.vel9.generativemusic.examples.rain.melodysources.RainHangDrumMKOneMelodySource;
import com.vel9.generativemusic.examples.rain.melodysources.RainMarimbaMelodySource;

public class RainDriver {

    public static void main(String[] args) {
        // routes MIDI signals to channel 0, 1 etc.
        Instrument.play(RainMarimbaMelodySource.getMelody(), 0);
        Instrument.play(RainMarimbaMelodySource.getMelody(), 1);
        Instrument.play(RainMarimbaMelodySource.getMelody(), 2);
        Instrument.play(RainHangDrumMKOneMelodySource.getMelody(), 3);
    }
}
