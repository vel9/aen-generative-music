package com.vel9.generativemusic.aen.examples.pieces.alloy.melodysources;

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
import com.vel9.generativemusic.aen.library.time.SilentRhythmicSequence;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class AlloyAquariumMelodySource {

    public static MelodySource getMelody(){
        ScaleStrategy scaleStrategy = StrategyFactory.getChangeScaleStrategy(getScales(36, 87), Util.getSeconds(10));
        NoteStrategy noteStrategy = StrategyFactory.getNoteStrategy(scaleStrategy);

        TempoStrategy tempoStrategy = StrategyFactory.getUpwardTempoStrategy(10, 25, Util.getSeconds(9));
        DynamicsStrategy dynamicsStrategy = StrategyFactory.getVariablePeakDynamicsStrategy(2, 5, 35, 45, Util.getSeconds(5));
        RhythmStrategy rhythmStrategy = StrategyFactory.getRhythmStrategy(tempoStrategy, dynamicsStrategy, getRhythmicSequences());
        return new SimpleMelodySource(noteStrategy, rhythmStrategy);
    }

    private static Scale[] getScales(int minNote, int maxNote){
        return new Scale[]{
                new Scale(BaseScale.PHRYGIAN, NoteType.C, minNote, maxNote),
                new Scale(BaseScale.PHRYGIAN, NoteType.C_SHARP, minNote, maxNote),
                new Scale(BaseScale.PHRYGIAN, NoteType.D, minNote, maxNote),
                new Scale(BaseScale.PHRYGIAN, NoteType.E_FLAT, minNote, maxNote),
                new Scale(BaseScale.PHRYGIAN, NoteType.C, minNote, maxNote),
                new Scale(BaseScale.PHRYGIAN, NoteType.C_SHARP, minNote, maxNote),
                new Scale(BaseScale.PHRYGIAN, NoteType.D, minNote, maxNote),
                new Scale(BaseScale.PHRYGIAN, NoteType.F_SHARP, minNote, maxNote),
                new Scale(BaseScale.PHRYGIAN, NoteType.G, minNote, maxNote),
                new Scale(BaseScale.PHRYGIAN, NoteType.G_SHARP, minNote, maxNote),
                new Scale(BaseScale.PHRYGIAN, NoteType.A, minNote, maxNote),
        };
    }

    private static List<RhythmicSequence> getRhythmicSequences(){
        List<RhythmicSequence> rhythmicSequences = new ArrayList<>();
        rhythmicSequences.addAll(Arrays.asList(DeciTalaRhythmicSequence.values()));
        for (int i = 0; i < 15; i++) {
            rhythmicSequences.add(SilentRhythmicSequence.QUADRUPLE_WHOLE_SILENCE);
        }
        return rhythmicSequences;
    }
}
