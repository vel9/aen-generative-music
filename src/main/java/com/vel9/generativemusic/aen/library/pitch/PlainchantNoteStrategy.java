package com.vel9.generativemusic.aen.library.pitch;

import com.vel9.generativemusic.aen.core.pitch.*;

import java.util.ArrayList;
import java.util.List;

/**
 * Impl of NoteStrategy which uses Sequences established in Plainchant melodies
 * as a basis for deciding which note to provide next.
 */
public class PlainchantNoteStrategy implements NoteStrategy {

    private ScaleStrategy scaleStrategy;
    private RandomDirectionalJumpSelector randomSelector;

    public PlainchantNoteStrategy(ScaleStrategy scaleStrategy){
        this.scaleStrategy = scaleStrategy;
        Note anchorNote = getAnchoNote(scaleStrategy);
        int maxJump = getMaxJump(scaleStrategy);
        BalancedRandomIntervalSequence balancedRandomIntervalSequence = new BalancedRandomIntervalSequence(getIntervalSequences());

        this.randomSelector = new RandomDirectionalJumpSelector(maxJump, anchorNote, balancedRandomIntervalSequence);
    }

    @Override
    public Note nextNote() {
        List<Note> allNotes = this.scaleStrategy.getScale().getNotes();
        return this.randomSelector.next(allNotes);
    }

    /* sets the default "first note already played" as the one in the middle of the available notes */
    private Note getAnchoNote(ScaleStrategy scaleStrategy) {
        List<Note> allNotes = scaleStrategy.getScale().getNotes();
        // select middle note as the anchor,
        return allNotes.get(allNotes.size()/2);
    }

    /* provides the max distance in pitch (up or down) when selecting the next note */
    private int getMaxJump(ScaleStrategy scaleStrategy) {
        //-1 so we don't include a higher octave version of the starting note
        return scaleStrategy.getScale().scaleSize() - 1;
    }

    /* builds lst of plainchant intervals to be used */
    private static List<IntervalSequence> getIntervalSequences(){
        List<IntervalSequence> intervalSequences = new ArrayList<>();
        // index 0 = start ascent
        // sequences with more up than down movement
        intervalSequences.add(PlainchantIntervalSequence.SCANDICUS_FLEXUS); // +1
        intervalSequences.add(PlainchantIntervalSequence.SCANDICUS_FLEXUS); // +1
        intervalSequences.add(PlainchantIntervalSequence.SCANDICUS_FLEXUS); // +1
        // sequences with equal up and down movements
        intervalSequences.add(PlainchantIntervalSequence.PORRECTUS); // 0
        intervalSequences.add(PlainchantIntervalSequence.TORCULUS); // 0
        // index intervalSequences.size() - 3 to force decent
        // sequencesw with more down than up movement
        intervalSequences.add(PlainchantIntervalSequence.PORRECTUS_FLEXUS); // -1
        intervalSequences.add(PlainchantIntervalSequence.PORRECTUS_FLEXUS); // -1
        intervalSequences.add(PlainchantIntervalSequence.CLIMACUS_RESUPINUS); // -1
        return intervalSequences;
    }

}
