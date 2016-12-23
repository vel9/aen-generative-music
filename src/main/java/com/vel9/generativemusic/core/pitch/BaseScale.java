package com.vel9.generativemusic.core.pitch;

/* provides various "base" scales, only allows for scales that are 12 tones or less */
public enum BaseScale {

    MAJOR(NoteType.C, NoteType.D, NoteType.E, NoteType.F, NoteType.G, NoteType.A, NoteType.B),
    MINOR(NoteType.C, NoteType.D, NoteType.E_FLAT, NoteType.F, NoteType.G, NoteType.A_FLAT, NoteType.B_FLAT),

    MODE2(NoteType.C, NoteType.C_SHARP, NoteType.D_SHARP, NoteType.E, NoteType.F_SHARP, NoteType.G, NoteType.A, NoteType.A_SHARP),
    MODE3(NoteType.C, NoteType.D, NoteType.E_FLAT, NoteType.E, NoteType.F_SHARP, NoteType.G, NoteType.A_FLAT, NoteType.B_FLAT, NoteType.B),
    MODE6(NoteType.C, NoteType.D, NoteType.E, NoteType.F, NoteType.F_SHARP, NoteType.G_SHARP, NoteType.A_SHARP, NoteType.B);

    private NoteType[] noteTypes;

    BaseScale(NoteType... notes){
        this.noteTypes = notes;
    }

    public NoteType[] getBaseNotes(){
        return noteTypes;
    }
}
