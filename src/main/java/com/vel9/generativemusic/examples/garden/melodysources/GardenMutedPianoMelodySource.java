package com.vel9.generativemusic.examples.garden.melodysources;

import com.vel9.generativemusic.aen.core.pitch.*;
import com.vel9.generativemusic.aen.library.SimpleMelodySource;
import com.vel9.generativemusic.aen.library.time.DeciTalaRhythmicSequence;
import com.vel9.generativemusic.aen.core.MelodySource;
import com.vel9.generativemusic.aen.core.dynamics.DynamicsStrategy;
import com.vel9.generativemusic.aen.core.time.RhythmStrategy;
import com.vel9.generativemusic.aen.core.time.RhythmicSequence;
import com.vel9.generativemusic.aen.core.time.TempoStrategy;
import com.vel9.generativemusic.aen.core.util.Util;
import com.vel9.generativemusic.aen.library.time.SilentRhythmicSequence;
import com.vel9.generativemusic.aen.library.StrategyFactory;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class GardenMutedPianoMelodySource {

    public static MelodySource getMelody(){
        ScaleStrategy scaleStrategy = StrategyFactory.getChangeScaleStrategy(getScales(36, 96), Util.getSeconds(5));
        NoteStrategy noteStrategy = StrategyFactory.getNoteStrategy(scaleStrategy);

        TempoStrategy tempoStrategy = StrategyFactory.getDownwardTempoStrategy(70, 200, Util.getSeconds(10));
        DynamicsStrategy dynamicsStrategy = StrategyFactory.getGradualUpwardDynamicsStrategy(3, 50, Util.getSeconds(1));
        RhythmStrategy rhythmStrategy = StrategyFactory.getRhythmStrategy(tempoStrategy, dynamicsStrategy, getRhythmicSequences());
        return new SimpleMelodySource(noteStrategy, rhythmStrategy);
    }

    private static Scale[] getScales(int minNote, int maxNote){
        return new Scale[]{
                Scale.createTransposingScale(BaseScale.MODE3, NoteType.C, minNote, maxNote),
                Scale.createTransposingScale(BaseScale.MAJOR, NoteType.D, minNote, maxNote),
                Scale.createTransposingScale(BaseScale.MODE3, NoteType.D, minNote, maxNote),
                Scale.createTransposingScale(BaseScale.MAJOR, NoteType.A_FLAT, minNote, maxNote),
                Scale.createTransposingScale(BaseScale.MAJOR, NoteType.D_SHARP, minNote, maxNote),
                Scale.createTransposingScale(BaseScale.MODE6, NoteType.C, minNote, maxNote),
                Scale.createTransposingScale(BaseScale.MODE6, NoteType.C_SHARP, minNote, maxNote),
                Scale.createTransposingScale(BaseScale.MAJOR, NoteType.G, minNote, maxNote),
                Scale.createTransposingScale(BaseScale.MINOR, NoteType.E_FLAT, minNote, maxNote)
        };
    }

    private static List<RhythmicSequence> getRhythmicSequences(){
        List<RhythmicSequence> rhythmicSequences = new ArrayList<>();
        rhythmicSequences.addAll(Arrays.asList(DeciTalaRhythmicSequence.getFastSequences()));
        for (int i = 0; i < 20; i++) {
            rhythmicSequences.add(SilentRhythmicSequence.QUADRUPLE_WHOLE_SILENCE);
            rhythmicSequences.add(SilentRhythmicSequence.TRIPLE_WHOLE_SILENCE);
        }
        return rhythmicSequences;
    }
}
