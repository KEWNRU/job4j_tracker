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

    public Item() {
    }

    public Item(int id) {
        this.id = id;
    }

    public Item(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public void printInfo() {
        System.out.println(25 + name);
    }

    public static void main(String[] args) {
        Item name = new Item();
        name.printInfo();
    }
}