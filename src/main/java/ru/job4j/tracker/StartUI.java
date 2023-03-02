package ru.job4j.tracker;

import java.time.format.DateTimeFormatter;
import java.time.LocalDateTime;
import java.util.Date;

public class StartUI {

    public static void main(String[] args) {
        Item item = new Item();
        System.out.println(item.getCreated());
    }
}
