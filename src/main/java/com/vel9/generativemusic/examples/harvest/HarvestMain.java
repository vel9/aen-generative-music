package com.vel9.generativemusic.examples.harvest;

import com.vel9.generativemusic.aen.core.perform.Instrument;
import com.vel9.generativemusic.examples.harvest.melodysources.HarvestJagguMelodySource;
import com.vel9.generativemusic.examples.harvest.melodysources.HarvestJingMelodySource;
import com.vel9.generativemusic.examples.harvest.melodysources.HarvestKwaenggMelodySource;
import com.vel9.generativemusic.examples.harvest.melodysources.HarvestPukMelodySource;

public class HarvestMain {

    public static void main(String[] args) {
        Instrument.play(HarvestJagguMelodySource.getMelody(), 0);
        Instrument.play(HarvestJingMelodySource.getMelody(), 1);
        Instrument.play(HarvestKwaenggMelodySource.getMelody(), 2);
        Instrument.play(HarvestPukMelodySource.getMelody(), 3);
    }

}
