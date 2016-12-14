package com.vel9.generativemusic.library.pitch;

import com.vel9.generativemusic.core.pitch.*;
import com.vel9.generativemusic.core.util.Util;
import org.junit.Test;

/**
 * Created by levani on 12/13/16.
 */
public class TestPlainchantNoteStrategy {

    @Test
    public void plainchantNoteStrategy_nextNote_valid(){

        ScaleStrategy scaleStrategy = new ChangeScaleStrategy(Util.getSeconds(2),
                new Scale(BaseScale.MAJOR, NoteType.C, 32, 108),
                new Scale(BaseScale.MODE3, NoteType.C, 32, 108)
        );
        NoteStrategy noteStrategy = new PlainchantNoteStrategy(scaleStrategy);

        for (int i = 0; i < 1000000; i++){
            noteStrategy.nextNote();
        }

    }
}
