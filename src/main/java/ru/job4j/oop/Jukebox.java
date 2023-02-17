package ru.job4j.oop;

public class Jukebox {
    public void music(int position) {

        if (position == 1) {
            System.out.println("Пусть бегут неуклюже");
        }
        if (position == 2) {
            System.out.println("Спокойной ночи");
        } else if (position > 2) {
            System.out.println("Песня не найдена");
        }
    }

    public static void main(String[] args) {
        Jukebox petya = new Jukebox();
        petya.music(1);
        System.out.println(petya);
        petya.music(2);
        System.out.println(petya);
        petya.music(3);
        System.out.println(petya);
    }
}
