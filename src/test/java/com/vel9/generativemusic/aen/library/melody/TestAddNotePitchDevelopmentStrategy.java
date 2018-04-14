package com.vel9.generativemusic.aen.library.melody;

import com.vel9.generativemusic.aen.TestHelperUtils;
import com.vel9.generativemusic.aen.core.melody.MelodySequence;
import com.vel9.generativemusic.aen.core.melody.PitchDevelopmentStrategy;
import com.vel9.generativemusic.aen.core.pitch.BaseScale;
import com.vel9.generativemusic.aen.core.pitch.Note;
import com.vel9.generativemusic.aen.core.pitch.NoteType;
import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;

public class TestAddNotePitchDevelopmentStrategy {

    @Test
    public void develop_singleAddedNote_returnsDevelopedSequence(){
        PitchDevelopmentStrategy strategy = new AddNotePitchDevelopmentStrategy(1);
        ScaleContainer scaleContainer = new ScaleContainer(BaseScale.MAJOR,
                NoteType.C,
                Arrays.asList(Note.create(64), Note.create(65)));

        MelodySequence result = strategy.develop(TestHelperUtils.getSequence(60, 62), scaleContainer);
        Assert.assertTrue(matchesOne(result));
    }

    @Test
    public void develop_twoAddedNotes_returnsDevelopedSequence(){
        PitchDevelopmentStrategy strategy = new AddNotePitchDevelopmentStrategy(2);
        ScaleContainer scaleContainer = new ScaleContainer(BaseScale.MAJOR,
                NoteType.C,
                Arrays.asList(Note.create(64), Note.create(65)));

        MelodySequence result = strategy.develop(TestHelperUtils.getSequence(60, 62), scaleContainer);
        boolean case1 = TestHelperUtils.resultEquals(new int[]{60, 62, 64, 65}, result);
        boolean case2 = TestHelperUtils.resultEquals(new int[]{60, 62, 65, 64}, result);
        boolean case3 = TestHelperUtils.resultEquals(new int[]{60, 64, 65, 62}, result);
        boolean case4 = TestHelperUtils.resultEquals(new int[]{60, 65, 64, 62}, result);
        Assert.assertTrue(case1 || case2 || case3 || case4 || matchesOne(result));
    }

    private boolean matchesOne(MelodySequence result) {
        boolean case1 = TestHelperUtils.resultEquals(new int[]{60, 62, 64}, result);
        boolean case2 = TestHelperUtils.resultEquals(new int[]{60, 62, 65}, result);
        boolean case3 = TestHelperUtils.resultEquals(new int[]{60, 64, 62}, result);
        boolean case4 = TestHelperUtils.resultEquals(new int[]{60, 65, 62}, result);
        return case1 || case2 || case3 || case4;
    }

}
