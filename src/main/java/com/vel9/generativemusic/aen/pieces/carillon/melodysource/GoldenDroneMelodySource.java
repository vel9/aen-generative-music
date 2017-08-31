package com.vel9.generativemusic.aen.pieces.carillon.melodysource;

import com.vel9.generativemusic.aen.core.MelodySource;
import com.vel9.generativemusic.aen.core.dynamics.DynamicsStrategy;
import com.vel9.generativemusic.aen.core.pitch.*;
import com.vel9.generativemusic.aen.core.time.RhythmStrategy;
import com.vel9.generativemusic.aen.core.time.RhythmicSequence;
import com.vel9.generativemusic.aen.core.time.TempoStrategy;
import com.vel9.generativemusic.aen.core.util.Util;
import com.vel9.generativemusic.aen.library.SimpleMelodySource;
import com.vel9.generativemusic.aen.library.time.DeciTalaRhythmicSequence;
import com.vel9.generativemusic.aen.pieces.StrategyFactory;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class GoldenDroneMelodySource {

    public static MelodySource getMelody(){
        ScaleStrategy scaleStrategy = StrategyFactory.getChangeScaleStrategy(getScales(36, 84), Util.getSeconds(20));
        NoteStrategy noteStrategy = StrategyFactory.getNoteStrategy(scaleStrategy);

        TempoStrategy tempoStrategy = StrategyFactory.getUpwardTempoStrategy(40, 60, Util.getSeconds(9));
        DynamicsStrategy dynamicsStrategy = StrategyFactory.getGradualUpwardDynamicsStrategy(30, 70, Util.getSeconds(1));
        RhythmStrategy rhythmStrategy = StrategyFactory.getRhythmStrategy(tempoStrategy, dynamicsStrategy, getRhythmicSequences());
        return new SimpleMelodySource(noteStrategy, rhythmStrategy);
    }

    private static Scale[] getScales(int minNote, int maxNote){
        return new Scale[]{
                new Scale(BaseScale.MAJOR, NoteType.C, minNote, maxNote),
                new Scale(BaseScale.MINOR, NoteType.C_SHARP, minNote, maxNote),
                new Scale(BaseScale.MAJOR, NoteType.D, minNote, maxNote),
                new Scale(BaseScale.MAJOR, NoteType.D_SHARP, minNote, maxNote),
                new Scale(BaseScale.MODE3, NoteType.E, minNote, maxNote),
                new Scale(BaseScale.MODE3, NoteType.F, minNote, maxNote),
                new Scale(BaseScale.MODE3, NoteType.F_SHARP, minNote, maxNote),
                new Scale(BaseScale.MODE6, NoteType.G, minNote, maxNote),
                new Scale(BaseScale.MODE6, NoteType.G_SHARP, minNote, maxNote),
                new Scale(BaseScale.MODE6, NoteType.A, minNote, maxNote),
                new Scale(BaseScale.MODE6, NoteType.A_SHARP, minNote, maxNote),
                new Scale(BaseScale.MODE6, NoteType.B, minNote, maxNote),
        };
    }

    private static List<RhythmicSequence> getRhythmicSequences(){
        List<RhythmicSequence> rhythmicSequences = new ArrayList<>();
        rhythmicSequences.addAll(Arrays.asList(DeciTalaRhythmicSequence.values()));
        return rhythmicSequences;
    }
}
