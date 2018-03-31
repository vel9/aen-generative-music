package com.vel9.generativemusic.examples.garden;

import com.vel9.generativemusic.examples.garden.melodysources.*;
import com.vel9.generativemusic.aen.core.perform.Instrument;

public class GardenMain {

    public static void main(String[] args) {
        Instrument.play(GardenPluckedPianoSource.getMelody(), 0);
        Instrument.play(GardenMutedPianoMelodySource.getMelody(), 1);
        Instrument.play(GardenMalletPianoSource.getMelody(), 5);

        Instrument.play(GardenGlassArmonicaMelodySource.getMelody(), 2);
        Instrument.play(GardenGlockenMelodySource.getMelody(), 3);
        Instrument.play(GardenHarmoniumMelodySource.getMelody(), 4);
    }
}
