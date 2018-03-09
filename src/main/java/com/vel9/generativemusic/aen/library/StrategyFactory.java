package com.vel9.generativemusic.aen.library;

import com.vel9.generativemusic.aen.core.dynamics.DynamicsStrategy;
import com.vel9.generativemusic.aen.core.pitch.NoteStrategy;
import com.vel9.generativemusic.aen.core.pitch.Scale;
import com.vel9.generativemusic.aen.core.pitch.ScaleStrategy;
import com.vel9.generativemusic.aen.core.support.Direction;
import com.vel9.generativemusic.aen.core.time.RhythmStrategy;
import com.vel9.generativemusic.aen.core.time.RhythmicSequence;
import com.vel9.generativemusic.aen.core.time.TempoStrategy;
import com.vel9.generativemusic.aen.library.dynamics.GradualDynamicsStrategy;
import com.vel9.generativemusic.aen.library.dynamics.RandomDynamicsStrategy;
import com.vel9.generativemusic.aen.library.dynamics.VariablePeakDynamicsStrategy;
import com.vel9.generativemusic.aen.library.pitch.ChangeScaleStrategy;
import com.vel9.generativemusic.aen.library.pitch.PlainchantNoteStrategy;
import com.vel9.generativemusic.aen.library.pitch.RandomNoteStrategy;
import com.vel9.generativemusic.aen.library.pitch.SameScaleStrategy;
import com.vel9.generativemusic.aen.library.time.FixedRhythmStrategy;
import com.vel9.generativemusic.aen.library.time.GradualTempoStrategy;
import com.vel9.generativemusic.aen.library.time.RandomRhythmStrategy;
import com.vel9.generativemusic.aen.library.time.VariablePeakTempoStrategy;

import java.util.List;

public class StrategyFactory {

    public static ScaleStrategy getChangeScaleStrategy(Scale[] scales, int scaleRateOfChange) {
        return new ChangeScaleStrategy(scaleRateOfChange, scales);
    }

    public static ScaleStrategy getSameScaleStrategy(Scale scale){
        return new SameScaleStrategy(scale);
    }

    public static NoteStrategy getNoteStrategy(ScaleStrategy scaleStrategy){
        return new PlainchantNoteStrategy(scaleStrategy);
    }

    public static NoteStrategy getRandomNoteStrategy(ScaleStrategy scaleStrategy){
        return new RandomNoteStrategy(scaleStrategy);
    }

    public static DynamicsStrategy getGradualUpwardDynamicsStrategy(int minVelocity, int maxVelocity, int rateOfChange) {
        return new GradualDynamicsStrategy(minVelocity, maxVelocity, Direction.UP, rateOfChange);
    }

    public static DynamicsStrategy getGradualDownwardDynamicsStrategy(int minVelocity, int maxVelocity, int rateOfChange) {
        return new GradualDynamicsStrategy(minVelocity, maxVelocity, Direction.DOWN, rateOfChange);
    }

    public static DynamicsStrategy getRandomDynamicsStrategy(int minVelocity, int maxVelocity, int rateOfChange){
        return new RandomDynamicsStrategy(minVelocity, maxVelocity, rateOfChange);
    }

    public static DynamicsStrategy getVariablePeakDynamicsStrategy(int minVelocityLower,
                                                                   int minVelocityUpper,
                                                                   int maxVelocityLower,
                                                                   int maxVelocityUpper,
                                                                   int rateInMillis){
        return new VariablePeakDynamicsStrategy(minVelocityLower,
                                                minVelocityUpper,
                                                maxVelocityLower,
                                                maxVelocityUpper,
                                                rateInMillis);
    }

    public static TempoStrategy getUpwardTempoStrategy(int minTempo, int maxTempo, int rateOfChange) {
        return new GradualTempoStrategy(minTempo, maxTempo, Direction.UP, rateOfChange);
    }

    public static TempoStrategy getDownwardTempoStrategy(int minTempo, int maxTempo, int rateOfChange) {
        return new GradualTempoStrategy(minTempo, maxTempo, Direction.DOWN, rateOfChange);
    }

    public static TempoStrategy getVariablePeakTempoStrategy(int minBpmLower,
                                                             int minBpmUpper,
                                                             int maxBpmLower,
                                                             int maxBpmUpper,
                                                             int rateInMillis){
        return new VariablePeakTempoStrategy(minBpmLower,
                                             minBpmUpper,
                                             maxBpmLower,
                                             maxBpmUpper,
                                             rateInMillis);
    }

    public static RhythmStrategy getRhythmStrategy(TempoStrategy tempoStrategy,
                                                   DynamicsStrategy dynamicsStrategy,
                                                   List<RhythmicSequence> rhythmicSequences){
        return new RandomRhythmStrategy(tempoStrategy, dynamicsStrategy, rhythmicSequences);
    }

    public static RhythmStrategy getFixedRhythmStrategy(TempoStrategy tempoStrategy,
                                                   DynamicsStrategy dynamicsStrategy,
                                                   List<RhythmicSequence> rhythmicSequences){
        return new FixedRhythmStrategy(tempoStrategy, dynamicsStrategy, rhythmicSequences);
    }
}
