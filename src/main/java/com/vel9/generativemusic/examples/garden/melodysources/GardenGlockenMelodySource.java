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

/**
 * Created by levani on 12/12/16.
 */
public class GardenGlockenMelodySource {

    public static MelodySource getMelody(){
        ScaleStrategy scaleStrategy = StrategyFactory.getChangeScaleStrategy(getScales(64, 102), Util.getSeconds(6));
        NoteStrategy noteStrategy = StrategyFactory.getNoteStrategy(scaleStrategy);

        TempoStrategy tempoStrategy = StrategyFactory.getDownwardTempoStrategy(70, 200, Util.getSeconds(3));
        DynamicsStrategy dynamicsStrategy = StrategyFactory.getGradualDownwardDynamicsStrategy(2, 35, Util.getSeconds(4));
        RhythmStrategy rhythmStrategy = StrategyFactory.getRhythmStrategy(tempoStrategy, dynamicsStrategy, getRhythmicSequences());
        return new SimpleMelodySource(noteStrategy, rhythmStrategy);
    }

    private static Scale[] getScales(int minNote, int maxNote){
        return new Scale[]{
                Scale.createTransposingScale(BaseScale.MODE2, NoteType.C, minNote, maxNote),
                Scale.createTransposingScale(BaseScale.MINOR, NoteType.D, minNote, maxNote),
                Scale.createTransposingScale(BaseScale.MINOR, NoteType.F_SHARP, minNote, maxNote),
                Scale.createTransposingScale(BaseScale.MINOR, NoteType.C, minNote, maxNote),
                Scale.createTransposingScale(BaseScale.MINOR, NoteType.A_FLAT, minNote, maxNote),
                Scale.createTransposingScale(BaseScale.MODE2, NoteType.F_SHARP, minNote, maxNote),
                Scale.createTransposingScale(BaseScale.MODE2, NoteType.D_SHARP, minNote, maxNote),
                Scale.createTransposingScale(BaseScale.MODE2, NoteType.B_FLAT, minNote, maxNote),
                Scale.createTransposingScale(BaseScale.MODE2, NoteType.D, minNote, maxNote)
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
