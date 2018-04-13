package com.vel9.generativemusic.aen.core.time;

import java.util.Arrays;

import static com.vel9.generativemusic.aen.core.support.Constants.MINUTE_IN_MILLIS;

/**
 * Provides representation of a rhythm's building block. Including public constants of the
 * more common rhythms for easy access. More complex rhythmic elements that can be subdivided
 * into multiple RhythmicElements can also be built.
 */
public class RhythmicElement {

    private static final String TAG = RhythmicElement.class.getSimpleName();

    public static final RhythmicElement WHOLE = new RhythmicElement(RhythmicElementType.WHOLE);
    public static final RhythmicElement HALF = new RhythmicElement(RhythmicElementType.HALF);
    public static final RhythmicElement DOTTED_HALF = new RhythmicElement(RhythmicElementType.HALF, RhythmicElementType.QUARTER);
    public static final RhythmicElement HALF_T = new RhythmicElement(RhythmicElementType.HALF_T);
    public static final RhythmicElement QUARTER = new RhythmicElement(RhythmicElementType.QUARTER);
    public static final RhythmicElement QUARTER_T = new RhythmicElement(RhythmicElementType.QUARTER_T);
    public static final RhythmicElement DOTTED_QUARTER = new RhythmicElement(RhythmicElementType.QUARTER, RhythmicElementType.EIGHTH);
    public static final RhythmicElement EIGHTH = new RhythmicElement(RhythmicElementType.EIGHTH);
    public static final RhythmicElement DOTTED_EIGHTH = new RhythmicElement(RhythmicElementType.EIGHTH, RhythmicElementType.SIXTEENTH);
    public static final RhythmicElement EIGHTH_T = new RhythmicElement(RhythmicElementType.EIGHTH_T);
    public static final RhythmicElement SIXTEENTH = new RhythmicElement(RhythmicElementType.SIXTEENTH);
    public static final RhythmicElement DOTTED_SIXTEENTH = new RhythmicElement(RhythmicElementType.SIXTEENTH, RhythmicElementType.THIRYSECOND);
    public static final RhythmicElement SIXTEENTH_T = new RhythmicElement(RhythmicElementType.SIXTEENTH_T);
    public static final RhythmicElement THIRYSECOND = new RhythmicElement(RhythmicElementType.THIRYSECOND);
    public static final RhythmicElement THIRTYSECOND_T = new RhythmicElement(RhythmicElementType.THIRTYSECOND_T);
    public static final RhythmicElement SIXTYFOURTH = new RhythmicElement(RhythmicElementType.SIXTYFOURTH);
    public static final RhythmicElement SIXTYFOURTH_T = new RhythmicElement(RhythmicElementType.SIXTYFOURTH_T);

    private RhythmicElementType[] rhythmicElementTypes;

    /**
     * If more than nocturne RhythmicElementType is provided, a "tie-ing" effect will be achieved.
     *
     * For example, if a QUARTER and EIGHTH are provided, the RhythmicElement will represent
     * a dotted quarter (quarter + eighth).
     *
     * @param rhythmicElementTypes rhythmic element types which make up the rhythmic element
     */
    public RhythmicElement(RhythmicElementType... rhythmicElementTypes){
        this.rhythmicElementTypes = rhythmicElementTypes;
    }

    /** helper method for determining the whole note value given tempo in beats per minute */
    private static int getWholeNoteValueInMillis(int tempoBmp){
        return MINUTE_IN_MILLIS/(tempoBmp/4);
    }

    /* algorithm for providing the time, in milliseconds, of RhythmicElement given current tempo */
    public int getDuration(int tempoBpm){
        final int wholeNoteValInMillis = getWholeNoteValueInMillis(tempoBpm);
        int duration = 0;
        for (RhythmicElementType rhythmicElementType : this.rhythmicElementTypes){
            duration += getDuration(rhythmicElementType, wholeNoteValInMillis);
        }
        return duration;
    }

    /**
     * Helper method for determining value of RhythmicElementType given wholeNoteValInMillis value
     *
     * Note that the implementation always rounds down due to integer division
     *
     */
    private int getDuration(final RhythmicElementType rhythmicElementType, final int wholeNoteValInMillis){
        final int halfNoteTriplet = wholeNoteValInMillis/3;
        switch(rhythmicElementType){
            case WHOLE:
                return wholeNoteValInMillis;
            case HALF:
                return wholeNoteValInMillis/2;
            case HALF_T:
                return halfNoteTriplet;
            case QUARTER:
                return wholeNoteValInMillis/4;
            case QUARTER_T:
                return halfNoteTriplet/2;
            case EIGHTH:
                return wholeNoteValInMillis/8;
            case EIGHTH_T:
                return halfNoteTriplet/4;
            case SIXTEENTH:
                return wholeNoteValInMillis/16;
            case SIXTEENTH_T:
                return halfNoteTriplet/8;
            case THIRYSECOND:
                return wholeNoteValInMillis/32;
            case THIRTYSECOND_T:
                return halfNoteTriplet/16;
            case SIXTYFOURTH:
                return wholeNoteValInMillis/64;
            case SIXTYFOURTH_T:
                return halfNoteTriplet/32;
        }
        return 1;
    }

    @Override
    public String toString(){
        return Arrays.toString((this.rhythmicElementTypes));
    }

}
