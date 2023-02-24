package ru.job4j.condition;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;

public class MaxTest {
    @Test
    public void whenMax32To12Then32() {
        int left = 32;
        int right = 12;
        int result = Max.max(left, right);
        int expected = 32;
        assertThat(result).isEqualTo(expected);
    }

    @Test
    public void whenMax12To32Then12() {
        int second = 12;
        int left = 32;
        int result = Max.max(left, second);
        int expected = 32;
        assertThat(result).isEqualTo(expected);
    }

    @Test
    public void whenMax12To12Then12() {
        int second = 12;
        int third = 12;
        int result = Max.max(second, third);
        int expected = 12;
        assertThat(result).isEqualTo(expected);
    }
}
