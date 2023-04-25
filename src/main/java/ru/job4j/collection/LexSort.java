package ru.job4j.collection;

import java.util.Comparator;

public class LexSort implements Comparator<String> {

    @Override
    public int compare(String left, String right) {
        String[] separationLeft = left.split(". ");
        String[] separationRight = right.split(". ");
        return Integer.compare(Integer.parseInt(separationLeft[0]), Integer.parseInt(separationRight[0]));
    }
}