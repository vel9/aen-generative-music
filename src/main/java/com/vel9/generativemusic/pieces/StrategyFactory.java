package com.vel9.generativemusic.pieces;

import com.vel9.generativemusic.core.dynamics.DynamicsStrategy;
import com.vel9.generativemusic.core.pitch.NoteStrategy;
import com.vel9.generativemusic.core.pitch.Scale;
import com.vel9.generativemusic.core.pitch.ScaleStrategy;
import com.vel9.generativemusic.core.support.Direction;
import com.vel9.generativemusic.core.time.RhythmStrategy;
import com.vel9.generativemusic.core.time.RhythmicSequence;
import com.vel9.generativemusic.core.time.TempoStrategy;
import com.vel9.generativemusic.library.dynamics.GradualDynamicsStrategy;
import com.vel9.generativemusic.library.dynamics.RandomDynamicsStrategy;
import com.vel9.generativemusic.library.pitch.ChangeScaleStrategy;
import com.vel9.generativemusic.library.pitch.PlainchantNoteStrategy;
import com.vel9.generativemusic.library.pitch.RandomNoteStrategy;
import com.vel9.generativemusic.library.pitch.SameScaleStrategy;
import com.vel9.generativemusic.library.time.GradualTempoStrategy;
import com.vel9.generativemusic.library.time.RandomRhythmStrategy;

import java.util.List;

/**
 * Created by levani on 12/12/16.
 */
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

    public static TempoStrategy getUpwardTempoStrategy(int minTempo, int maxTempo, int rateOfChange) {
        return new GradualTempoStrategy(minTempo, maxTempo, Direction.UP, rateOfChange);
    }

    public static TempoStrategy getDownwardTempoStrategy(int minTempo, int maxTempo, int rateOfChange) {
        return new GradualTempoStrategy(minTempo, maxTempo, Direction.DOWN, rateOfChange);
    }

    public static RhythmStrategy getRhythmStrategy(TempoStrategy tempoStrategy,
                                                   DynamicsStrategy dynamicsStrategy,
                                                   List<RhythmicSequence> rhythmicSequences){
        return new RandomRhythmStrategy(tempoStrategy, dynamicsStrategy, rhythmicSequences);
    }
}
