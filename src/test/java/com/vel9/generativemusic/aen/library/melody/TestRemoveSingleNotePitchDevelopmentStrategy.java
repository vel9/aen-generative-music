package com.vel9.generativemusic.aen.library.melody;

import com.vel9.generativemusic.aen.TestHelperUtils;
import com.vel9.generativemusic.aen.core.melody.MelodySequence;
import com.vel9.generativemusic.aen.core.melody.PitchDevelopmentStrategy;
import org.junit.Assert;
import org.junit.Test;

public class TestRemoveSingleNotePitchDevelopmentStrategy {

    @Test
    public void develop_twoNoteSequence_returnsDevelopedSequence(){
        PitchDevelopmentStrategy strategy = new RemoveSingleNotePitchDevelopmentStrategy();
        MelodySequence result = strategy.develop(TestHelperUtils.getSequence(60, 62), null);
        Assert.assertTrue(TestHelperUtils.resultEquals(new int[]{60, 62}, result));
    }

    @Test
    public void develop_threeNoteSequence_returnsDevelopedSequence(){
        PitchDevelopmentStrategy strategy = new RemoveSingleNotePitchDevelopmentStrategy();
        MelodySequence result = strategy.develop(TestHelperUtils.getSequence(60, 62, 64), null);
        boolean case1 = TestHelperUtils.resultEquals(new int[]{60, 64}, result);
        boolean case2 = TestHelperUtils.resultEquals(new int[]{62, 64}, result);
        boolean case3 = TestHelperUtils.resultEquals(new int[]{60, 62}, result);
        Assert.assertTrue(case1 || case2 || case3);
    }

}
