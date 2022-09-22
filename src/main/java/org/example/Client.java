package org.example;

public class Client extends Thread {
    private final Shop shop;
    private final int carWaitingTime;

    public Client(ThreadGroup threadGroup, Shop shop, String name, int carWaitingTime) {
        super(threadGroup, name);
        this.shop = shop;
        this.carWaitingTime = carWaitingTime;
    }

    @Override
    public void run() {
        while (!isInterrupted()) {
            try {
                Thread.sleep(carWaitingTime);
            } catch (InterruptedException e) {
                System.out.println(Thread.currentThread().getName() + " finished shopping");
                return;
            }
            shop.sellCar();
        }
    }
}
