package ru.job4j.tracker;

import org.junit.jupiter.api.Test;


import static org.assertj.core.api.Assertions.assertThat;

public class HbmTrackerTest {
    @Test
    public void whenAddNewItemThenTrackerHasSameItem() {
        try (var tracker = new HbmTracker()) {
            Item item = new Item();
            item.setName("test1");
            tracker.add(item);
            Item result = tracker.findById(item.getId());
            assertThat(result.getName()).isEqualTo(item.getName());
        }
    }

    @Test
    public void whenItemFindById() {
        try (var tracker = new HbmTracker()) {
            Item item = new Item();
            item.setName("test1");
            tracker.add(item);
            Item rsl = tracker.findById(item.getId());
            assertThat(rsl.getName()).isEqualTo("test1");
        }
    }

    @Test
    public void whenDeleteItemThenTracker() {
        try (var tracker = new HbmTracker()) {
            Item item = new Item();
            item.setName("test1");
            tracker.add(item);
            int id = item.getId();
            tracker.delete(id);
            assertThat(tracker.findById(id)).isNull();
        }
    }
}