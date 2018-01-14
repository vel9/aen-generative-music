package com.vel9.generativemusic.aen.pieces.alloy.melodysources;

import com.vel9.generativemusic.aen.core.MelodySource;
import com.vel9.generativemusic.aen.core.dynamics.DynamicsStrategy;
import com.vel9.generativemusic.aen.core.pitch.*;
import com.vel9.generativemusic.aen.core.time.RhythmStrategy;
import com.vel9.generativemusic.aen.core.time.RhythmicSequence;
import com.vel9.generativemusic.aen.core.time.TempoStrategy;
import com.vel9.generativemusic.aen.core.util.Util;
import com.vel9.generativemusic.aen.library.SimpleMelodySource;
import com.vel9.generativemusic.aen.library.time.DeciTalaRhythmicSequence;
import com.vel9.generativemusic.aen.library.time.SilentRhythmicSequence;
import com.vel9.generativemusic.aen.pieces.StrategyFactory;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class AlloyVibraphoneMelodySource {

    public static MelodySource getMelody(){
        ScaleStrategy scaleStrategy = StrategyFactory.getChangeScaleStrategy(getScales(40, 84), Util.getSeconds(10));
        NoteStrategy noteStrategy = StrategyFactory.getNoteStrategy(scaleStrategy);

        TempoStrategy tempoStrategy = StrategyFactory.getUpwardTempoStrategy(110, 200, Util.getSeconds(2));
        DynamicsStrategy dynamicsStrategy = StrategyFactory.getRandomDynamicsStrategy(3, 25, Util.getSeconds(3));
        RhythmStrategy rhythmStrategy = StrategyFactory.getRhythmStrategy(tempoStrategy, dynamicsStrategy, getRhythmicSequences());
        return new SimpleMelodySource(noteStrategy, rhythmStrategy);
    }

    private static Scale[] getScales(int minNote, int maxNote){
        return new Scale[]{
                new Scale(BaseScale.MAJOR, NoteType.C, minNote, maxNote),
                new Scale(BaseScale.MAJOR, NoteType.C_SHARP, minNote, maxNote),
                new Scale(BaseScale.MAJOR, NoteType.D, minNote, maxNote),
                new Scale(BaseScale.MAJOR, NoteType.E_FLAT, minNote, maxNote),
                new Scale(BaseScale.MAJOR, NoteType.E, minNote, maxNote),
                new Scale(BaseScale.MAJOR, NoteType.F, minNote, maxNote),
                new Scale(BaseScale.MAJOR, NoteType.F_SHARP, minNote, maxNote),
                new Scale(BaseScale.MODE6, NoteType.G, minNote, maxNote),
                new Scale(BaseScale.MAJOR, NoteType.G_SHARP, minNote, maxNote),
                new Scale(BaseScale.MAJOR, NoteType.A, minNote, maxNote),
                new Scale(BaseScale.MAJOR, NoteType.A_SHARP, minNote, maxNote),
                new Scale(BaseScale.MAJOR, NoteType.B, minNote, maxNote)
        };
    }

    private static List<RhythmicSequence> getRhythmicSequences(){
        List<RhythmicSequence> rhythmicSequences = new ArrayList<>();
        rhythmicSequences.addAll(Arrays.asList(DeciTalaRhythmicSequence.values()));
        for (int i = 0; i < 20; i++) {
            rhythmicSequences.add(SilentRhythmicSequence.QUADRUPLE_WHOLE_SILENCE);
            rhythmicSequences.add(SilentRhythmicSequence.TRIPLE_WHOLE_SILENCE);
        }
        return rhythmicSequences;
    }

}
