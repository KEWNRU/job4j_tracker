package ru.job4j.oop;

public class Bus implements Vehicle {
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_GREEN = "\u001B[32m";

    @Override
    public void move() {
        System.out.println(ANSI_GREEN + getClass().getSimpleName() +  ANSI_RED + " - Автобус двигается по скоростным трассам");
    }
}
