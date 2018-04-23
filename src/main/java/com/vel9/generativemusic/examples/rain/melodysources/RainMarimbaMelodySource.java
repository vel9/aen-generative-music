package com.vel9.generativemusic.examples.rain.melodysources;

import com.vel9.generativemusic.aen.core.pitch.*;
import com.vel9.generativemusic.aen.library.SimpleMelodySource;
import com.vel9.generativemusic.aen.library.time.DeciTalaRhythmicSequence;
import com.vel9.generativemusic.aen.core.MelodySource;
import com.vel9.generativemusic.aen.core.dynamics.DynamicsStrategy;
import com.vel9.generativemusic.aen.core.time.RhythmStrategy;
import com.vel9.generativemusic.aen.core.time.RhythmicSequence;
import com.vel9.generativemusic.aen.core.time.TempoStrategy;
import com.vel9.generativemusic.aen.core.util.Util;
import com.vel9.generativemusic.aen.library.StrategyFactory;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class RainMarimbaMelodySource {

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
                // mode 3
                Scale.createTransposingScale(BaseScale.MODE3, NoteType.C, minNote, maxNote),
                Scale.createTransposingScale(BaseScale.MODE3, NoteType.C_SHARP, minNote, maxNote),
                Scale.createTransposingScale(BaseScale.MODE3, NoteType.D, minNote, maxNote),
                Scale.createTransposingScale(BaseScale.MODE3, NoteType.E_FLAT, minNote, maxNote),
                Scale.createTransposingScale(BaseScale.MODE3, NoteType.E, minNote, maxNote),
                Scale.createTransposingScale(BaseScale.MODE3, NoteType.F, minNote, maxNote),
                Scale.createTransposingScale(BaseScale.MODE3, NoteType.G_FLAT, minNote, maxNote),
                Scale.createTransposingScale(BaseScale.MODE3, NoteType.G, minNote, maxNote),
                // mode 6
                Scale.createTransposingScale(BaseScale.MODE6, NoteType.C, minNote, maxNote),
                Scale.createTransposingScale(BaseScale.MODE6, NoteType.C_SHARP, minNote, maxNote),
                Scale.createTransposingScale(BaseScale.MODE6, NoteType.D, minNote, maxNote),
                Scale.createTransposingScale(BaseScale.MODE6, NoteType.E_FLAT, minNote, maxNote),
                // major
                Scale.createTransposingScale(BaseScale.MAJOR, NoteType.B_FLAT, minNote, maxNote),
                Scale.createTransposingScale(BaseScale.MAJOR, NoteType.A_FLAT, minNote, maxNote),
                Scale.createTransposingScale(BaseScale.MAJOR, NoteType.E_FLAT, minNote, maxNote),
                Scale.createTransposingScale(BaseScale.MAJOR, NoteType.E, minNote, maxNote),
                Scale.createTransposingScale(BaseScale.MAJOR, NoteType.C, minNote, maxNote)
        };
    }

    private static List<RhythmicSequence> getRhythmicSequences(){
        List<RhythmicSequence> rhythmicSequences = new ArrayList<>();
        rhythmicSequences.addAll(Arrays.asList(DeciTalaRhythmicSequence.values()));
        return rhythmicSequences;
    }
}
