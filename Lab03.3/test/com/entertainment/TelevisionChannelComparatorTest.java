package com.entertainment;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class TelevisionChannelComparatorTest {
    private Television tv1;
    private Television tv2;
    private TelevisionChannelComparator comparator;

    @Before
    public void setUp() {
        tv1 = new Television();
        tv2 = new Television();

        //  also need to create the Comparator<Television> object
        comparator = new TelevisionChannelComparator();
    }

    @Test
    public void compare_shouldBeZero_sameChannel() {
        assertEquals(0, comparator.compare(tv1, tv2));
    }

    @Test
    public void compare_shouldBeNegative_firstChannelLowerThanSecondChannel()
    throws InvalidChannelException {
        tv1.changeChannel(1);
        assertTrue(comparator.compare(tv1, tv2) < 0);
    }

    @Test
    public void compare_shouldBePositive_firstChannelGreaterThanSecondChannel()
    throws InvalidChannelException {
        tv1.changeChannel(10);
        assertTrue(comparator.compare(tv1, tv2) > 0);
    }
}