package com.vel9.generativemusic.examples.hail.melodysources;

import com.vel9.generativemusic.aen.core.pitch.*;
import com.vel9.generativemusic.aen.library.StrategyFactory;
import com.vel9.generativemusic.aen.library.SimpleMelodySource;
import com.vel9.generativemusic.aen.library.time.DeciTalaRhythmicSequence;
import com.vel9.generativemusic.aen.core.MelodySource;
import com.vel9.generativemusic.aen.core.dynamics.DynamicsStrategy;
import com.vel9.generativemusic.aen.core.time.RhythmStrategy;
import com.vel9.generativemusic.aen.core.time.RhythmicSequence;
import com.vel9.generativemusic.aen.core.time.TempoStrategy;
import com.vel9.generativemusic.aen.core.util.Util;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by levani on 12/12/16.
 */
public class HailBowedPianoMelodySource {

    public static MelodySource getMelody(){
        ScaleStrategy scaleStrategy = StrategyFactory.getChangeScaleStrategy(getScales(36, 72), Util.getSeconds(5));
        NoteStrategy noteStrategy = StrategyFactory.getNoteStrategy(scaleStrategy);

        TempoStrategy tempoStrategy = StrategyFactory.getUpwardTempoStrategy(15, 25, Util.getSeconds(9));
        DynamicsStrategy dynamicsStrategy = StrategyFactory.getGradualUpwardDynamicsStrategy(2, 45, Util.getSeconds(1));
        RhythmStrategy rhythmStrategy = StrategyFactory.getRhythmStrategy(tempoStrategy, dynamicsStrategy, getRhythmicSequences());
        return new SimpleMelodySource(noteStrategy, rhythmStrategy);
    }

    private static Scale[] getScales(int minNote, int maxNote){
        return new Scale[]{
                new Scale(BaseScale.MODE2, NoteType.C, minNote, maxNote),
                new Scale(BaseScale.MODE2, NoteType.C_SHARP, minNote, maxNote),
                new Scale(BaseScale.MODE6, NoteType.C, minNote, maxNote),
                new Scale(BaseScale.MODE6, NoteType.C_SHARP, minNote, maxNote),
                new Scale(BaseScale.MODE6, NoteType.D_SHARP, minNote, maxNote),
                new Scale(BaseScale.MODE3, NoteType.C, minNote, maxNote),
                new Scale(BaseScale.MODE3, NoteType.D, minNote, maxNote)
        };
    }

    private static List<RhythmicSequence> getRhythmicSequences(){
        List<RhythmicSequence> rhythmicSequences = new ArrayList<>();
        rhythmicSequences.addAll(Arrays.asList(DeciTalaRhythmicSequence.values()));
        for (int i = 0; i < 20; i++) {
            //rhythmicSequences.add(SilentRhythmicSequence.QUADRUPLE_WHOLE_SILENCE);
        }
        return rhythmicSequences;
    }
}