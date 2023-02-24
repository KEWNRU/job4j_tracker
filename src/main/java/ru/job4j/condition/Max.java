package ru.job4j.condition;

public class Max {
    public static int max(int left, int right) {
        return left > right ? left : right;
    }

    public static int max(int right, int left, int second) {
        return max(left, max(second, left));
    }

    public static int max(int left, int right, int second, int third) {
        return max(right, left, max(second, third));
    }
}
