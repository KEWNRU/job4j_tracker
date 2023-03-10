package ru.job4j.oop;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.offset;

public class TriangleTest {
    @Test
    public void when00and40and04Then8() {
        Point a = new Point(0, 0);
        Point b = new Point(4, 0);
        Point c = new Point(0, 4);
        Triangle triangle = new Triangle(a, b, c);
        double rsl = triangle.area();
        double expected = 8;
        assertThat(rsl).isCloseTo(expected, offset(0.001));
    }

    @Test
    public void when47and65and92ThenMinus1() {
        Point a = new Point(4, 7);
        Point b = new Point(6, 5);
        Point c = new Point(9, 2);
        Triangle triangle = new Triangle(a, b, c);
        double rsl = triangle.area();
        double expected = -1;
        assertThat(rsl).isCloseTo(expected, offset(0.001));
    }

    @Test
    public void when00and50and05Then810() {
        Point a = new Point(0, 0);
        Point b = new Point(5, 0);
        Point c = new Point(0, 5);
        Triangle triangle = new Triangle(a, b, c);
        double rsl = triangle.area();
        double expected = 12.5;
        assertThat(rsl).isCloseTo(expected, offset(0.001));
    }
}