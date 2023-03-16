package ru.job4j.oop;

public class Train implements Vehicle {
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_GREEN = "\u001B[32m";

    @Override
    public void move() {
        System.out.println(ANSI_GREEN + getClass().getSimpleName() + ANSI_RED + " - Поезд передвигается по рельсам");
    }
}
