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
    private Television tv;

    @Before
    public void setUp() {
        tv = new Television();
    }

    @Test
    public void testIllegalArgumentException() {
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

    @Test
    public void testEquals() {
        Television tv1 = new Television("Sony", 25, DisplayType.OLED);
        Television tv2 = new Television("Sony", 25, DisplayType.OLED);
        assertEquals(tv1,tv2);
        assertEquals(tv2, tv1);

        tv1.setBrand("LG");
        assertNotEquals(tv1, tv2);
    }

    @Test
    public void testCompareTo() {
        Television tv1 = new Television("LG");
        Television tv2 = new Television("Sony");
        Television tv3 = new Television("Samsung");
        assertTrue(tv1.compareTo(tv2) < 0);
        assertTrue(tv2.compareTo(tv1) > 0);

        tv2.setBrand("Sony");
        assertTrue(tv2.compareTo(tv2) == 0);
    }

    @Test
    public void changeChannel_shouldStoreValue_validInput_upperBound()
    throws InvalidChannelException{
        tv.changeChannel(999);
        assertEquals(999, tv.getCurrentChannel());
    }

    @Test (expected = InvalidChannelException.class)
    public void changeChannel_shouldThrowInvalidChannelException_invalidInput_upperBound()
    throws InvalidChannelException {
        tv.changeChannel(1000);
    }

    @Test
    public void changeChannel_shouldStoreValue_validInput_lowerBound()
    throws InvalidChannelException{
        tv.changeChannel(1);
    }

    @Test (expected = InvalidChannelException.class)
    public void changeChannel_shouldThrowInvalidChannelException_invalidInput_lowerBound()
    throws InvalidChannelException {
        tv.changeChannel(0);
    }

    @Test (expected = IllegalArgumentException.class)
    public void setVolume_shouldThrowIllegalArgumentException_invalidInput_upperBound() {
        tv.setVolume(-101);
    }

    @Test (expected = IllegalArgumentException.class)
    public void setVolume_shouldThrowIllegalArgumentException_invalidInput_lowerBound() {
        tv.setVolume(-1);
    }

    @Test
    public void setVolume_shouldStoreValue_validInput_lowerBound() {
        tv.setVolume(0);
        assertEquals(0, tv.getVolume());
    }

    @Test
    public void setVolume_shouldStoreValue_validInput_upperBound() {
        tv.setVolume(100);
        assertEquals(100, tv.getVolume());
    }
}