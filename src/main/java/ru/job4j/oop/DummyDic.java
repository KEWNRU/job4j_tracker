package ru.job4j.oop;

public class DummyDic {
    public String engToRus(String eng) {
        return "Неизвестное слово. " + eng;
    }

    public static void main(String[] args) {

        DummyDic ivan = new DummyDic();
        String say = ivan.engToRus("GPU");
        System.out.println(say);

    }
}
