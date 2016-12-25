package com.vel9.generativemusic.pieces.garden.melodysources;

import com.vel9.generativemusic.core.MelodySource;
import com.vel9.generativemusic.core.dynamics.DynamicsStrategy;
import com.vel9.generativemusic.core.pitch.*;
import com.vel9.generativemusic.core.time.RhythmStrategy;
import com.vel9.generativemusic.core.time.RhythmicSequence;
import com.vel9.generativemusic.core.time.TempoStrategy;
import com.vel9.generativemusic.core.util.Util;
import com.vel9.generativemusic.library.SimpleMelodySource;
import com.vel9.generativemusic.library.time.DeciTalaRhythmicSequence;
import com.vel9.generativemusic.library.time.SilentRhythmicSequence;
import com.vel9.generativemusic.pieces.StrategyFactory;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by levani on 12/12/16.
 */
public class GardenMutedPianoMelodySource {

    public static MelodySource getMelody(){
        ScaleStrategy scaleStrategy = StrategyFactory.getScaleStrategy(getScales(36, 96), Util.getSeconds(5));
        NoteStrategy noteStrategy = StrategyFactory.getNoteStrategy(scaleStrategy);

        TempoStrategy tempoStrategy = StrategyFactory.getDownwardTempoStrategy(70, 200, Util.getSeconds(10));
        DynamicsStrategy dynamicsStrategy = StrategyFactory.getUpwardDynamicsStrategy(3, 50, Util.getSeconds(1));
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
        rhythmicSequences.addAll(Arrays.asList(DeciTalaRhythmicSequence.getFastSequences()));
        for (int i = 0; i < 20; i++) {
            rhythmicSequences.add(SilentRhythmicSequence.QUADRUPLE_WHOLE_SILENCE);
            rhythmicSequences.add(SilentRhythmicSequence.TRIPLE_WHOLE_SILENCE);
        }
        return rhythmicSequences;
    }
}
