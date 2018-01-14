package com.vel9.generativemusic.aen.pieces.alloy;

import com.vel9.generativemusic.aen.core.perform.Instrument;
import com.vel9.generativemusic.aen.pieces.alloy.melodysources.AlloyAquariumMelodySource;
import com.vel9.generativemusic.aen.pieces.alloy.melodysources.AlloyVibraphoneMelodySource;

public class AlloyMain {

    public static void main(String[] args) {
        Instrument.play(AlloyAquariumMelodySource.getMelody(), 1);
        Instrument.play(AlloyVibraphoneMelodySource.getMelody(), 5);
        Instrument.play(AlloyVibraphoneMelodySource.getMelody(), 6);
    }
}
