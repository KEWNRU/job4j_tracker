package ru.job4j.oop;

public class Usege {

    public static void main(String[] args) {
        Vehicle airplane = new Airplane();
        Vehicle airplane1 = new Airplane();
        Vehicle train = new Train();
        Vehicle train1 = new Train();
        Vehicle bus = new Bus();
        Vehicle bus1 = new Bus();
        Vehicle[] vehicles = new Vehicle[]{airplane, train, bus, airplane1, train1, bus1};
        for (Vehicle a : vehicles) {
            a.move();
        }
    }
}
