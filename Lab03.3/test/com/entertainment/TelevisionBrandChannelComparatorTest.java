package com.entertainment;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class TelevisionBrandChannelComparatorTest {
    private Television tv1;
    private Television tv2;
    private TelevisionBrandChannelComparator comparator;

    @Before
    public void setUp() {
        tv1 = new Television("Sony");
        tv2 = new Television("Sony");
        comparator = new TelevisionBrandChannelComparator();
    }

    @Test
    public void compare_shouldBePositive_sameBrand_firstChannelGreaterThanSecondChannel()
    throws InvalidChannelException{
        tv2.changeChannel(1);
        assertTrue(comparator.compare(tv1, tv2) > 0);
    }

    @Test
    public void compare_shouldBeNegative_sameBrand_firstChannelLessThanSecondChannel()
    throws InvalidChannelException {
        tv1.changeChannel(1);
        assertTrue(comparator.compare(tv1, tv2) < 0);
    }

    @Test
    public void compare_shouldPositive_firstBrandGreaterThanSecondBrand() {
        tv2.setBrand("LG");
        assertTrue(comparator.compare(tv1, tv2) > 0);
    }

    @Test
    public void compare_shouldBeNegative_firstBrandLessThanSecondBrand() {
        tv1.setBrand("LG");
        assertTrue(comparator.compare(tv1, tv2) < 0);
    }

    @Test
    public void compare_shouldBeZero_sameBrandAndChannel() {
        assertEquals(0, comparator.compare(tv1, tv2));
    }
}