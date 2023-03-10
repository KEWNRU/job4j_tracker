package ru.job4j.condition;

import junit.framework.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

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
    public void when32to57then5dot38() {
        double expected = 5.38;
        Point a = new Point(3, 2);
        Point b = new Point(5, 7);
        double out = a.distance(b);
        Assert.assertEquals(expected, out, 0.01);
    }

    @Test
    public void when666to222then6dot92() {
        double expected = 6.92;
        Point d = new Point(6, 6, 6);
        Point c = new Point(2, 2, 2);
        double out = d.distance3d(c);
        Assert.assertEquals(expected, out, 0.01);
    }
}