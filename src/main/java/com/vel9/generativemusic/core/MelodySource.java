package com.vel9.generativemusic.core;

import com.vel9.generativemusic.core.pitch.NoteContainer;

/**
 * Created by levani on 12/6/16.
 */
public interface MelodySource {
    NoteContainer next();
}
