package com.vel9.generativemusic.aen.examples.pieces.stream.melodysource;

import com.vel9.generativemusic.aen.core.MelodySource;
import com.vel9.generativemusic.aen.core.dynamics.DynamicsStrategy;
import com.vel9.generativemusic.aen.core.pitch.NoteStrategy;
import com.vel9.generativemusic.aen.core.pitch.Scale;
import com.vel9.generativemusic.aen.core.pitch.ScaleStrategy;
import com.vel9.generativemusic.aen.core.time.RhythmStrategy;
import com.vel9.generativemusic.aen.core.time.RhythmicSequence;
import com.vel9.generativemusic.aen.core.time.TempoStrategy;
import com.vel9.generativemusic.aen.core.util.Util;
import com.vel9.generativemusic.aen.library.SimpleMelodySource;
import com.vel9.generativemusic.aen.library.time.DeciTalaRhythmicSequence;
import com.vel9.generativemusic.aen.examples.pieces.StrategyFactory;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class StreamThematicChordRandomMelodySource {

    // EbM 63 -> 67 -> 70 | CM 72 -> 76 - 79
    // DM 61 -> 65 -> 68 | BM 70 -> 74 - 78
    // EM 64 -> 68 -> 71 | C# 73 -> 77 - 80
    public static MelodySource getMelody(int startingPitch){
        // CM -> AM -> C#M
        int startingPitchSecondChord = startingPitch + 9;
        int startingPitchThirdChord = startingPitchSecondChord + 4;
        Scale scale = getScale(startingPitch,
                startingPitch + 4,
                startingPitch + 7,
                startingPitchSecondChord,
                startingPitchSecondChord + 4,
                startingPitchSecondChord + 7,
                startingPitchThirdChord,
                startingPitchThirdChord + 4,
                startingPitchThirdChord + 7);

        ScaleStrategy scaleStrategy = StrategyFactory.getSameScaleStrategy(scale);
        NoteStrategy noteStrategy = StrategyFactory.getRandomNoteStrategy(scaleStrategy);

        TempoStrategy tempoStrategy = StrategyFactory.getUpwardTempoStrategy(40, 140, Util.getSeconds(5));
        DynamicsStrategy dynamicsStrategy = StrategyFactory.getRandomDynamicsStrategy(10 , 50, Util.getSeconds(3));
        RhythmStrategy rhythmStrategy = StrategyFactory.getRhythmStrategy(tempoStrategy, dynamicsStrategy, getRhythmicSequences());
        return new SimpleMelodySource(noteStrategy, rhythmStrategy);
    }

    private static List<RhythmicSequence> getRhythmicSequences(){
        List<RhythmicSequence> rhythmicSequences = new ArrayList<>();
        rhythmicSequences.addAll(Arrays.asList(DeciTalaRhythmicSequence.values()));
        return rhythmicSequences;
    }

    private static Scale getScale(int... noteVal){
        return Scale.createNonTransposingScale(noteVal);
    }
}
