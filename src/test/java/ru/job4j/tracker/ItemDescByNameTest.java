package ru.job4j.tracker;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
class ItemDescByNameTest {

    @Test
    void ItemDescByName() {
        List<Item> items = Arrays.asList(
                new Item("a"),
                new Item("c"),
                new Item("b")
        );
        List<Item> expected = Arrays.asList(
                new Item("c"),
                new Item("b"),
                new Item("a")
        );
        items.sort(new ItemDescByName());
        assertEquals(items.toString(),expected.toString());

    }
}