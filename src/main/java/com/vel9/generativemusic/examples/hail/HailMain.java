package com.vel9.generativemusic.examples.hail;

import com.vel9.generativemusic.aen.core.perform.Instrument;
import com.vel9.generativemusic.examples.hail.melodysources.*;


public class HailMain {

    public static void main(String[] args) {
        Instrument.play(HailPluckedPianoSource.getMelody(), 0);
        Instrument.play(HailMutedPianoMelodySource.getMelody(), 1);
        Instrument.play(HailMalletPianoSource.getMelody(), 5);

        Instrument.play(HailGlassArmonicaMelodySource.getMelody(), 2);
        Instrument.play(HailGlockenMelodySource.getMelody(), 3);
        Instrument.play(HailBowedPianoMelodySource.getMelody(), 4);

        Instrument.play(HailCopenhagenMelodySource.getMelody(), 6);
    }
}
