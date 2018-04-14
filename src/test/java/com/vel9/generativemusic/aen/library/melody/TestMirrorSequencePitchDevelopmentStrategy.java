package com.vel9.generativemusic.aen.library.melody;

import com.vel9.generativemusic.aen.TestHelperUtils;
import com.vel9.generativemusic.aen.core.melody.MelodySequence;
import com.vel9.generativemusic.aen.core.melody.PitchDevelopmentStrategy;
import org.junit.Assert;
import org.junit.Test;

public class TestMirrorSequencePitchDevelopmentStrategy {

    @Test
    public void develop_threeNoteSequence_returnsInvertedSequence(){
        PitchDevelopmentStrategy strategy = new MirrorSequencePitchDevelopmentStrategy();
        MelodySequence result = strategy.develop(TestHelperUtils.getSequence(5, 8, 6), null);
        Assert.assertTrue(TestHelperUtils.resultEquals(new int[]{8, 5}, result));
    }

    @Test
    public void develop_fourNoteSequence_returnsInvertedSequence(){
        PitchDevelopmentStrategy strategy = new MirrorSequencePitchDevelopmentStrategy();
        MelodySequence result = strategy.develop(TestHelperUtils.getSequence(10, 11, 12, 9), null);
        Assert.assertTrue(TestHelperUtils.resultEquals(new int[]{12, 11, 10}, result));
    }

    @Test
    public void develop_twoNoteSequence_returnsInvertedSequence(){
        PitchDevelopmentStrategy strategy = new MirrorSequencePitchDevelopmentStrategy();
        MelodySequence result = strategy.develop(TestHelperUtils.getSequence(10, 11), null);
        Assert.assertTrue(TestHelperUtils.resultEquals(new int[]{10, 11}, result));
    }

}
