package com.vel9.generativemusic.aen.core.melody;

/**
 * Implementations of the ThemeProvider can be instrumental in thematic development,
 *
 * It can contain the important logic of how a theme is developed over time
 *
 * The updateTheme function is intented to be called once a theme is developed
 * Implementations could "overwrite" the original theme, always further and further
 * developing the original theme, or they could hold onto the original theme, returning
 * it via the getTheme a certain percentage of the time
 */
public interface ThemeProvider {
    /* provide a developed theme */
    MelodySequence getTheme();
    /* update theme with a provided melody sequence */
    void updateTheme(MelodySequence theme);
}
