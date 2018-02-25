package com.vel9.generativemusic.aen.examples.pieces.recalcitrance;

import com.vel9.generativemusic.aen.core.perform.Instrument;
import com.vel9.generativemusic.aen.examples.pieces.recalcitrance.melodysource.*;


public class RecalcitranceMain {

    public static void main(String[] args) {
        Instrument.play(RecalcitranceShimmerMelodySource.getMelody(), 0);

        Instrument.play(RecalcitranceCopenMelodySource.getMelody(), 1);

        Instrument.play(RecalcitranceVibraphone1MelodySource.getMelody(), 3);
        Instrument.play(RecalcitranceGoldenPipeMelodySource.getMelody(), 4);
        Instrument.play(RecalcitranceVibraphone2MelodySource.getMelody(), 5);
        Instrument.play(RecalcitranceVibraphone2MelodySource.getMelody(), 6);
    }

}
