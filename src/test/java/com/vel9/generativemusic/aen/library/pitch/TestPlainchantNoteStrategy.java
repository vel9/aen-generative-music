package com.vel9.generativemusic.aen.library.pitch;

import com.vel9.generativemusic.aen.core.pitch.*;
import org.junit.Test;

/**
 * Created by levani on 12/13/16.
 */
public class TestPlainchantNoteStrategy {

    @Test
    public void plainchantNoteStrategy_nextNote_valid(){
        int minNote = 48;
        int maxNote = 96;
        int rateOfChange = 50;
        ScaleStrategy scaleStrategy = new ChangeScaleStrategy(rateOfChange,
                new Scale(BaseScale.MODE3, NoteType.C, minNote, maxNote),
                new Scale(BaseScale.MODE3, NoteType.C_SHARP, minNote, maxNote),
                new Scale(BaseScale.MODE3, NoteType.D, minNote, maxNote),
                new Scale(BaseScale.MODE6, NoteType.E_FLAT, minNote, maxNote),
                new Scale(BaseScale.MODE2, NoteType.C, minNote, maxNote),
                new Scale(BaseScale.MODE2, NoteType.C_SHARP, minNote, maxNote),
                new Scale(BaseScale.MINOR, NoteType.A, minNote, maxNote),
                new Scale(BaseScale.MINOR, NoteType.E, minNote, maxNote),
                new Scale(BaseScale.MINOR, NoteType.B, minNote, maxNote),
                new Scale(BaseScale.MINOR, NoteType.F_SHARP, minNote, maxNote),
                new Scale(BaseScale.MINOR, NoteType.C_SHARP, minNote, maxNote),
                new Scale(BaseScale.MINOR, NoteType.G_SHARP, minNote, maxNote),
                new Scale(BaseScale.MINOR, NoteType.D_SHARP, minNote, maxNote),
                new Scale(BaseScale.MINOR, NoteType.A_SHARP, minNote, maxNote),
                new Scale(BaseScale.MINOR, NoteType.F, minNote, maxNote),
                new Scale(BaseScale.MINOR, NoteType.C, minNote, maxNote),
                new Scale(BaseScale.MINOR, NoteType.G, minNote, maxNote),
                new Scale(BaseScale.MINOR, NoteType.D, minNote, maxNote)
        );

        NoteStrategy noteStrategy = new PlainchantNoteStrategy(scaleStrategy);
        for (int i = 0; i < 100000000; i++){
            noteStrategy.nextNote();
        }

    }
}
