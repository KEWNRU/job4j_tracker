package ru.job4j.io;

import java.util.Scanner;
import java.util.Random;

public class MagicBall {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Задайте вопрос.");
        String name = input.nextLine();
        int answer = new Random().nextInt(3);
        String value = switch (answer) {
            case 1 -> "Yes";
            case 2 -> "No";
            default -> "May be";
        };
        System.out.println(value);
    }
}
