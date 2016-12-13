package com.vel9.generativemusic.library.pitch;

import com.vel9.generativemusic.core.pitch.IntervalSequence;
import com.vel9.generativemusic.core.pitch.Note;
import com.vel9.generativemusic.core.pitch.NoteStrategy;
import com.vel9.generativemusic.core.pitch.ScaleStrategy;
import com.vel9.generativemusic.core.util.Log;
import com.vel9.generativemusic.core.util.Util;

import java.util.ArrayList;
import java.util.List;

import static com.vel9.generativemusic.library.pitch.PlainchantIntervalSequence.*;

/**
 * Created by levani on 12/4/16.
 */
public class PlainchantNoteStrategy implements NoteStrategy {

    private static final String TAG = PlainchantNoteStrategy.class.getSimpleName();

    private ScaleStrategy scaleStrategy;
    private List<IntervalSequence> intervalSequences;

    private int prevNoteIndex;
    private int maxJump;
    private int sequenceIndex;
    private int sequenceElementIndex;

    private int[] indexesInCurrentSequence;

    public PlainchantNoteStrategy(ScaleStrategy scaleStrategy){
        this.scaleStrategy = scaleStrategy;
        this.prevNoteIndex = getDefaultPrevNoteIndex(scaleStrategy);
        this.maxJump = getMaxJump(scaleStrategy);
        // add plainchant sequences
        this.intervalSequences = getIntervalSequences();
    }

    public static List<IntervalSequence> getIntervalSequences(){
        List<IntervalSequence> intervalSequences = new ArrayList<>();
        // index 0 = start ascent
        // sequences with more up than down movement
        intervalSequences.add(SCANDICUS_FLEXUS); // +1
        intervalSequences.add(SCANDICUS_FLEXUS); // +1
        intervalSequences.add(SCANDICUS_FLEXUS); // +1
        // sequences with equal up and down movements
        intervalSequences.add(PORRECTUS); // 0
        intervalSequences.add(TORCULUS); // 0
        // index intervalSequences.size() - 3 to force decent
        // sequencesw with more down than up movement
        intervalSequences.add(CLIMACUS); // -1
        intervalSequences.add(PORRECTUS_FLEXUS); // -1
        intervalSequences.add(CLIMACUS_RESUPINUS); // -1
        return intervalSequences;
    }

    private int getDefaultPrevNoteIndex(ScaleStrategy scaleStrategy) {
        List<Note> allNotes = scaleStrategy.getScale().getAllNotes();
        Log.config(TAG, allNotes);
        // select middle time as the anchor,
        return allNotes.size()/2;
    }

    private int getMaxJump(ScaleStrategy scaleStrategy) {
        //-1 so we don't include a higher octave version of the starting time
        return scaleStrategy.getScale().scaleSize() - 1;
    }

    public Note nextNote() {
        List<Note> allNotes = this.scaleStrategy.getScale().getAllNotes();
        int[] sequence = this.intervalSequences.get(this.sequenceIndex).getIntervalSequence();
        int nextNoteIndex = getNextNoteIndex(allNotes, sequence[this.sequenceElementIndex]);

        saveNoteIndex(sequence, nextNoteIndex);

        if (!perhapseManageRangeEdges(allNotes, nextNoteIndex)
                && this.prevNoteIndex != nextNoteIndex){
            // only move to next sequence element if notes are different
            // and we're not at the edge
            this.prevNoteIndex = nextNoteIndex;
            moveToNextSequenceElement(sequence);
        }

        return allNotes.get(nextNoteIndex);
    }

    private void saveNoteIndex(int[] sequence, int nextNoteIndex) {
        if (this.sequenceElementIndex == 0){
            indexesInCurrentSequence = new int[sequence.length];
            for (int i = 0; i < indexesInCurrentSequence.length; i++){
                indexesInCurrentSequence[i] = -1;
            }
        }
        if (this.sequenceElementIndex != sequence.length) {
            indexesInCurrentSequence[this.sequenceElementIndex] = nextNoteIndex;
        }
    }

    private boolean perhapseManageRangeEdges(List<Note> allNotes, int nextNoteIndex) {
        if (nextNoteIndex == 0){
            this.sequenceIndex = 0; // raise the time
            this.sequenceElementIndex = 0;
            return true;
        }

        if (nextNoteIndex == allNotes.size() - 1){
            this.sequenceIndex = intervalSequences.size() - 3;
            this.sequenceElementIndex = 0;
            return true;
        }

        return false;
    }

    /* sequenceElement represents the direction of leap */
    private int getNextNoteIndex(List<Note> allNotes, int jumpDirection) {
        int absJumpVal = Util.getRandom(0, this.maxJump);
        int jumpVal = absJumpVal * jumpDirection;
        int nextNoteIndex = this.prevNoteIndex + jumpVal;
        if (nextNoteIndex < 0 || nextNoteIndex >= allNotes.size()
                || isAlreadyPlayed(nextNoteIndex)){
            if (isInACorner(allNotes, jumpDirection)){
                return handleCorner(allNotes, nextNoteIndex);
            }
            return getNextNoteIndex(allNotes, jumpDirection);
        } else {
            return nextNoteIndex;
        }
    }

    private int handleCorner(List<Note> allNotes, int nextNoteIndex) {
        if (nextNoteIndex < 0){
            return 0;
        } else if (nextNoteIndex >= allNotes.size()){
            return allNotes.size() - 1;
        } else {
            return nextNoteIndex;
        }
    }

    private boolean isInACorner(List<Note> allNotes, int jumpDirection) {
        if (jumpDirection == 1) {
            for (int i = this.prevNoteIndex + 1; i < allNotes.size(); i++) {
                if (!isAlreadyPlayed(i)) {
                    return false;
                }
            }
            return true;
        } else {
            for (int i = this.prevNoteIndex - 1; i >= 0; i--) {
                if (!isAlreadyPlayed(i)) {
                    return false;
                }
            }
            return true;
        }
    }

    private boolean isAlreadyPlayed(int nextNoteIndex){
        if (indexesInCurrentSequence == null){
            return false;
        }
        for (int i = 0; i < indexesInCurrentSequence.length; i++){
            int prevNoteIndex = indexesInCurrentSequence[i];
            if (nextNoteIndex == prevNoteIndex){
                return true;
            }
        }
        return false;
    }

    private void moveToNextSequenceElement(int[] sequence) {
        this.sequenceElementIndex++;
        if (this.sequenceElementIndex == sequence.length){
            this.sequenceElementIndex = 0; // reset
            this.sequenceIndex++; // move to next sequence
            if (this.sequenceIndex == this.intervalSequences.size()){
                this.sequenceIndex = 0; // reset;
            }
        }
    }
}
