package com.vel9.generativemusic.pieces.rain.melodysources;

import com.vel9.generativemusic.core.MelodySource;
import com.vel9.generativemusic.core.dynamics.DynamicsStrategy;
import com.vel9.generativemusic.core.pitch.*;
import com.vel9.generativemusic.core.time.RhythmStrategy;
import com.vel9.generativemusic.core.time.RhythmicSequence;
import com.vel9.generativemusic.core.time.TempoStrategy;
import com.vel9.generativemusic.core.util.Util;
import com.vel9.generativemusic.library.SimpleMelodySource;
import com.vel9.generativemusic.library.time.DeciTalaRhythmicSequence;
import com.vel9.generativemusic.pieces.StrategyFactory;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by levani on 12/25/16.
 */
public class RainBowedMarimbaMelodySource {

    public static MelodySource getMelody(){
        ScaleStrategy scaleStrategy = StrategyFactory.getChangeScaleStrategy(getScales(36, 72), Util.getSeconds(10));
        NoteStrategy noteStrategy = StrategyFactory.getNoteStrategy(scaleStrategy);

        TempoStrategy tempoStrategy = StrategyFactory.getUpwardTempoStrategy(7, 35, Util.getSeconds(2));
        DynamicsStrategy dynamicsStrategy = StrategyFactory.getGradualUpwardDynamicsStrategy(10, 70, Util.getSeconds(3));
        RhythmStrategy rhythmStrategy = StrategyFactory.getRhythmStrategy(tempoStrategy, dynamicsStrategy, getRhythmicSequences());
        return new SimpleMelodySource(noteStrategy, rhythmStrategy);
    }

    private static Scale[] getScales(int minNote, int maxNote){
        return new Scale[]{
                new Scale(BaseScale.MODE3, NoteType.C, minNote, maxNote),
                new Scale(BaseScale.MODE3, NoteType.C_SHARP, minNote, maxNote),
                new Scale(BaseScale.MODE3, NoteType.D, minNote, maxNote),
                new Scale(BaseScale.MODE6, NoteType.E_FLAT, minNote, maxNote),
                new Scale(BaseScale.MODE2, NoteType.C, minNote, maxNote),
                new Scale(BaseScale.MODE2, NoteType.C_SHARP, minNote, maxNote),
        };
    }

    private static List<RhythmicSequence> getRhythmicSequences(){
        List<RhythmicSequence> rhythmicSequences = new ArrayList<>();
        rhythmicSequences.addAll(Arrays.asList(DeciTalaRhythmicSequence.values()));
        return rhythmicSequences;
    }
}