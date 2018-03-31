package com.vel9.generativemusic.aen.library.pitch;

import com.vel9.generativemusic.aen.core.pitch.IntervalSequence;
import com.vel9.generativemusic.aen.core.pitch.Note;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TestRandomDirectionalJumpSelector {

    private static final int MAX_JUMP = 1;

    @Test
    public void next_downUpSequence_returnsOrderedSequence(){
        IntervalSequence intervalSequence = getIntervalSequence(-1, 1);
        BalancedRandomIntervalSequence bris = getBalancedRandomIntervalSequence(intervalSequence);
        List<Note> items = getNotes(0, 1, 2, 3, 4);
        RandomDirectionalJumpSelector randomSelector = new RandomDirectionalJumpSelector(MAX_JUMP, items.get(2), bris);
        Note first = randomSelector.next(items);
        Note second = randomSelector.next(items);
        Assert.assertTrue(first.getValue() < 2 && second.getValue() > first.getValue());
    }

    @Test
    public void next_downUpSequenceRepeated_returnsOrderedSequence(){
        IntervalSequence intervalSequence = getIntervalSequence(-1, -1, 1, 1);
        BalancedRandomIntervalSequence bris = getBalancedRandomIntervalSequence(intervalSequence);
        List<Note> items = getNotes(0, 1, 2);
        RandomDirectionalJumpSelector randomSelector = new RandomDirectionalJumpSelector(MAX_JUMP, items.get(2), bris);
        Note first = randomSelector.next(items);
        Note second = randomSelector.next(items);
        Assert.assertTrue(first.getValue() == 1 && second.getValue() == 0);
    }

    @Test
    public void next_upDownDownSequence_returnsSequence(){
        IntervalSequence intervalSequence = getIntervalSequence(1, -1, -1, 1);
        BalancedRandomIntervalSequence bris = getBalancedRandomIntervalSequence(intervalSequence);
        List<Note> items = getNotes(0, 1, 2);
        RandomDirectionalJumpSelector randomSelector = new RandomDirectionalJumpSelector(MAX_JUMP, items.get(1), bris);
        Note first = randomSelector.next(items);
        Note second = randomSelector.next(items);
        Note third = randomSelector.next(items);
        Assert.assertTrue(first.getValue() == 2 && second.getValue() == 1 && third.getValue() == 0);
    }

    @Test
    public void next_downUpUpSequence_returnsSequence(){
        IntervalSequence intervalSequence = getIntervalSequence(-1, 1, 1, -1);
        BalancedRandomIntervalSequence bris = getBalancedRandomIntervalSequence(intervalSequence);
        List<Note> items = getNotes(0, 1, 2);
        RandomDirectionalJumpSelector randomSelector = new RandomDirectionalJumpSelector(MAX_JUMP, items.get(1), bris);
        Note first = randomSelector.next(items);
        Note second = randomSelector.next(items);
        Note third = randomSelector.next(items);
        Assert.assertTrue(first.getValue() == 0 && second.getValue() == 1 && third.getValue() == 2);
    }

    @Test
    public void next_downUpDownSequence_returnsSequence(){
        IntervalSequence intervalSequence = getIntervalSequence(-1, 1);
        BalancedRandomIntervalSequence bris = getBalancedRandomIntervalSequence(intervalSequence);
        List<Note> items = getNotes(0, 1, 2);
        RandomDirectionalJumpSelector randomSelector = new RandomDirectionalJumpSelector(MAX_JUMP, items.get(1), bris);
        Note first = randomSelector.next(items);
        Note second = randomSelector.next(items);
        Note third = randomSelector.next(items);
        Assert.assertTrue(first.getValue() == 0 && second.getValue() == 1 && third.getValue() == 0);
    }

    @Test
    public void next_fewerNotesThanSequenceSizeUpFirst_returnsSequence(){
        IntervalSequence intervalSequence = getIntervalSequence(1, 1, -1, -1);
        BalancedRandomIntervalSequence bris = getBalancedRandomIntervalSequence(intervalSequence);
        List<Note> items = getNotes(0, 1);
        RandomDirectionalJumpSelector randomSelector = new RandomDirectionalJumpSelector(MAX_JUMP, items.get(0), bris);
        Note first = randomSelector.next(items);
        Note second = randomSelector.next(items);
        Note third = randomSelector.next(items);
        Note four = randomSelector.next(items);
        Assert.assertTrue(first.getValue() == 1 && second.getValue() == 0
                && third.getValue() == 1 && four.getValue() == 0);
    }

    @Test
    public void next_fewerNotesThanSequenceSizeDownFirst_returnsSequence(){
        IntervalSequence intervalSequence = getIntervalSequence(-1, -1, 1, 1);
        BalancedRandomIntervalSequence bris = getBalancedRandomIntervalSequence(intervalSequence);
        List<Note> items = getNotes(0, 1);
        RandomDirectionalJumpSelector randomSelector = new RandomDirectionalJumpSelector(MAX_JUMP, items.get(0), bris);
        Note first = randomSelector.next(items);
        Note second = randomSelector.next(items);
        Note third = randomSelector.next(items);
        Note four = randomSelector.next(items);
        Assert.assertTrue(first.getValue() == 1 && second.getValue() == 0
                && third.getValue() == 1 && four.getValue() == 0);
    }

    @Test(expected=IllegalStateException.class)
    public void next_invalidNotesList_throwsException(){
        IntervalSequence intervalSequence = getIntervalSequence(-1, 1);
        BalancedRandomIntervalSequence bris = getBalancedRandomIntervalSequence(intervalSequence);
        List<Note> items = getNotes(0);
        RandomDirectionalJumpSelector randomSelector = new RandomDirectionalJumpSelector(MAX_JUMP, items.get(0), bris);
        randomSelector.next(items);
    }

    private IntervalSequence getIntervalSequence(int... arr){
        return () -> arr;
    }

    private List<Note> getNotes(int... noteVals){
        List<Note> notes = new ArrayList<>();
        for (int val : noteVals){
            notes.add(new Note(val));
        }
        return notes;
    }

    private BalancedRandomIntervalSequence getBalancedRandomIntervalSequence(IntervalSequence intervalSequence) {
        return new BalancedRandomIntervalSequence(Arrays.asList(intervalSequence));
    }
}
