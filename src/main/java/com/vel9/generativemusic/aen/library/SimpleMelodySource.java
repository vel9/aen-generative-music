package com.vel9.generativemusic.aen.library;

import com.vel9.generativemusic.aen.core.MelodySource;
import com.vel9.generativemusic.aen.core.pitch.Note;
import com.vel9.generativemusic.aen.core.pitch.NoteContainer;
import com.vel9.generativemusic.aen.core.pitch.NoteStrategy;
import com.vel9.generativemusic.aen.core.support.Constants;
import com.vel9.generativemusic.aen.core.support.DurationVelocity;
import com.vel9.generativemusic.aen.core.time.RhythmStrategy;

/**
 * Impl of MelodySource which returns the "next" from both NoteStrategy and RhythmStrategy
 */
public class SimpleMelodySource implements MelodySource {

    private static final String TAG = SimpleMelodySource.class.getSimpleName();

    private RhythmStrategy rhythmStrategy;
    private NoteStrategy noteStrategy;

    public SimpleMelodySource(NoteStrategy noteStrategy, RhythmStrategy rhythmStrategy){
        this.noteStrategy = noteStrategy;
        this.rhythmStrategy = rhythmStrategy;
    }

    /* Honors the DurationVelocity.isSilence indicator by providing a silent Note if true */
    @Override
    public NoteContainer next(){
        DurationVelocity durationVelocity = this.rhythmStrategy.next();
        if (durationVelocity.isSilence()){
            return new NoteContainer(new Note(Constants.SILENT_NOTE), durationVelocity);
        } else {
            // only grab next note if time is not a silence..
            return new NoteContainer(this.noteStrategy.nextNote(), durationVelocity);
        }
    }

}
