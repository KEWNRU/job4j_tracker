package ru.job4j.poly;

public interface Transport {
    String drive();

    int passenger(int x);

    int refuel(int sum, int price);
}
