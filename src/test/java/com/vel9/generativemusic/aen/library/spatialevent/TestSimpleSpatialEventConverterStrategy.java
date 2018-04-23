package com.vel9.generativemusic.aen.library.spatialevent;

import com.vel9.generativemusic.aen.core.spatialevent.BoundingBox;
import com.vel9.generativemusic.aen.core.spatialevent.SpatialEvent;
import com.vel9.generativemusic.aen.core.spatialevent.Location;
import org.junit.Assert;
import org.junit.Test;

public class TestSimpleSpatialEventConverterStrategy {

    private SimpleSpatialEventConverterStrategy strategy = new SimpleSpatialEventConverterStrategy();
    private BoundingBox boundingBox = BoundingBox.createBoundingBox(0., 100., 0., 100.);

    @Test
    public void getPanAmount_centerEvent_centerPan(){
        SpatialEvent spatialEvent = getGeoEvent(50., 50.);
        int panAmount = this.strategy.getPanAmount(this.boundingBox, spatialEvent);
        Assert.assertTrue("Expected center pan amount", panAmount == 50);
    }

    @Test
    public void getPanAmount_farRightEvent_farRightPan(){
        SpatialEvent spatialEvent = getGeoEvent(100., 50.);
        int panAmount = this.strategy.getPanAmount(this.boundingBox, spatialEvent);
        Assert.assertTrue("Expected far right pan amount", panAmount == 100);
    }

    @Test
    public void getPanAmount_farLeftEvent_farLeftPan(){
        SpatialEvent spatialEvent = getGeoEvent(0., 50.);
        int panAmount = this.strategy.getPanAmount(this.boundingBox, spatialEvent);
        Assert.assertTrue("Expected far left pan amount", panAmount == 0);
    }

    @Test
    public void getPanAmount_mediumLeftEvent_mediumLeftPan(){
        SpatialEvent spatialEvent = getGeoEvent(25., 50.);
        int panAmount = this.strategy.getPanAmount(this.boundingBox, spatialEvent);
        Assert.assertTrue("Expected medium left pan amount", panAmount == 25);
    }

    @Test
    public void getPanAmount_mediumRightEvent_mediumRightPan(){
        SpatialEvent spatialEvent = getGeoEvent(75., 50.);
        int panAmount = this.strategy.getPanAmount(this.boundingBox, spatialEvent);
        Assert.assertTrue("Expected medium right pan amount", panAmount == 75);
    }

    @Test
    public void getPanAmount_mediumRightEvent_correctRoundingMediumReftPan(){
        SpatialEvent spatialEvent = getGeoEvent(74.9, 50.);
        int panAmount = this.strategy.getPanAmount(this.boundingBox, spatialEvent);
        Assert.assertTrue("Expected medium right pan amount", panAmount == 75);
    }

    @Test
    public void getVelocityAmount_bottomLeftEvent_minVelocity(){
        SpatialEvent spatialEvent = getGeoEvent(0., 0.);
        int velocityAmount = this.strategy.getVelocityAmount(this.boundingBox, spatialEvent);
        Assert.assertTrue("Expected min velocity amount", velocityAmount == 0);
    }

    @Test
    public void getVelocityAmount_topRightEvent_minVelocity(){
        SpatialEvent spatialEvent = getGeoEvent(100., 100.);
        int velocityAmount = this.strategy.getVelocityAmount(this.boundingBox, spatialEvent);
        Assert.assertTrue("Expected min velocity amount", velocityAmount == 0);
    }

    @Test
    public void getVelocityAmount_centerBottomLeftEvent_mediumVelocity(){
        SpatialEvent spatialEvent = getGeoEvent(25., 25.);
        int velocityAmount = this.strategy.getVelocityAmount(this.boundingBox, spatialEvent);
        Assert.assertTrue("Expected half velocity amount", velocityAmount == 50);
    }

    @Test
    public void getVelocityAmount_centerTopRightEvent_mediumVelocity(){
        SpatialEvent spatialEvent = getGeoEvent(75., 75.);
        int velocityAmount = this.strategy.getVelocityAmount(this.boundingBox, spatialEvent);
        Assert.assertTrue("Expected half velocity amount", velocityAmount == 50);
    }

    @Test
    public void getVelocityAmount_distantBottomLeftEvent_lowVelocity(){
        SpatialEvent spatialEvent = getGeoEvent(5., 5.);
        int velocityAmount = this.strategy.getVelocityAmount(this.boundingBox, spatialEvent);
        Assert.assertTrue("Expected low velocity amount", velocityAmount == 10);
    }

    @Test
    public void getVelocityAmount_distantTopRightEvent_lowVelocity(){
        SpatialEvent spatialEvent = getGeoEvent(90., 90.);
        int velocityAmount = this.strategy.getVelocityAmount(this.boundingBox, spatialEvent);
        Assert.assertTrue("Expected low velocity amount", velocityAmount == 20);
    }

    private SpatialEvent getGeoEvent(double longitude, double latitude){
        return new SpatialEvent(new Location(longitude, latitude), System.currentTimeMillis(), "Test");
    }

}
