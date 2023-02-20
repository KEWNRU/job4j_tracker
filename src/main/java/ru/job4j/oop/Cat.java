package ru.job4j.oop;

public class Cat {

    private String food;
    private String name;

    public void nick() {
        System.out.println(this.name);
    }

    public void giveNick(String nick) {
        this.name = nick;
    }

    public void show() {
        System.out.println(this.food);
    }

    public void eat(String meat) {
        this.food = meat;
    }

    public static void main(String[] args) {
        System.out.println("There are gav's food.");
        Cat gav = new Cat();
        gav.giveNick("Gav");
        gav.eat("kotleta");
        gav.show();
        System.out.println("There are black's food.");
        Cat black = new Cat();
        black.giveNick("Blac");
        black.eat("fish");
        black.show();
        System.out.println("There are TOM'S food.");
        Cat tom = new Cat();
        tom.giveNick("TOM");
        tom.eat("kitiket");
        tom.show();
    }
}
