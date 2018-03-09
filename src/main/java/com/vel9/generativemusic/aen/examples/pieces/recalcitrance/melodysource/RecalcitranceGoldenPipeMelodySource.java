package com.vel9.generativemusic.aen.examples.pieces.recalcitrance.melodysource;

import com.vel9.generativemusic.aen.core.MelodySource;
import com.vel9.generativemusic.aen.core.dynamics.DynamicsStrategy;
import com.vel9.generativemusic.aen.core.pitch.*;
import com.vel9.generativemusic.aen.core.time.RhythmStrategy;
import com.vel9.generativemusic.aen.core.time.RhythmicSequence;
import com.vel9.generativemusic.aen.core.time.TempoStrategy;
import com.vel9.generativemusic.aen.core.util.Util;
import com.vel9.generativemusic.aen.library.StrategyFactory;
import com.vel9.generativemusic.aen.library.SimpleMelodySource;
import com.vel9.generativemusic.aen.library.time.DeciTalaRhythmicSequence;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class RecalcitranceGoldenPipeMelodySource {

    public static MelodySource getMelody(){
        ScaleStrategy scaleStrategy = StrategyFactory.getChangeScaleStrategy(getScales(60, 108), Util.getSeconds(20));
        NoteStrategy noteStrategy = StrategyFactory.getNoteStrategy(scaleStrategy);

        TempoStrategy tempoStrategy = StrategyFactory.getDownwardTempoStrategy(180, 240, Util.getSeconds(3));
        DynamicsStrategy dynamicsStrategy = StrategyFactory.getGradualUpwardDynamicsStrategy(30, 70, Util.getSeconds(1));
        RhythmStrategy rhythmStrategy = StrategyFactory.getRhythmStrategy(tempoStrategy, dynamicsStrategy, getRhythmicSequences());
        return new SimpleMelodySource(noteStrategy, rhythmStrategy);
    }

    private static Scale[] getScales(int minNote, int maxNote){
        return new Scale[]{
                new Scale(BaseScale.MODE6, NoteType.C, minNote, maxNote),
                new Scale(BaseScale.MODE6, NoteType.C_SHARP, minNote, maxNote),
                new Scale(BaseScale.MODE6, NoteType.D, minNote, maxNote),
                new Scale(BaseScale.MODE6, NoteType.D_SHARP, minNote, maxNote),
                new Scale(BaseScale.MODE6, NoteType.E, minNote, maxNote),
                new Scale(BaseScale.MODE6, NoteType.F, minNote, maxNote),
                new Scale(BaseScale.MODE6, NoteType.F_SHARP, minNote, maxNote),
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
