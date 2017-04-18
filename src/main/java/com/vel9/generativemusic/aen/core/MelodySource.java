package com.vel9.generativemusic.aen.core;

import com.vel9.generativemusic.aen.core.pitch.NoteContainer;

/**
 * A type of facade into the underlying architecture which contains
 * ScaleStrategy, NoteStrategy, RhythmStrategy, TempoStrategy
 *
 * The outputs of those algorithms should be packaged into the NoteContainer.
 *
 * This is the interface with which the Instrument provides data for
 * the Performer to build and send a MIDI message.
 */
public interface MelodySource {
    NoteContainer next();
}
