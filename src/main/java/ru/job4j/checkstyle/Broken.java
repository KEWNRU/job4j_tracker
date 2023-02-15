package ru.job4j.checkstyle;

public class Broken {
    private int sizeOfEmpty = 10;

    private String surname;

    private static final String NEW_VALUE = "";

    void echo() {
    }

    void media(Object obj) {
        if (obj != null) {
            System.out.println(obj);
        }
    }

    void method(int a) {

            String name;

            new Broken();
    }
}

