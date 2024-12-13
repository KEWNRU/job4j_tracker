package ru.job4j.tracker;

import lombok.Data;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Data
public class Item {

    private static final DateTimeFormatter FORMATTER = DateTimeFormatter.ofPattern("dd-MMMM-EEEE-yyyy HH:mm:ss");

    private LocalDateTime created = LocalDateTime.now();
    private int id;
    private String name;

    public Item(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public Item(String name) {
        this.name = name;
    }


    @Override
    public String toString() {
        return "Item{"
                + "created=" + created.format(FORMATTER)
                + ", id=" + id
                + ", name='" + name + '\''
                + '}';
    }

}

