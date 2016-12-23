package com.vel9.generativemusic.core.pitch;

//Ref: used for algo: http://www.electronics.dit.ie/staff/tscarff/Music_technology/midi/midi_note_numbers_for_octaves.htm
public enum NoteType {
    C(0),
    C_SHARP(1),
    D_FLAT(1),
    D(2),
    D_SHARP(3),
    E_FLAT(3),
    E(4),
    F_FLAT(4),
    F(5),
    F_SHARP(6),
    G_FLAT(6),
    G(7),
    G_SHARP(8),
    A_FLAT(8),
    A(9),
    A_SHARP(10),
    B_FLAT(10),
    B(11);

    private final int value;
    NoteType(int value){
        this.value = value;
    }
    public int getValue(){
        return this.value;
    }

}
