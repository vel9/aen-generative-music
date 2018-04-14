package com.vel9.generativemusic.aen.library.melody;

import com.vel9.generativemusic.aen.core.melody.MelodyElement;
import com.vel9.generativemusic.aen.core.melody.MelodySequence;
import com.vel9.generativemusic.aen.core.pitch.BaseScale;
import com.vel9.generativemusic.aen.core.pitch.Note;
import com.vel9.generativemusic.aen.core.pitch.NoteType;
import com.vel9.generativemusic.aen.core.pitch.Scale;

import java.util.*;
import java.util.stream.Collectors;

public class StartingNoteProviderStrategy {

    /**
     * Uses the relative interval sequence of a melody sequence to determine which Scales can "host"
     * the provided melody sequence. Builds a list of all possible starting notes for the melody sequence
     * and all the "host" scales at that note.
     *
     * @param melodySequence melody sequence
     * @param minNote min desired note
     * @param maxNote max desired note
     * @return map of possible starting notes and corresponding scales
     */
    public static Map<Note, List<ScaleContainer>> getStartingNotesAndCorrespondingScales(MelodySequence melodySequence, int minNote, int maxNote) {
        Map<Note, List<ScaleContainer>> scalesByStartingNote = new HashMap<>();
        // 1. find relative interval sequence
        int[] relativeIntervalDiff = melodySequence.getRelativeIntervalSequence();
        for (BaseScale baseScale : BaseScale.values()) {
            for (NoteType noteType : NoteType.uniqueValues()) {
                Scale scale = Scale.createTransposingScale(baseScale, noteType, minNote, maxNote);
                List<Note> notes = scale.getNotes();
                // 2. find all starting notes
                List<Note> possibleStartingNotes = getPossibleStartingNotes(notes, relativeIntervalDiff, minNote, maxNote);
                if (!possibleStartingNotes.isEmpty()){
                    for (Note startingNote : possibleStartingNotes){
                        List<ScaleContainer> list = scalesByStartingNote.get(startingNote);
                        if (list == null){
                            list = new ArrayList<>();
                        }
                        list.add(new ScaleContainer(baseScale, noteType, notes));
                        scalesByStartingNote.put(startingNote, list);
                    }
                }
            }
        }
        return scalesByStartingNote;
    }

    static List<Note> getPossibleStartingNotes(List<Note> notes, int[] relativeIntervalDiffs, int minNote, int maxNote) {
        Set<Integer> noteSet = notes.stream().map(Note::getValue).collect(Collectors.toSet());
        List<Note> startingNotes = new ArrayList<>();
        // 0 is min note, 127 is max note
        for (int i = minNote; i <= maxNote; i++){
            // i is the starting note of search space
            boolean containsSequence = true;
            int currentNote = i;
            for (int relativeDiff : relativeIntervalDiffs) {
                currentNote += relativeDiff;
                if (!noteSet.contains(currentNote)) {
                    containsSequence = false;
                    break;
                }
            }
            if (containsSequence){
                startingNotes.add(Note.create(i));
            }
        }
        return startingNotes;
    }

    /* Uses the relative interval sequence of the provided melody sequence to transpose it to the provded starting note */
    public static MelodySequence buildMelodySequenceAtNote(Note startingNote, MelodySequence melodySequence){
        List<MelodyElement> elements = melodySequence.getMelodyElements();
        int[] relativeIntervalSequence = melodySequence.getRelativeIntervalSequence();
        List<MelodyElement> transposed = new ArrayList<>();
        int lastValue = startingNote.getValue();
        transposed.add(new MelodyElement(startingNote, elements.get(0).getRhythmicElement()));
        for (int i = 1; i < elements.size(); i++){
            int transposedValue = lastValue + relativeIntervalSequence[i];
            transposed.add(new MelodyElement(Note.create(transposedValue), elements.get(i).getRhythmicElement()));
            lastValue = transposedValue;
        }
        return new MelodySequence(transposed);
    }
}
