package com.vel9.generativemusic.aen.library;

import com.vel9.generativemusic.aen.core.MelodySource;
import com.vel9.generativemusic.aen.core.dynamics.DynamicsStrategy;
import com.vel9.generativemusic.aen.core.melody.MelodyElement;
import com.vel9.generativemusic.aen.core.melody.MelodySequence;
import com.vel9.generativemusic.aen.core.melody.PitchDevelopmentStrategy;
import com.vel9.generativemusic.aen.core.melody.ThemeProvider;
import com.vel9.generativemusic.aen.core.pitch.Note;
import com.vel9.generativemusic.aen.core.pitch.NoteContainer;
import com.vel9.generativemusic.aen.core.support.Constants;
import com.vel9.generativemusic.aen.core.support.DurationVelocity;
import com.vel9.generativemusic.aen.core.time.RhythmStrategy;
import com.vel9.generativemusic.aen.core.time.RhythmicElement;
import com.vel9.generativemusic.aen.core.time.RhythmicSequence;
import com.vel9.generativemusic.aen.core.time.TempoStrategy;
import com.vel9.generativemusic.aen.core.util.Util;
import com.vel9.generativemusic.aen.library.melody.ScaleContainer;
import com.vel9.generativemusic.aen.library.melody.StartingNoteProviderStrategy;
import com.vel9.generativemusic.aen.library.pitch.PlainchantNoteStrategy;
import com.vel9.generativemusic.aen.library.pitch.RandomDirectionalJumpSelector;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.*;

public class DevelopingMelodySource implements MelodySource {

    private static final Logger LOG = LoggerFactory.getLogger(DevelopingMelodySource.class);

    private static final int MAX_JUMP = 3;

    private ThemeProvider themeProvider;
    private int minNote;
    private int maxNote;

    private PitchDevelopmentStrategy[] pitchDevelopmentStrategies;

    private Queue<NoteContainer> queue = new LinkedList<>();
    private TempoStrategy tempoStrategy;
    private RhythmStrategy rhythmStrategy;
    private List<Note> startingNotes = new ArrayList<>();
    private Map<Note, List<ScaleContainer>> noteToScaleMap;
    private RandomDirectionalJumpSelector randomDirectionalJumpSelector;

    public DevelopingMelodySource(ThemeProvider themeProvider,
                                  PitchDevelopmentStrategy[] pitchDevelopmentStrategies,
                                  TempoStrategy tempoStrategy,
                                  DynamicsStrategy dynamicsStrategy,
                                  List<RhythmicSequence> rhythmicSequences,
                                  int minNote,
                                  int maxNote){
        Util.state(pitchDevelopmentStrategies.length > 0, "Must provide more than one pitchDevelopmentStrategy");
        this.pitchDevelopmentStrategies = pitchDevelopmentStrategies;
        this.tempoStrategy = tempoStrategy;
        this.rhythmStrategy = StrategyFactory.getRhythmStrategy(tempoStrategy, dynamicsStrategy, rhythmicSequences);
        this.minNote = minNote;
        this.maxNote = maxNote;
        this.themeProvider = themeProvider;

        MelodySequence theme = handleStartingNotes(this.themeProvider);
        this.randomDirectionalJumpSelector = new RandomDirectionalJumpSelector(MAX_JUMP,
                getAnchorNote(this.startingNotes),
                PlainchantNoteStrategy.getBalancedRandomIntervalSequence());

        List<NoteContainer> noteContainers = toNoteContainers(theme);
        this.queue.addAll(noteContainers);
    }

    /**
     * Obtains starting note and scale containers at that note, randomly selects one of the
     * PitchDevelopmentStrategies provided, transposes the melody sequence to a new starting note
     * and develops theme
     *
     * @return next NoteContainer
     */
    @Override
    public NoteContainer next(){
        while (this.queue.isEmpty()) {
            MelodySequence selectedTheme = handleStartingNotes(this.themeProvider);
            // get starting note and scale containers
            Note nextStartingNote = this.randomDirectionalJumpSelector.next(this.startingNotes);
            List<ScaleContainer> scaleContainers = this.noteToScaleMap.get(nextStartingNote);
            if (scaleContainers == null){
                LOG.debug("Next note is no longer part of current available notes, clearing next() queue");
                // It's possible for the scaleContainers to be null due to the way next() is implemented
                // it may return a previously stored Note from its index which is no longer a part of the
                // provided list of starting notes, if this happens, clear any queued notes in
                // the selector and begin again
                this.randomDirectionalJumpSelector.clearQueuedNotes();
                continue;
            }

            // get development strategy
            int randomPitchDeveloperIndex = Util.getRandom(0, this.pitchDevelopmentStrategies.length - 1);
            PitchDevelopmentStrategy pitchDevelopmentStrategy = this.pitchDevelopmentStrategies[randomPitchDeveloperIndex];
            LOG.debug("Developing using " + pitchDevelopmentStrategy.getClass().getSimpleName());
            // transpose melody sequence
            int randomScaleIndex = Util.getRandom(0, scaleContainers.size() - 1);
            ScaleContainer scaleContainer = scaleContainers.get(randomScaleIndex);
            MelodySequence transposedMelodySequence = StartingNoteProviderStrategy.buildMelodySequenceAtNote(nextStartingNote, selectedTheme);
            // develop theme
            MelodySequence developedTheme = pitchDevelopmentStrategy.develop(transposedMelodySequence, scaleContainer);
            List<NoteContainer> noteContainers = toNoteContainers(developedTheme);

            this.queue.addAll(noteContainers);
            this.themeProvider.updateTheme(developedTheme);
        }

        return this.queue.poll();
    }

    private Note getAnchorNote(List<Note> notes) {
        // select middle note as the anchor,
        return notes.get(notes.size()/2);
    }

    /**
     * Weaves in information from the rhythm strategy during the development of the theme, honors
     * any silences provided by the rhythm strategy, additionally its possible for a melody element
     * to lack a rhythmic element (especially when adding notes into the melody sequence), in such
     * a case, provides the element a rhythmic element from the rhythm strategy
     *
     * @param melodySequence melody sequence
     * @return list of corresponding NoteContainers
     */
    private List<NoteContainer> toNoteContainers(MelodySequence melodySequence) {
        List<NoteContainer> noteContainers = new ArrayList<>();
        for (MelodyElement melodyElement : melodySequence.getMelodyElements()){
            DurationVelocity durationVelocity = this.rhythmStrategy.next();
            // add in any silences from the rhythm strategy
            while (durationVelocity.isSilence()){
                noteContainers.add(new NoteContainer(new Note(Constants.SILENT_NOTE), durationVelocity));
                durationVelocity = this.rhythmStrategy.next();
            }
            // handle the rhythm and velocity for the melody element
            if (melodyElement.hasRhythmicElement()) {
                // if melody element has its own rhythmic element
                // then derive the duration using it, otherwise tap into the duration+velocity
                // values provided by the rhythm strategy
                RhythmicElement rhythmicElement = melodyElement.getRhythmicElement();
                int duration = rhythmicElement.getDuration(this.tempoStrategy.getBpm());
                durationVelocity = new DurationVelocity(duration, durationVelocity.getVelocity(), false);
            }
            NoteContainer noteContainer = new NoteContainer(melodyElement.getNote(), durationVelocity);
            noteContainers.add(noteContainer);
        }
        return noteContainers;
    }

    private MelodySequence handleStartingNotes(ThemeProvider themeProvider) {
        this.startingNotes.clear();
        MelodySequence selectedTheme = null;
        while (this.startingNotes.size() < 2) {
            selectedTheme = themeProvider.getTheme();
            LOG.debug("Setting up starting notes for theme: " + selectedTheme);
            this.noteToScaleMap = StartingNoteProviderStrategy.getStartingNotesAndCorrespondingScales(selectedTheme,
                    this.minNote,
                    this.maxNote);

            this.startingNotes.clear();
            this.startingNotes.addAll(this.noteToScaleMap.keySet());
            LOG.debug("this.noteToScaleMap: " + this.noteToScaleMap);
        }
        return selectedTheme;
    }

}
