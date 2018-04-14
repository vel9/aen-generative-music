package com.vel9.generativemusic.aen.library.melody;

import com.vel9.generativemusic.aen.TestHelperUtils;
import com.vel9.generativemusic.aen.core.melody.MelodySequence;
import com.vel9.generativemusic.aen.core.melody.PitchDevelopmentStrategy;
import org.junit.Assert;
import org.junit.Test;

public class TestInvertSequencePitchDevelopmentStrategy {

    @Test
    public void develop_threeNoteSequence_returnsInvertedSequence(){
        PitchDevelopmentStrategy strategy = new InvertSequencePitchDevelopmentStrategy(0, 127);
        MelodySequence result = strategy.develop(TestHelperUtils.getSequence(5, 8, 6), null);
        Assert.assertTrue(TestHelperUtils.resultEquals(new int[]{5, 2, 4}, result));
    }

    @Test
    public void develop_fourNoteSequence_returnsInvertedSequence(){
        PitchDevelopmentStrategy strategy = new InvertSequencePitchDevelopmentStrategy(0, 127);
        MelodySequence result = strategy.develop(TestHelperUtils.getSequence(10, 11, 12, 9), null);
        Assert.assertTrue(TestHelperUtils.resultEquals(new int[]{10, 9, 8, 11}, result));
    }

    @Test
    public void develop_outOfRangeSequenceMin_returnsOriginalSequence(){
        PitchDevelopmentStrategy strategy = new InvertSequencePitchDevelopmentStrategy(0, 127);
        MelodySequence result = strategy.develop(TestHelperUtils.getSequence(5, 11, 6), null);
        Assert.assertTrue(TestHelperUtils.resultEquals(new int[]{5, 11, 6}, result));
    }

    @Test
    public void develop_outOfRangeSequenceMax_returnsOriginalSequence(){
        PitchDevelopmentStrategy strategy = new InvertSequencePitchDevelopmentStrategy(0, 10);
        MelodySequence result = strategy.develop(TestHelperUtils.getSequence(9, 4, 5), null);
        Assert.assertTrue(TestHelperUtils.resultEquals(new int[]{9, 4, 5}, result));
    }

}
