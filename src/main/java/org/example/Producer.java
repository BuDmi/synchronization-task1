package org.example;

public class Producer extends Thread {
    private final Shop shop;
    private final long carProducingTime;

    public Producer(ThreadGroup threadGroup, Shop shop, String carName, long carProducingTime) {
        super(threadGroup, carName);
        this.shop = shop;
        this.carProducingTime = carProducingTime;
    }

    @Override
    public void run() {
        while (!isInterrupted()) {
            try {
                Thread.sleep(carProducingTime);
            } catch (InterruptedException e) {
                System.out.println("Producer finished production of a batch of cars " + Thread.currentThread().getName());
                return;
            }
            shop.receiveCar();
        }
    }
}
