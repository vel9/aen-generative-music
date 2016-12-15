package com.vel9.generativemusic.pieces.one.melodysources;

import com.vel9.generativemusic.core.MelodySource;
import com.vel9.generativemusic.core.dynamics.DynamicsStrategy;
import com.vel9.generativemusic.core.pitch.*;
import com.vel9.generativemusic.core.time.RhythmStrategy;
import com.vel9.generativemusic.core.time.RhythmicSequence;
import com.vel9.generativemusic.core.time.TempoStrategy;
import com.vel9.generativemusic.library.SimpleMelodySource;
import com.vel9.generativemusic.library.time.DeciTalaRhythmicSequence;
import com.vel9.generativemusic.pieces.StrategyFactory;
import com.vel9.generativemusic.core.util.Util;

import java.util.Arrays;
import java.util.List;

/**
 * Created by levani on 12/12/16.
 */
public class OneCopenhagenMelodySource {

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

        ScaleStrategy scaleStrategy = StrategyFactory.getScaleStrategy(getScales(36, 87), Util.getSeconds(5));
        NoteStrategy noteStrategy = StrategyFactory.getNoteStrategy(scaleStrategy);

        TempoStrategy tempoStrategy = StrategyFactory.getUpwardTempoStrategy(10, 25, Util.getSeconds(9));
        DynamicsStrategy dynamicsStrategy = StrategyFactory.getUpwardDynamicsStrategy(2, 45, Util.getSeconds(1));
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
