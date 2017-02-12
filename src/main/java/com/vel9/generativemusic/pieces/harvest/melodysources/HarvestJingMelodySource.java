package com.vel9.generativemusic.pieces.harvest.melodysources;

import com.vel9.generativemusic.core.MelodySource;
import com.vel9.generativemusic.core.dynamics.DynamicsStrategy;
import com.vel9.generativemusic.core.pitch.NoteStrategy;
import com.vel9.generativemusic.core.pitch.Scale;
import com.vel9.generativemusic.core.pitch.ScaleStrategy;
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
public class HarvestJingMelodySource {

    public static MelodySource getMelody(){
        ScaleStrategy scaleStrategy = StrategyFactory.getSameScaleStrategy(getScale(36, 37));
        NoteStrategy noteStrategy = StrategyFactory.getRandomNoteStrategy(scaleStrategy);

        TempoStrategy tempoStrategy = StrategyFactory.getUpwardTempoStrategy(80, 120, Util.getSeconds(2));
        DynamicsStrategy dynamicsStrategy = StrategyFactory.getRandomDynamicsStrategy(10, 80, Util.getSeconds(3));
        RhythmStrategy rhythmStrategy = StrategyFactory.getRhythmStrategy(tempoStrategy, dynamicsStrategy, getRhythmicSequences());
        return new SimpleMelodySource(noteStrategy, rhythmStrategy);
    }

    private static List<RhythmicSequence> getRhythmicSequences(){
        List<RhythmicSequence> rhythmicSequences = new ArrayList<>();
        rhythmicSequences.addAll(Arrays.asList(DeciTalaRhythmicSequence.values()));
        return rhythmicSequences;
    }

    private static Scale getScale(int... noteVals){
        return Scale.createNonTransposingScale(noteVals);
    }
}
