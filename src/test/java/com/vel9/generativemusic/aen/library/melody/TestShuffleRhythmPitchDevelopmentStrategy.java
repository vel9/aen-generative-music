package com.vel9.generativemusic.aen.library.melody;

import com.vel9.generativemusic.aen.TestHelperUtils;
import com.vel9.generativemusic.aen.core.melody.MelodyElement;
import com.vel9.generativemusic.aen.core.melody.MelodySequence;
import com.vel9.generativemusic.aen.core.melody.PitchDevelopmentStrategy;
import com.vel9.generativemusic.aen.core.pitch.Note;
import com.vel9.generativemusic.aen.core.time.RhythmicElement;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class TestShuffleRhythmPitchDevelopmentStrategy {

    @Test
    public void develop_twoNoteSequence_returnsDevelopedSequence(){
        PitchDevelopmentStrategy strategy = new ShuffleRhythmPitchDevelopmentStrategy();
        MelodySequence input = getSequence(new int[]{1,2},
                new RhythmicElement[]{RhythmicElement.EIGHTH, RhythmicElement.SIXTEENTH});
        MelodySequence result = strategy.develop(input, null);

        MelodySequence target = getSequence(new int[]{1,2},
                new RhythmicElement[]{RhythmicElement.SIXTEENTH, RhythmicElement.EIGHTH});

        Assert.assertTrue(TestHelperUtils.resultEquals(result, input)
                || TestHelperUtils.resultEquals(result, target));
    }

    @Test
    public void develop_threeNoteSequence_returnsDevelopedSequence(){
        PitchDevelopmentStrategy strategy = new ShuffleRhythmPitchDevelopmentStrategy();
        MelodySequence input = getSequence(new int[]{1,2,3},
                new RhythmicElement[]{RhythmicElement.EIGHTH, RhythmicElement.SIXTEENTH, RhythmicElement.HALF});
        MelodySequence result = strategy.develop(input, null);

        MelodySequence target2 = getSequence(new int[]{1,2,3},
                new RhythmicElement[]{RhythmicElement.EIGHTH, RhythmicElement.HALF, RhythmicElement.SIXTEENTH});

        MelodySequence target3 = getSequence(new int[]{1,2,3},
                new RhythmicElement[]{RhythmicElement.SIXTEENTH, RhythmicElement.EIGHTH, RhythmicElement.HALF});

        MelodySequence target4 = getSequence(new int[]{1,2,3},
                new RhythmicElement[]{RhythmicElement.SIXTEENTH, RhythmicElement.HALF, RhythmicElement.EIGHTH});

        MelodySequence target5 = getSequence(new int[]{1,2,3},
                new RhythmicElement[]{RhythmicElement.HALF, RhythmicElement.SIXTEENTH, RhythmicElement.EIGHTH});

        MelodySequence target6 = getSequence(new int[]{1,2,3},
                new RhythmicElement[]{RhythmicElement.HALF, RhythmicElement.EIGHTH, RhythmicElement.SIXTEENTH});

        boolean case1 = TestHelperUtils.resultEquals(input, result);
        boolean case2 = TestHelperUtils.resultEquals(target2, result);
        boolean case3 = TestHelperUtils.resultEquals(target3, result);
        boolean case4 = TestHelperUtils.resultEquals(target4, result);
        boolean case5 = TestHelperUtils.resultEquals(target5, result);
        boolean case6 = TestHelperUtils.resultEquals(target6, result);
        Assert.assertTrue(case1 || case2 || case3 || case4 || case5 || case6);
    }

    private static MelodySequence getSequence(int[] noteVals, RhythmicElement[] rhythmicElements){
        List<MelodyElement> elements = new ArrayList<>();
        for (int i = 0; i < noteVals.length; i++){
            elements.add(new MelodyElement(Note.create(noteVals[i]),
                    rhythmicElements[i]));
        }
        return new MelodySequence(elements);
    }


}
