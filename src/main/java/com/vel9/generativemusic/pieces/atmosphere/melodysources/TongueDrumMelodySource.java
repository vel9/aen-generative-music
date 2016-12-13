package com.vel9.generativemusic.pieces.atmosphere.melodysources;

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
import com.vel9.generativemusic.pieces.atmosphere.StrategyFactory;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by levani on 12/12/16.
 */
public class TongueDrumMelodySource {

    public static MelodySource getMelody(){
        ScaleStrategy scaleStrategy = StrategyFactory.getScaleStrategy(getScales(64, 102), Util.getSeconds(6));
        NoteStrategy noteStrategy = StrategyFactory.getNoteStrategy(scaleStrategy);

        TempoStrategy tempoStrategy = StrategyFactory.getTempoStrategy(70, 200, Util.getSeconds(3));
        DynamicsStrategy dynamicsStrategy = StrategyFactory.getDynamicsStrategy(2, 35, Util.getSeconds(4));
        RhythmStrategy rhythmStrategy = StrategyFactory.getRhythmStrategy(tempoStrategy, dynamicsStrategy, getRhythmicSequences());
        return new SimpleMelodySource(noteStrategy, rhythmStrategy);
    }

    private static Scale[] getScales(int minNote, int maxNote){
        return new Scale[]{new Scale(BaseScale.MODE2, NoteType.C, minNote, maxNote),
                new Scale(BaseScale.MINOR, NoteType.D, minNote, maxNote),
                new Scale(BaseScale.MINOR, NoteType.F_SHARP, minNote, maxNote),
                new Scale(BaseScale.MINOR, NoteType.C, minNote, maxNote),
                new Scale(BaseScale.MINOR, NoteType.A_FLAT, minNote, maxNote),
                new Scale(BaseScale.MODE2, NoteType.F_SHARP, minNote, maxNote),
                new Scale(BaseScale.MODE2, NoteType.D_SHARP, minNote, maxNote),
                new Scale(BaseScale.MODE2, NoteType.B_FLAT, minNote, maxNote),
                new Scale(BaseScale.MODE2, NoteType.D, minNote, maxNote)
        };
    }

    private static List<RhythmicSequence> getRhythmicSequences(){
        List<RhythmicSequence> rhythmicSequences = new ArrayList<>();
        rhythmicSequences.addAll(Arrays.asList(DeciTalaRhythmicSequence.values()));
        for (int i = 0; i < 6; i++) {
            rhythmicSequences.add(SilentRhythmicSequence.QUADRUPLE_WHOLE_SILENCE);
            rhythmicSequences.add(SilentRhythmicSequence.TRIPLE_WHOLE_SILENCE);
        }
        return rhythmicSequences;
    }

}
