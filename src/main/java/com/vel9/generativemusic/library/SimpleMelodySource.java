package com.vel9.generativemusic.library;

import com.vel9.generativemusic.core.MelodySource;
import com.vel9.generativemusic.core.pitch.Note;
import com.vel9.generativemusic.core.pitch.NoteContainer;
import com.vel9.generativemusic.core.pitch.NoteStrategy;
import com.vel9.generativemusic.core.support.Constants;
import com.vel9.generativemusic.core.support.DurationVelocity;
import com.vel9.generativemusic.core.time.RhythmStrategy;

/**
 * Created by levani on 12/12/16.
 */
public class SimpleMelodySource implements MelodySource {

    private static final String TAG = SimpleMelodySource.class.getSimpleName();

    private RhythmStrategy rhythmStrategy;
    private NoteStrategy noteStrategy;

    public SimpleMelodySource(NoteStrategy noteStrategy, RhythmStrategy rhythmStrategy){
        this.noteStrategy = noteStrategy;
        this.rhythmStrategy = rhythmStrategy;
    }

    @Override
    public NoteContainer next(){
        DurationVelocity durationVelocity = this.rhythmStrategy.next();
        if (durationVelocity.isSilence()){
            return new NoteContainer(new Note(Constants.SILENT_NOTE), this.rhythmStrategy.next());
        } else {
            // only grab next note if duration is not a silence..
            return new NoteContainer(this.noteStrategy.nextNote(), this.rhythmStrategy.next());
        }
    }

}
