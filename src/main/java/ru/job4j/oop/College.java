package ru.job4j.oop;

public class College {
    public static void main(String[] args) {
        Freshman fr = new Freshman();
        Student student = fr;
        Object obj = student;
        System.out.println(new Student());
        System.out.println(new Freshman());
        System.out.println(new Object());
    }
}
