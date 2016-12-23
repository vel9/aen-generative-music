package com.vel9.generativemusic.library.pitch;

import com.vel9.generativemusic.core.pitch.IntervalSequence;

public enum PlainchantIntervalSequence implements IntervalSequence {
    PORRECTUS(-1, +1), // 0
    PORRECTUS_FLEXUS(-1, +1, -1), // -1
    TORCULUS(+1, -1), // 0
    CLIMACUS(-1, -1), // -2
    SCANDICUS_FLEXUS(+1, +1, -1), // +1
    CLIMACUS_RESUPINUS(-1, -1, +1); // -1

    private int[] intervalSequence;
    private boolean isFixed;

    PlainchantIntervalSequence(int... sequence){
        this.intervalSequence = sequence;
    }

    @Override
    public int[] getIntervalSequence() {
        return this.intervalSequence;
    }

}
