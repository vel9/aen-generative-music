package com.vel9.generativemusic.aen.library.pitch;

import com.vel9.generativemusic.aen.core.pitch.IntervalSequence;
import com.vel9.generativemusic.aen.core.util.Util;
import org.apache.commons.lang3.Validate;

import java.util.List;

public class BalancedRandomIntervalSequence implements IntervalSequence {

    private List<IntervalSequence> sequences;

    public BalancedRandomIntervalSequence(List<IntervalSequence> sequences){
        validateSequences(sequences);
        this.sequences = sequences;
    }

    /**
     * Ensures the provided sequences are "balanced" i.e. there are equal
     * number of sequences with a sum value of 1 as there sequences with
     * a sum value of -1
     *
     * Also ensures any sequences that are not 1 or -1, have a 0 sum value
     *
     * @param sequences list of interval sequences
     */
    private void validateSequences(List<IntervalSequence> sequences) {
        int numUpwardSequences = 0;
        int numDownwardSequences = 0;
        for (IntervalSequence intervalSequence : sequences){
            int directionalSum = getDirectionSum(intervalSequence);
            if (directionalSum == 1){
                numUpwardSequences++;
            } else if (directionalSum == -1){
                numDownwardSequences++;
            } else {
                Validate.validState(directionalSum == 0, "directionalSum for the intervalSequence must be 0, 1, or -1");
            }
        }
        Validate.validState(numUpwardSequences == numDownwardSequences,
                "number of upward sequences must equal number of downward sequences");
    }

    @Override
    public int[] getIntervalSequence() {
        return this.sequences.get(Util.getRandom(0, this.sequences.size() - 1)).getIntervalSequence();
    }

    private static int getDirectionSum(IntervalSequence intervalSequence){
        int sum = 0;
        for (int direction : intervalSequence.getIntervalSequence()){
            sum += direction;
        }
        return sum;
    }

}
