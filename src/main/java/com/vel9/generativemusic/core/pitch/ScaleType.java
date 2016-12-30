package com.vel9.generativemusic.core.pitch;

/**
 * TRANSPOSING scale type refers to a scale such a C Major, which
 * provides the same note types (C, D, E etc) for each octave. We describe such
 * a scale as variable, because a different C Major scale exists for each octave.
 *
 * A NONTRANSPOSING scale can be used for limiting the available notes, like a drum kit.
 * A drum kit only has a limited number of "notes" one for each cymbal and bass drum.
 * These "notes" can't be transposed.
 */
public enum ScaleType {
    NONTRANSPOSING,
    TRANSPOSING
}
