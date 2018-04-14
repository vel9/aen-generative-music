package com.vel9.generativemusic.aen.library.pitch;

import com.vel9.generativemusic.aen.core.pitch.Note;
import com.vel9.generativemusic.aen.core.util.Util;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class RandomDirectionalJumpSelector {

    private BalancedRandomIntervalSequence balancedRandomIntervalSequence;
    private int prevNoteIndex;
    private Note prevNote;
    private int maxJump;

    private Queue<Note> queue = new LinkedList<>();

    public RandomDirectionalJumpSelector(int maxJump, Note anchorNote, BalancedRandomIntervalSequence balancedRandomIntervalSequence){
        this.maxJump = maxJump;
        this.prevNote = anchorNote;
        this.balancedRandomIntervalSequence = balancedRandomIntervalSequence;
    }

    /**
     * Returns next note from the provided list of notes
     * Uses the "previous" note as an anchor for selecting the next note
     *
     * Note that the algorithm does not select from the provided list of notes
     * until the queue is empty. This was done so that each "sequence" is completed
     * within the scale provided at the start of the sequence. There's no "technical"
     * reason for this, other than it's a simpler implementation and the resulting melodies
     * seem to sound better to my ears.
     *
     * @param notes list of Notes
     * @return next Note
     */
    public Note next(List<Note> notes) {
        Util.state(notes != null && notes.size() > 1, "must provide a list of notes with a size greater than 1");
        Map<Note,Integer> notesByIndex = getNotesAsMap(notes);
        setupPrevNoteAndPrevIndex(notes);
        while (this.queue.isEmpty()){
            Set<Note> used = new HashSet<>();
            for (int jumpDirection : this.balancedRandomIntervalSequence.getIntervalSequence()){
                Note note = getNextNote(notes, used, jumpDirection, this.prevNoteIndex, this.maxJump);
                if (note != null){
                    used.add(note);
                    this.queue.offer(note);
                    this.prevNoteIndex = notesByIndex.get(note);
                    this.prevNote = note;
                }
            }
        }
        return this.queue.poll();
    }

    /**
     * Finds the closest note to the previous note in provided list and sets as previous note,
     * Useful for the case where previously played note is no longer in the new list of notes
     * this can happen in the case of scale changes
     *
     * @param notes list of Notes
     */
    private void setupPrevNoteAndPrevIndex(List<Note> notes) {
        Util.state(this.prevNote != null, "prevNote can't be null");
        for (int i = 1; i < notes.size(); i++) {
            if (notes.get(i).getValue() > this.prevNote.getValue()){
                this.prevNote = notes.get(i - 1);
                this.prevNoteIndex = i - 1;
                return;
            }
        }
        int lastIndex = notes.size() - 1;
        this.prevNoteIndex = lastIndex;
        this.prevNote = notes.get(lastIndex);
    }

    /* Returns a note in the provided jumpDirection */
    Note getNextNote(List<Note> notes, Set<Note> used, int jumpDirection, int prevNoteIndex, int maxJump) {
        if (jumpDirection == 1){
            return getUpwardItem(notes, used, prevNoteIndex, maxJump);
        } else if (jumpDirection == -1){
            return getDownwardItem(notes, used, prevNoteIndex, maxJump);
        } else {
            throw new IllegalStateException("jump direction can only be 1 or -1");
        }
    }

    /* Returns a random note in the "down" direction */
    private Note getDownwardItem(List<Note> notes, Set<Note> used, int prevNoteIndex, int maxJump) {
        int start = Math.max(0, prevNoteIndex - maxJump);
        int end = prevNoteIndex - 1;
        List<Note> possibleSelection = getPossibleSelections(notes, used, start, end);
        if (possibleSelection.isEmpty()){
            return null;
        } else {
            int localIndex = Util.getRandom(0, possibleSelection.size() - 1);
            return possibleSelection.get(localIndex);
        }
    }

    /* Returns a random note in the "up" direction */
    private Note getUpwardItem(List<Note> notes, Set<Note> used, int prevNoteIndex, int maxJump) {
        int start = prevNoteIndex + 1;
        int end = Math.min(prevNoteIndex + maxJump, notes.size() - 1);
        List<Note> possibleSelections = getPossibleSelections(notes, used, start, end);
        if (possibleSelections.isEmpty()){
            return null;
        } else {
            int localIndex = Util.getRandom(0, possibleSelections.size() - 1);
            return possibleSelections.get(localIndex);
        }
    }

    /* Returns Notes which are not a member of the used set over a given range */
    private List<Note> getPossibleSelections(List<Note> notes, Set<Note> used, int start, int end) {
        List<Note> possibleSelection = new ArrayList<>();
        for (int i = start; i <= end; i++){
            Note note = notes.get(i);
            if (!used.contains(note)){
                possibleSelection.add(note);
            }
        }
        return possibleSelection;
    }

    private Map<Note, Integer> getNotesAsMap(List<Note> notes) {
        return IntStream.range(0, notes.size()).boxed().collect(Collectors.toMap(notes::get, i -> i));
    }

    public void clearQueuedNotes(){
        if (!this.queue.isEmpty()){
            this.queue.clear();
        }
    }

}
