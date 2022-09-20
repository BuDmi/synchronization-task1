package org.example;

public class Client extends Thread {
    private Shop shop;
    private String name;
    private int carWaitingTime;

    public Client(ThreadGroup threadGroup, Shop shop, String name, int carWaitingTime) {
        super(threadGroup, name);
        this.shop = shop;
        this.name = name;
        this.carWaitingTime = carWaitingTime;
    }

    @Override
    public void run() {
        try {
            Thread.sleep(carWaitingTime);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        shop.sellCar();
    }
}
