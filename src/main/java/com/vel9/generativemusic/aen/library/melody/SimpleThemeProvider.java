package com.vel9.generativemusic.aen.library.melody;

import com.vel9.generativemusic.aen.core.melody.MelodySequence;
import com.vel9.generativemusic.aen.core.melody.ThemeProvider;
import com.vel9.generativemusic.aen.core.util.Util;
import org.apache.commons.lang3.Validate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Theme provider implementation which continually develops the theme while also
 * maintaining the original theme unchanged, it returns the original theme a
 * percentage of the time -- lower percentages would result in more adventurous thematic
 * development over time
 */
public class SimpleThemeProvider implements ThemeProvider {

    private static final Logger LOG = LoggerFactory.getLogger(SimpleThemeProvider.class);

    private MelodySequence[] themes = new MelodySequence[2];
    private int themeSelectionPercentage;

    public SimpleThemeProvider(MelodySequence theme, int themeSelectionPercentage){
        Validate.validState(themeSelectionPercentage > 0 && themeSelectionPercentage < 100,
                "theme selection percentage must be between 1 to 99");
        Validate.validState(theme != null, "theme must not be null");
        this.themes[0] = theme;
        this.themes[1] = theme;
        this.themeSelectionPercentage = themeSelectionPercentage;
    }

    @Override
    public MelodySequence getTheme() {
        int randomPercentage = Util.getRandom(0, 100);
        if (randomPercentage <= this.themeSelectionPercentage){
            LOG.debug("Providing original theme, randomPercentage: " + randomPercentage);
            return this.themes[0];
        } else {
            LOG.debug("Providing developed theme, randomPercentage: " + randomPercentage);
            return this.themes[1];
        }
    }

    @Override
    public void updateTheme(MelodySequence theme) {
        // 0 position maintains the original theme but we keep updating the theme at position 2
        // alternative implementation could store all variations of different themes?
        this.themes[1]  = theme;
    }
}
