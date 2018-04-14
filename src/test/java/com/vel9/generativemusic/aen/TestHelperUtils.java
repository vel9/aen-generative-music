package com.vel9.generativemusic.aen;

import com.vel9.generativemusic.aen.core.melody.MelodyElement;
import com.vel9.generativemusic.aen.core.melody.MelodySequence;
import com.vel9.generativemusic.aen.core.pitch.Note;
import com.vel9.generativemusic.aen.core.time.RhythmicElement;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TestHelperUtils {

    public static MelodySequence getSequence(int... noteVals){
        List<MelodyElement> elements = new ArrayList<>();
        for (int val : noteVals){
            elements.add(new MelodyElement(Note.create(val), RhythmicElement.EIGHTH));
        }
        return new MelodySequence(elements);
    }

    public static boolean resultEquals(int[] target, MelodySequence result){
        List<MelodyElement> elements = result.getMelodyElements();
        int[] resultVals = new int[elements.size()];
        for (int i = 0; i < elements.size(); i++){
            resultVals[i] = elements.get(i).getNote().getValue();
        }
        return Arrays.equals(target, resultVals);
    }

    public static boolean resultEquals(MelodySequence target, MelodySequence result){
        List<MelodyElement> resultElements = result.getMelodyElements();
        List<MelodyElement> targetElements = target.getMelodyElements();
        for (int i = 0; i < resultElements.size(); i++){
            MelodyElement resultElement = resultElements.get(i);
            MelodyElement targetElement = targetElements.get(i);
            if (resultElement.getNote().getValue() != targetElement.getNote().getValue()
                    || resultElement.getRhythmicElement() != targetElement.getRhythmicElement()){
                return false;
            }
        }
        return true;
    }

}
