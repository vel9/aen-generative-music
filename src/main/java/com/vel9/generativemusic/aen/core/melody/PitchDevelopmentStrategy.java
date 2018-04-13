package com.vel9.generativemusic.aen.core.melody;

import com.vel9.generativemusic.aen.library.melody.ScaleContainer;

public interface PitchDevelopmentStrategy {
    /**
     * Takes in a melody sequence and returns a "developed" melody sequence
     *
     * Implementations could invert, mirror, remove notes, add notes the input melody sequence
     *
     * @param melodySequence melody sequence to be developed
     * @param scaleContainer scale information with which to develop the theme
     * @return developed theme
     */
    MelodySequence develop(MelodySequence melodySequence, ScaleContainer scaleContainer);
}
