package com.vel9.generativemusic.examples.alloy;

import com.vel9.generativemusic.aen.core.perform.Instrument;
import com.vel9.generativemusic.examples.alloy.melodysources.AlloyAquariumMelodySource;
import com.vel9.generativemusic.examples.alloy.melodysources.AlloyMode3VibraphoneMelodySource;

public class AlloyMain {

    public static void main(String[] args) {
        Instrument.play(AlloyAquariumMelodySource.getMelody(), 0);
        Instrument.play(AlloyMode3VibraphoneMelodySource.getMelody(), 1);
        Instrument.play(AlloyMode3VibraphoneMelodySource.getMelody(), 2);
    }
}
