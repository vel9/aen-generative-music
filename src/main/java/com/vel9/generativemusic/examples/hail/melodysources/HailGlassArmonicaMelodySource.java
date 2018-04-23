package com.vel9.generativemusic.examples.hail.melodysources;

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

/**
 * Created by levani on 12/12/16.
 */
public class HailGlassArmonicaMelodySource {

    public static MelodySource getMelody(){
        ScaleStrategy scaleStrategy = StrategyFactory.getChangeScaleStrategy(getScales(69, 89), Util.getSeconds(5));
        NoteStrategy noteStrategy = StrategyFactory.getNoteStrategy(scaleStrategy);

        TempoStrategy tempoStrategy = StrategyFactory.getDownwardTempoStrategy(130, 200, Util.getSeconds(10));
        DynamicsStrategy dynamicsStrategy = StrategyFactory.getGradualUpwardDynamicsStrategy(1, 15, Util.getSeconds(1));
        RhythmStrategy rhythmStrategy = StrategyFactory.getRhythmStrategy(tempoStrategy, dynamicsStrategy, getRhythmicSequences());
        return new SimpleMelodySource(noteStrategy, rhythmStrategy);
    }

    private static Scale[] getScales(int minNote, int maxNote){
        return new Scale[]{
                Scale.createTransposingScale(BaseScale.MODE3, NoteType.C, minNote, maxNote),
                Scale.createTransposingScale(BaseScale.MODE3, NoteType.C_SHARP, minNote, maxNote),
                Scale.createTransposingScale(BaseScale.MODE3, NoteType.D, minNote, maxNote),
                Scale.createTransposingScale(BaseScale.MODE6, NoteType.E_FLAT, minNote, maxNote),
                Scale.createTransposingScale(BaseScale.MODE2, NoteType.C, minNote, maxNote),
                Scale.createTransposingScale(BaseScale.MODE2, NoteType.C_SHARP, minNote, maxNote),
                Scale.createTransposingScale(BaseScale.MAJOR, NoteType.A, minNote, maxNote),
                Scale.createTransposingScale(BaseScale.MAJOR, NoteType.E, minNote, maxNote),
                Scale.createTransposingScale(BaseScale.MAJOR, NoteType.B, minNote, maxNote),
                Scale.createTransposingScale(BaseScale.MAJOR, NoteType.F_SHARP, minNote, maxNote),
                Scale.createTransposingScale(BaseScale.MAJOR, NoteType.C_SHARP, minNote, maxNote),
                Scale.createTransposingScale(BaseScale.MAJOR, NoteType.G_SHARP, minNote, maxNote),
                Scale.createTransposingScale(BaseScale.MAJOR, NoteType.D_SHARP, minNote, maxNote),
        };
    }

    private static List<RhythmicSequence> getRhythmicSequences(){
        List<RhythmicSequence> rhythmicSequences = new ArrayList<>();
        rhythmicSequences.addAll(Arrays.asList(DeciTalaRhythmicSequence.getFastSequences()));
        for (int i = 0; i < 25; i++) {
            rhythmicSequences.add(SilentRhythmicSequence.QUADRUPLE_WHOLE_SILENCE);
            rhythmicSequences.add(SilentRhythmicSequence.TRIPLE_WHOLE_SILENCE);
        }
        return rhythmicSequences;
    }
}
