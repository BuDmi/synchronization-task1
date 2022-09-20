package org.example;

public class Producer extends Thread {
    private Shop shop;
    private String carName;
    private long carProducingTime;

    public Producer(ThreadGroup threadGroup, Shop shop, String carName, long carProducingTime) {
        super(threadGroup, carName);
        this.shop = shop;
        this.carName = carName;
        this.carProducingTime = carProducingTime;
    }

    @Override
    public void run() {
        while (!isInterrupted()) {
            try {
                Thread.sleep(carProducingTime);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            shop.receiveCar();
        }
    }
}
