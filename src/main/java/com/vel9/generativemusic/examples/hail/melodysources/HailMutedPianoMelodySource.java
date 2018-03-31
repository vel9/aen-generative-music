package com.vel9.generativemusic.examples.hail.melodysources;

import com.vel9.generativemusic.aen.core.dynamics.DynamicsStrategy;
import com.vel9.generativemusic.aen.core.pitch.*;
import com.vel9.generativemusic.aen.core.util.Util;
import com.vel9.generativemusic.aen.library.StrategyFactory;
import com.vel9.generativemusic.aen.library.SimpleMelodySource;
import com.vel9.generativemusic.aen.library.time.DeciTalaRhythmicSequence;
import com.vel9.generativemusic.aen.core.MelodySource;
import com.vel9.generativemusic.aen.core.time.RhythmStrategy;
import com.vel9.generativemusic.aen.core.time.RhythmicSequence;
import com.vel9.generativemusic.aen.core.time.TempoStrategy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by levani on 12/12/16.
 */
public class HailMutedPianoMelodySource {

    public static MelodySource getMelody(){
        ScaleStrategy scaleStrategy = StrategyFactory.getChangeScaleStrategy(getScales(60, 108), Util.getSeconds(5));
        NoteStrategy noteStrategy = StrategyFactory.getNoteStrategy(scaleStrategy);

        TempoStrategy tempoStrategy = StrategyFactory.getDownwardTempoStrategy(140, 240, Util.getSeconds(10));
        DynamicsStrategy dynamicsStrategy = StrategyFactory.getGradualUpwardDynamicsStrategy(2, 45, Util.getSeconds(4));
        RhythmStrategy rhythmStrategy = StrategyFactory.getRhythmStrategy(tempoStrategy, dynamicsStrategy, getRhythmicSequences());
        return new SimpleMelodySource(noteStrategy, rhythmStrategy);
    }

    private static Scale[] getScales(int minNote, int maxNote){
        return new Scale[]{
                new Scale(BaseScale.MODE3, NoteType.C, minNote, maxNote),
                new Scale(BaseScale.MAJOR, NoteType.D, minNote, maxNote),
                new Scale(BaseScale.MODE3, NoteType.D, minNote, maxNote),
                new Scale(BaseScale.MAJOR, NoteType.A_FLAT, minNote, maxNote),
                new Scale(BaseScale.MAJOR, NoteType.D_SHARP, minNote, maxNote),
                new Scale(BaseScale.MODE6, NoteType.C, minNote, maxNote),
                new Scale(BaseScale.MODE6, NoteType.C_SHARP, minNote, maxNote),
                new Scale(BaseScale.MAJOR, NoteType.G, minNote, maxNote),
                new Scale(BaseScale.MINOR, NoteType.E_FLAT, minNote, maxNote)
        };
    }

    private static List<RhythmicSequence> getRhythmicSequences(){
        List<RhythmicSequence> rhythmicSequences = new ArrayList<>();
        rhythmicSequences.addAll(Arrays.asList(DeciTalaRhythmicSequence.values()));
        return rhythmicSequences;
    }
}
