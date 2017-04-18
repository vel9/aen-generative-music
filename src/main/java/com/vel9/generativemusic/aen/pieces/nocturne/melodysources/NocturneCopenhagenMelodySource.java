package com.vel9.generativemusic.aen.pieces.nocturne.melodysources;

import com.vel9.generativemusic.aen.core.dynamics.DynamicsStrategy;
import com.vel9.generativemusic.aen.core.pitch.*;
import com.vel9.generativemusic.aen.core.util.Util;
import com.vel9.generativemusic.aen.library.SimpleMelodySource;
import com.vel9.generativemusic.aen.library.time.DeciTalaRhythmicSequence;
import com.vel9.generativemusic.aen.pieces.StrategyFactory;
import com.vel9.generativemusic.aen.core.MelodySource;
import com.vel9.generativemusic.aen.core.time.RhythmStrategy;
import com.vel9.generativemusic.aen.core.time.RhythmicSequence;
import com.vel9.generativemusic.aen.core.time.TempoStrategy;

import java.util.Arrays;
import java.util.List;

/**
 * Created by levani on 12/12/16.
 */
public class NocturneCopenhagenMelodySource {

    public static MelodySource getMelody(){
//        final int minNote = 36;
//        final int maxNote = 87;
//
//        MelodyConfig melodyConfig = new MelodyConfig();
//        melodyConfig.setMinNote(minNote);
//        melodyConfig.setMaxNote(maxNote);
//        melodyConfig.setScaleRateOfChange(Constants.SECOND_IN_MILLIS * 5);
//
//        melodyConfig.setMinTempo(10);
//        melodyConfig.setMaxTempo(25);
//        melodyConfig.setTempoRateOfChange(Constants.SECOND_IN_MILLIS * 9);
//
//        melodyConfig.setMinVelocity(2);
//        melodyConfig.setMaxVelocity(45);
//        melodyConfig.setVelocityRateOfChange(Constants.SECOND_IN_MILLIS);

        ScaleStrategy scaleStrategy = StrategyFactory.getChangeScaleStrategy(getScales(36, 87), Util.getSeconds(5));
        NoteStrategy noteStrategy = StrategyFactory.getNoteStrategy(scaleStrategy);

        TempoStrategy tempoStrategy = StrategyFactory.getUpwardTempoStrategy(10, 25, Util.getSeconds(9));
        DynamicsStrategy dynamicsStrategy = StrategyFactory.getGradualUpwardDynamicsStrategy(2, 45, Util.getSeconds(1));
        RhythmStrategy rhythmStrategy = StrategyFactory.getRhythmStrategy(tempoStrategy, dynamicsStrategy, getRhythmicSequences());
        return new SimpleMelodySource(noteStrategy, rhythmStrategy);
    }

    private static Scale[] getScales(int minNote, int maxNote){
        return new Scale[]{new Scale(BaseScale.MODE3, NoteType.C, minNote, maxNote),
                new Scale(BaseScale.MINOR, NoteType.D, minNote, maxNote),
                new Scale(BaseScale.MINOR, NoteType.F_SHARP, minNote, maxNote),
                new Scale(BaseScale.MINOR, NoteType.A_FLAT, minNote, maxNote),
                new Scale(BaseScale.MODE3, NoteType.C, minNote, maxNote),
                new Scale(BaseScale.MODE3, NoteType.D_SHARP, minNote, maxNote),
                new Scale(BaseScale.MINOR, NoteType.B_FLAT, minNote, maxNote)
        };
    }

    private static List<RhythmicSequence> getRhythmicSequences(){
        return Arrays.asList(DeciTalaRhythmicSequence.values());
    }
}
