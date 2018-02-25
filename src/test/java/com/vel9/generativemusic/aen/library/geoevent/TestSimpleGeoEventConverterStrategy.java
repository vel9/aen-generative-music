package com.vel9.generativemusic.aen.library.geoevent;

import com.vel9.generativemusic.aen.core.geoevent.BoundingBox;
import com.vel9.generativemusic.aen.core.geoevent.GeoEvent;
import com.vel9.generativemusic.aen.core.geoevent.Location;
import org.junit.Assert;
import org.junit.Test;

public class TestSimpleGeoEventConverterStrategy {

    private SimpleGeoEventConverterStrategy strategy = new SimpleGeoEventConverterStrategy();
    private BoundingBox boundingBox = BoundingBox.createBoundingBox(0., 100., 0., 100.);

    @Test
    public void getPanAmount_centerEvent_centerPan(){
        GeoEvent geoEvent = getGeoEvent(50., 50.);
        int panAmount = this.strategy.getPanAmount(this.boundingBox, geoEvent);
        Assert.assertTrue("Expected center pan amount", panAmount == 50);
    }

    @Test
    public void getPanAmount_farRightEvent_farRightPan(){
        GeoEvent geoEvent = getGeoEvent(100., 50.);
        int panAmount = this.strategy.getPanAmount(this.boundingBox, geoEvent);
        Assert.assertTrue("Expected far right pan amount", panAmount == 100);
    }

    @Test
    public void getPanAmount_farLeftEvent_farLeftPan(){
        GeoEvent geoEvent = getGeoEvent(0., 50.);
        int panAmount = this.strategy.getPanAmount(this.boundingBox, geoEvent);
        Assert.assertTrue("Expected far left pan amount", panAmount == 0);
    }

    @Test
    public void getPanAmount_mediumLeftEvent_mediumLeftPan(){
        GeoEvent geoEvent = getGeoEvent(25., 50.);
        int panAmount = this.strategy.getPanAmount(this.boundingBox, geoEvent);
        Assert.assertTrue("Expected medium left pan amount", panAmount == 25);
    }

    @Test
    public void getPanAmount_mediumRightEvent_mediumRightPan(){
        GeoEvent geoEvent = getGeoEvent(75., 50.);
        int panAmount = this.strategy.getPanAmount(this.boundingBox, geoEvent);
        Assert.assertTrue("Expected medium right pan amount", panAmount == 75);
    }

    @Test
    public void getPanAmount_mediumRightEvent_correctRoundingMediumReftPan(){
        GeoEvent geoEvent = getGeoEvent(74.9, 50.);
        int panAmount = this.strategy.getPanAmount(this.boundingBox, geoEvent);
        Assert.assertTrue("Expected medium right pan amount", panAmount == 75);
    }

    @Test
    public void getVelocityAmount_bottomLeftEvent_minVelocity(){
        GeoEvent geoEvent = getGeoEvent(0., 0.);
        int velocityAmount = this.strategy.getVelocityAmount(this.boundingBox, geoEvent);
        Assert.assertTrue("Expected min velocity amount", velocityAmount == 0);
    }

    @Test
    public void getVelocityAmount_topRightEvent_minVelocity(){
        GeoEvent geoEvent = getGeoEvent(100., 100.);
        int velocityAmount = this.strategy.getVelocityAmount(this.boundingBox, geoEvent);
        Assert.assertTrue("Expected min velocity amount", velocityAmount == 0);
    }

    @Test
    public void getVelocityAmount_centerBottomLeftEvent_mediumVelocity(){
        GeoEvent geoEvent = getGeoEvent(25., 25.);
        int velocityAmount = this.strategy.getVelocityAmount(this.boundingBox, geoEvent);
        Assert.assertTrue("Expected half velocity amount", velocityAmount == 50);
    }

    @Test
    public void getVelocityAmount_centerTopRightEvent_mediumVelocity(){
        GeoEvent geoEvent = getGeoEvent(75., 75.);
        int velocityAmount = this.strategy.getVelocityAmount(this.boundingBox, geoEvent);
        Assert.assertTrue("Expected half velocity amount", velocityAmount == 50);
    }

    @Test
    public void getVelocityAmount_distantBottomLeftEvent_lowVelocity(){
        GeoEvent geoEvent = getGeoEvent(5., 5.);
        int velocityAmount = this.strategy.getVelocityAmount(this.boundingBox, geoEvent);
        Assert.assertTrue("Expected low velocity amount", velocityAmount == 10);
    }

    @Test
    public void getVelocityAmount_distantTopRightEvent_lowVelocity(){
        GeoEvent geoEvent = getGeoEvent(90., 90.);
        int velocityAmount = this.strategy.getVelocityAmount(this.boundingBox, geoEvent);
        Assert.assertTrue("Expected low velocity amount", velocityAmount == 20);
    }

    private GeoEvent getGeoEvent(double longitude, double latitude){
        return new GeoEvent(new Location(longitude, latitude), System.currentTimeMillis(), "Test");
    }

}
