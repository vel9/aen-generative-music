package com.vel9.generativemusic.aen.core.dynamics;

/**
 * Created by levani on 12/5/16.
 */
public enum Dynamic {
    PPPP(10),
    PPP(20),
    PP(30),
    P(40),
    MP(50),
    MF(60),
    F(70),
    FF(87),
    FFF(105),
    FFFF(127);

    private int value;

    Dynamic(int value){
        this.value = value;
    }

    public int getValue(){
        return this.value;
    }
}
