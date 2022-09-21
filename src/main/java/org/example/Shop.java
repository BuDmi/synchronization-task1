package org.example;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public class Shop {
    private List<Car> cars = new ArrayList<>();
    private int carNumForSellPlan;
    AtomicInteger soldCar = new AtomicInteger(0);

    public Shop(int carNumForSellPlan) {
        this.carNumForSellPlan = carNumForSellPlan;
    }

    public synchronized Car sellCar() {
        try {
            System.out.println(Thread.currentThread().getName() + " enter to shop");
            while (cars.size() == 0) {
                System.out.println("No cars");
                wait();
            }

            System.out.println(Thread.currentThread().getName() + " drove on new car");
            System.out.println("Sold " + soldCar.incrementAndGet() + " cars");
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        return cars.remove(0);
    }

    public synchronized void receiveCar() {
        cars.add(new Car());
        System.out.println("Producer produced new " + Thread.currentThread().getName());
        notify();
    }

    public boolean isFinishedSellPlan() {
        return soldCar.get() == carNumForSellPlan;
    }
}

