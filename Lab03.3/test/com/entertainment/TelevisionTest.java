package com.entertainment;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/*
 *  BVT:
 *  volume
 *  -1, 0 and 100, 101
 *  channel
 *  0, 1 and 999, 1000
 */
public class TelevisionTest {
    private Television tv1;
    private Television tv2;

    @Before
    public void setUp() {
        tv1 = new Television("Sony", 40, DisplayType.OLED);
        tv2 = new Television("Sony", 40, DisplayType.OLED);
    }

    //  setHashCode Test!
    @Test
    public void hashCode_shouldBeSameValue_sameObjects() {
        assertEquals(tv1.hashCode(), tv2.hashCode());
    }

    //  equals Test!
    @Test
    public void equals_shouldBeFalse_sameVolumeAndDisplay_differentBrand() {
        tv2.setBrand("LG");
        assertNotEquals(tv1, tv2);
    }

    @Test
    public void equals_shouldBeFalse_sameBrandAndDisplay_differentVolume() {
        tv2.setVolume(10);
        assertNotEquals(tv1, tv2);
    }

    @Test
    public void equals_shouldBeFalse_sameBrandAndVolume_differentDisplay() {
        tv2.setDisplay(DisplayType.LCD);
        assertNotEquals(tv1, tv2);
    }

    @Test
    public void equals_shouldBeTrue_inputAllTheSame() {
        assertEquals(tv1, tv2);
    }

    //  compareTo Test!
    @Test
    public void compareTo_ReturnZero_whenBrandsAreSame(){
        assertTrue(tv1.compareTo(tv2) == 0);
        assertEquals(0, tv1.compareTo(tv2));
    }

    @Test
    public void compareTo_ReturnNegativeNumber_whenFirstBrandIsLessThanSecondBrand() {
        tv1.setBrand("LG");
        tv2.setBrand("Sony");
        assertTrue(tv1.compareTo(tv2) < 0);
    }

    @Test
    public void compareTo_ReturnPositiveNumber_whenFirstBrandIsGreaterThanSecondBrand() {
        tv1.setBrand("Sony");
        tv2.setBrand("LG");
        assertTrue(tv1.compareTo(tv2) > 0);
    }

    //  channel Test!
    @Test
    public void changeChannel_shouldStoreValue_validInput_upperBound()
    throws InvalidChannelException{
        tv1.changeChannel(999);
        assertEquals(999, tv1.getCurrentChannel());
    }

    @Test (expected = InvalidChannelException.class)
    public void changeChannel_shouldThrowInvalidChannelException_invalidInput_upperBound()
    throws InvalidChannelException {
        tv1.changeChannel(1000);
    }

    @Test
    public void changeChannel_shouldStoreValue_validInput_lowerBound()
    throws InvalidChannelException{
        tv1.changeChannel(1);
    }

    @Test (expected = InvalidChannelException.class)
    public void changeChannel_shouldThrowInvalidChannelException_invalidInput_lowerBound()
    throws InvalidChannelException {
        tv1.changeChannel(0);
    }

    //  setVolumes Test!
    @Test (expected = IllegalArgumentException.class)
    public void setVolume_shouldThrowIllegalArgumentException_invalidInput_upperBound() {
        tv1.setVolume(-101);
    }

    @Test (expected = IllegalArgumentException.class)
    public void setVolume_shouldThrowIllegalArgumentException_invalidInput_lowerBound() {
        tv1.setVolume(-1);
    }

    @Test
    public void setVolume_shouldStoreValue_validInput_lowerBound() {
        tv1.setVolume(0);
        assertEquals(0, tv1.getVolume());
    }

    @Test
    public void setVolume_shouldStoreValue_validInput_upperBound() {
        tv1.setVolume(100);
        assertEquals(100, tv1.getVolume());
    }

    @Test
    public void testSetVolumeIllegalArgumentException() {
        Television tv = new Television();

        try {
            tv.setVolume(-1);
            fail("Should have thrown an IllegalArgumentException");
        }
        catch(IllegalArgumentException e) {
            assertEquals("Invalid volume: -1. Allowed range: [0,100].", e.getMessage());
        }
        try {
            tv.setVolume(101);
            fail("Should have thrown IllegalArgumentException");
        }
        catch (IllegalArgumentException e) {
            assertEquals("Invalid volume: 101. Allowed range: [0,100].", e.getMessage());
        }
    }
}
