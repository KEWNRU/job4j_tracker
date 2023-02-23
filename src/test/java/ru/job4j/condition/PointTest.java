package ru.job4j.condition;

import org.junit.Assert;
import org.junit.Test;
public class PointTest {

    @Test
    public void when00to20then2() {
        double expected = 2;
        Point a = new Point(0, 0);
        Point b = new Point(0, 2);
        double out = a.distance(b);
        Assert.assertEquals(expected, out, 0.01);
    }

    @Test
    public void when54to27then4dot24() {
        double expected = 4.24;
        Point a = new Point(5, 4);
        Point b = new Point(2, 7);
        double out = a.distance(b);
        Assert.assertEquals(expected, out, 0.01);
    }

    @Test
    public void when79to158then8dot06() {
        double expected = 8.06;
        Point a = new Point(7, 9);
        Point b = new Point(15, 8);
        double out = a.distance(b);
        Assert.assertEquals(expected, out, 0.01);
    }

}