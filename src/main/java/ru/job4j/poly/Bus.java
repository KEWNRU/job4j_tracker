package ru.job4j.poly;

public class Bus implements Transport {
    @Override
    public String drive() {
        return null;
    }

    @Override
    public int passenger(int x) {
        for(int i = 0; i <= 20; i++) {
            x += 20;
        }
        return x;
    }

    @Override
    public int refuel(int sum, int price) {
        return sum / price;
    }
}
