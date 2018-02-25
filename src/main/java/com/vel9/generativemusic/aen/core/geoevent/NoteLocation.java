package com.vel9.generativemusic.aen.core.geoevent;

/**
 * Simple container representing a note's location
 * as expressed by a combination of its pan and velocity values
 */
public class NoteLocation {
    private int panAmount;
    private int velocityAmount;

    public NoteLocation(int panAmount, int velocityAmount) {
        this.panAmount = panAmount;
        this.velocityAmount = velocityAmount;
    }

    public int getPanAmount() {
        return panAmount;
    }

    public int getVelocityAmount() {
        return velocityAmount;
    }


    @Override
    public String toString(){
        StringBuilder sb = new StringBuilder();
        sb.append("panAmount: ").append(panAmount).append(System.lineSeparator());
        sb.append("velocityAmount: ").append(velocityAmount).append(System.lineSeparator());
        return sb.toString();
    }
}
