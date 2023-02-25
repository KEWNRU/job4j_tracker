package ru.job4j.tracker;

public class Item {
    private int id;
    private String name;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String name(String name) {
        this.name = name;
        return name;
    }

    public String idName(int id, String name) {
        this.id = id;
        this.name = name;
        return name;
    }
}