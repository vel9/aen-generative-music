package com.vel9.generativemusic.aen.core.time;

import org.junit.Assert;
import org.junit.Test;

public class TestRhythmicElement {

    // see: https://msu.edu/course/asc/232/song_project/dectalk_pages/note_to_%20ms.html

    /** TEST FOR BPM 60 **/
    @Test
    public void getDuration_60bpm_returnsQurterNoteDuration(){
        int duration = RhythmicElement.QUARTER.getDuration(60);
        Assert.assertTrue("Expected time value of 1 sec", duration == 1000);
    }

    @Test
    public void getDuration_60bpm_returnsQurterTripletNoteDuration(){
        int duration = RhythmicElement.QUARTER_T.getDuration(60);
        Assert.assertTrue("Expected time value of 666 millis", duration == 666);
    }

    @Test
    public void getDuration_60bpm_returnsDottedQurterNoteDuration(){
        int duration = RhythmicElement.DOTTED_QUARTER.getDuration(60);
        Assert.assertTrue("Expected time value of 1.5 sec", duration == 1500);
    }

    @Test
    public void getDuration_60bpm_returnsWholeNoteDuration(){
        int duration = RhythmicElement.WHOLE.getDuration(60);
        Assert.assertTrue("Expected time value of 4 sec", duration == 4000);
    }

    @Test
    public void getDuration_60bpm_returnsDottedHalfDuration(){
        int duration = RhythmicElement.DOTTED_HALF.getDuration(60);
        Assert.assertTrue("Expected time value of 3 sec", duration == 3000);
    }

    @Test
    public void getDuration_60bpm_returnsHalfDuration(){
        int duration = RhythmicElement.HALF.getDuration(60);
        Assert.assertTrue("Expected time value of 2000 millis", duration == 2000);
    }

    @Test
    public void getDuration_60bpm_returnsTripletHalfDuration(){
        int duration = RhythmicElement.HALF_T.getDuration(60);
        Assert.assertTrue("Expected time value of 1333 millis", duration == 1333);
    }

    @Test
    public void getDuration_60bpm_returnsEighthNoteDuration(){
        int duration = RhythmicElement.EIGHTH.getDuration(60);
        Assert.assertTrue("Expected time value of half a sec", duration == 500);
    }

    @Test
    public void getDuration_60bpm_returnsTripletEighthNoteDuration(){
        int duration = RhythmicElement.EIGHTH_T.getDuration(60);
        Assert.assertTrue("Expected time value of 333 millis", duration == 333);
    }

    @Test
    public void getDuration_60bpm_returnsSixteenthNoteDuration(){
        int duration = RhythmicElement.SIXTEENTH.getDuration(60);
        Assert.assertTrue("Expected time value of 250 millis", duration == 250);
    }

    @Test
    public void getDuration_60bpm_returnsTripletSixteenthNoteDuration(){
        int duration = RhythmicElement.SIXTEENTH_T.getDuration(60);
        Assert.assertTrue("Expected time value of 166 millis", duration == 166);
    }

    @Test
    public void getDuration_60bpm_returnsThirtySecondNoteDuration(){
        int duration = RhythmicElement.THIRYSECOND.getDuration(60);
        Assert.assertTrue("Expected time value of 125 millis", duration == 125);
    }

    @Test
    public void getDuration_60bpm_returnsTripletThirtySecondNoteDuration(){
        int duration = RhythmicElement.THIRTYSECOND_T.getDuration(60);
        Assert.assertTrue("Expected time value of 83 millis", duration == 83);
    }

    @Test
    public void getDuration_60bpm_returnsSixtyFourthNoteDuration(){
        int duration = RhythmicElement.SIXTYFOURTH.getDuration(60);
        Assert.assertTrue("Expected time value of 62 millis", duration == 62);
    }

    @Test
    public void getDuration_60bpm_returnsTripletSixtyFourthNoteDuration(){
        int duration = RhythmicElement.SIXTYFOURTH_T.getDuration(60);
        Assert.assertTrue("Expected time value of 41 millis", duration == 41);
    }

    /** TEST FOR BPM 200 **/
    @Test
    public void getDuration_200bpm_returnsQurterNoteDuration(){
        int duration = RhythmicElement.QUARTER.getDuration(200);
        Assert.assertTrue("Expected time value of 300 millis", duration == 300);
    }

    @Test
    public void getDuration_200bpm_returnsQurterTripletNoteDuration(){
        int duration = RhythmicElement.QUARTER_T.getDuration(200);
        Assert.assertTrue("Expected time value of 200 millis", duration == 200);
    }

    @Test
    public void getDuration_200bpm_returnsDottedQurterNoteDuration(){
        int duration = RhythmicElement.DOTTED_QUARTER.getDuration(200);
        Assert.assertTrue("Expected time value of 450 millis", duration == 450);
    }

    @Test
    public void getDuration_200bpm_returnsWholeNoteDuration(){
        int duration = RhythmicElement.WHOLE.getDuration(200);
        Assert.assertTrue("Expected time value of 1200 millis", duration == 1200);
    }

    @Test
    public void getDuration_200bpm_returnsDottedHalfDuration(){
        int duration = RhythmicElement.DOTTED_HALF.getDuration(200);
        Assert.assertTrue("Expected time value of 900 millis", duration == 900);
    }

    @Test
    public void getDuration_200bpm_returnsHalfDuration(){
        int duration = RhythmicElement.HALF.getDuration(200);
        Assert.assertTrue("Expected time value of 600 millis", duration == 600);
    }

    @Test
    public void getDuration_200bpm_returnsTripletHalfDuration(){
        int duration = RhythmicElement.HALF_T.getDuration(200);
        Assert.assertTrue("Expected time value of 400 millis", duration == 400);
    }

    @Test
    public void getDuration_200bpm_returnsEighthNoteDuration(){
        int duration = RhythmicElement.EIGHTH.getDuration(200);
        Assert.assertTrue("Expected time value of 150 millis", duration == 150);
    }

    @Test
    public void getDuration_200bpm_returnsTripletEighthNoteDuration(){
        int duration = RhythmicElement.EIGHTH_T.getDuration(200);
        Assert.assertTrue("Expected time value of 333 millis", duration == 100);
    }

    @Test
    public void getDuration_200bpm_returnsSixteenthNoteDuration(){
        int duration = RhythmicElement.SIXTEENTH.getDuration(200);
        Assert.assertTrue("Expected time value of 75 millis", duration == 75);
    }

    @Test
    public void getDuration_200bpm_returnsTripletSixteenthNoteDuration(){
        int duration = RhythmicElement.SIXTEENTH_T.getDuration(200);
        Assert.assertTrue("Expected time value of 50 millis", duration == 50);
    }

    @Test
    public void getDuration_200bpm_returnsThirtySecondNoteDuration(){
        int duration = RhythmicElement.THIRYSECOND.getDuration(200);
        Assert.assertTrue("Expected time value of 37 millis", duration == 37);
    }

    @Test
    public void getDuration_200bpm_returnsTripletThirtySecondNoteDuration(){
        int duration = RhythmicElement.THIRTYSECOND_T.getDuration(200);
        Assert.assertTrue("Expected time value of 25 millis", duration == 25);
    }

    @Test
    public void getDuration_200bpm_returnsSixtyFourthNoteDuration(){
        int duration = RhythmicElement.SIXTYFOURTH.getDuration(200);
        Assert.assertTrue("Expected time value of 18 millis", duration == 18);
    }

    @Test
    public void getDuration_200bpm_returnsTripletSixtyFourthNoteDuration(){
        int duration = RhythmicElement.SIXTYFOURTH_T.getDuration(200);
        Assert.assertTrue("Expected time value of 12 millis", duration == 12);
    }

}
