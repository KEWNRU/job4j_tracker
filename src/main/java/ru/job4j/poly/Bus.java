package ru.job4j.poly;

public class Bus implements Transport {
    @Override
    public void drive() {
        System.out.println("Go go go");
    }

    @Override
    public void passenger(int x) {
        for (int i = 0; i <= 20; i++) {
            x += 20;
        }
    }

    @Override
    public int refuel(int sum, int price) {
        return sum / price;
    }
}
