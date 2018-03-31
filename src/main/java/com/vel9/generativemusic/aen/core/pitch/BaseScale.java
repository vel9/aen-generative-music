package com.vel9.generativemusic.aen.core.pitch;

/* provides various "base" scales, only allows for scales that are 12 tones or less */
public enum BaseScale {

    // major: also IONIAN
    MAJOR(NoteType.C, NoteType.D, NoteType.E, NoteType.F, NoteType.G, NoteType.A, NoteType.B),
    // minor: also AEOLIAN
    MINOR(NoteType.C, NoteType.D, NoteType.E_FLAT, NoteType.F, NoteType.G, NoteType.A_FLAT, NoteType.B_FLAT),

    DORIAN(NoteType.C, NoteType.D, NoteType.E_FLAT, NoteType.F, NoteType.G, NoteType.A, NoteType.B_FLAT),
    PHRYGIAN(NoteType.C, NoteType.D_FLAT, NoteType.E_FLAT, NoteType.F, NoteType.G, NoteType.A_FLAT, NoteType.B_FLAT),
    LYDIAN(NoteType.C, NoteType.D, NoteType.E, NoteType.F_SHARP, NoteType.G, NoteType.A, NoteType.B),
    MIXOLYDIAN(NoteType.C, NoteType.D, NoteType.E, NoteType.F, NoteType.G, NoteType.A, NoteType.B_FLAT),
    LOCRIAN(NoteType.C, NoteType.D_FLAT, NoteType.E_FLAT, NoteType.F, NoteType.G_FLAT, NoteType.A_FLAT, NoteType.B_FLAT),

    MODE1(NoteType.C, NoteType.D, NoteType.E, NoteType.F_SHARP, NoteType.G_SHARP, NoteType.A_SHARP),
    MODE2(NoteType.C, NoteType.C_SHARP, NoteType.D_SHARP, NoteType.E, NoteType.F_SHARP, NoteType.G, NoteType.A, NoteType.A_SHARP),
    MODE3(NoteType.C, NoteType.D, NoteType.E_FLAT, NoteType.E, NoteType.F_SHARP, NoteType.G, NoteType.A_FLAT, NoteType.B_FLAT, NoteType.B),
    MODE4(NoteType.C, NoteType.D_FLAT, NoteType.D, NoteType.F, NoteType.F_SHARP, NoteType.G, NoteType.A_FLAT, NoteType.B),
    MODE6(NoteType.C, NoteType.D, NoteType.E, NoteType.F, NoteType.F_SHARP, NoteType.G_SHARP, NoteType.A_SHARP, NoteType.B);

    private NoteType[] noteTypes;

    BaseScale(NoteType... notes){
        this.noteTypes = notes;
    }

    public NoteType[] getBaseNotes(){
        return noteTypes;
    }
}
