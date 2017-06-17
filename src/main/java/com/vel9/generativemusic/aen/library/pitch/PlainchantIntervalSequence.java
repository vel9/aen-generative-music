package com.vel9.generativemusic.aen.library.pitch;

import com.vel9.generativemusic.aen.core.pitch.IntervalSequence;

/* Messiaen: Treatise on Rhythm, Color and Ornithology, Tome IV, page 35 */
public enum PlainchantIntervalSequence implements IntervalSequence {
    PORRECTUS(-1, +1), // 0
    PORRECTUS_FLEXUS(-1, +1, -1), // -1
    TORCULUS(+1, -1), // 0
    CLIMACUS(-1, -1), // -2
    SCANDICUS_FLEXUS(+1, +1, -1), // +1
    CLIMACUS_RESUPINUS(-1, -1, +1); // -1

    private int[] intervalSequence;

    PlainchantIntervalSequence(int... sequence){
        this.intervalSequence = sequence;
    }

    @Override
    public int[] getIntervalSequence() {
        return this.intervalSequence;
    }

}
