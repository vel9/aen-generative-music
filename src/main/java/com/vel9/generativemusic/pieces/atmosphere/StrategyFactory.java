package com.vel9.generativemusic.pieces.atmosphere;

import com.vel9.generativemusic.core.dynamics.DynamicsStrategy;
import com.vel9.generativemusic.core.pitch.NoteStrategy;
import com.vel9.generativemusic.core.pitch.Scale;
import com.vel9.generativemusic.core.pitch.ScaleStrategy;
import com.vel9.generativemusic.core.support.Direction;
import com.vel9.generativemusic.core.time.RhythmStrategy;
import com.vel9.generativemusic.core.time.RhythmicSequence;
import com.vel9.generativemusic.core.time.TempoStrategy;
import com.vel9.generativemusic.library.dynamics.GradualDynamicsStrategy;
import com.vel9.generativemusic.library.pitch.ChangeScaleStrategy;
import com.vel9.generativemusic.library.pitch.PlainchantNoteStrategy;
import com.vel9.generativemusic.library.time.GradualTempoStrategy;
import com.vel9.generativemusic.library.time.RandomRhythmStrategy;

import java.util.List;

/**
 * Created by levani on 12/12/16.
 */
public class StrategyFactory {

    public static ScaleStrategy getScaleStrategy(Scale[] scales, int scaleRateOfChange) {
        return new ChangeScaleStrategy(scaleRateOfChange, scales);
    }

    public static NoteStrategy getNoteStrategy(ScaleStrategy scaleStrategy){
        return new PlainchantNoteStrategy(scaleStrategy);
    }

    public static DynamicsStrategy getDynamicsStrategy(int minVelocity, int maxVelocity, int rateOfChange) {
        return new GradualDynamicsStrategy(minVelocity, maxVelocity, Direction.UP, rateOfChange);
    }

    public static TempoStrategy getTempoStrategy(int minTempo, int maxTempo, int rateOfChange) {
        return new GradualTempoStrategy(minTempo, maxTempo, Direction.UP, rateOfChange);
    }

    public static RhythmStrategy getRhythmStrategy(TempoStrategy tempoStrategy,
                                                   DynamicsStrategy dynamicsStrategy,
                                                   List<RhythmicSequence> rhythmicSequences){
        return new RandomRhythmStrategy(tempoStrategy, dynamicsStrategy, rhythmicSequences);
    }
}
