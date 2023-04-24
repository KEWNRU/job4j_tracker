package ru.job4j.collection;

import java.util.Comparator;

public class LexSort implements Comparator<String> {

    @Override
    public int compare(String left, String right) {
        String[] key = left.split(". ");
        String[] key1 = right.split(". ");
        int l = Integer.parseInt(key[0]);
        int r = Integer.parseInt(key1[0]);
        return Integer.compare(l, r);
    }
}