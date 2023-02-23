package ru.job4j.oop;

public class Calculator {

    private static int x = 5;

    public static int sum(int y) {
        return x + y;
    }

    public int multiply(int a) {
        return x * a;
    }

    public static int minus(int b) {
        return b - x;
    }

    public int divide(int c) {
        return c / x;
    }

    public int sumAllOperation(int result) {
        return sum(result) + multiply(result) + minus(result) + divide(result);
    }

    public static void main(String[] args) {
        int result = sum(10);
        System.out.println(result);
        Calculator calculator = new Calculator();
        result = calculator.multiply(2);
        System.out.println(result);
        result = minus(10);
        System.out.println(result);
        result = calculator.divide(45);
        System.out.println(result);
        result = calculator.sumAllOperation(result);
        System.out.println(result);
    }
}