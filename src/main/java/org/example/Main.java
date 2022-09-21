package org.example;

public class Main {
    public static void main(String[] args) {
        final int carNumForSellPlan = 10;
        final int carProducingTime = 2000;
        final int carWaitingTime = 3000;
        final Shop shop = new Shop(carNumForSellPlan);

        ThreadGroup threadGroup = new ThreadGroup("group");

        Producer producer = new Producer(threadGroup, shop, "Toyota", carProducingTime);

        for(int i = 0; i < carNumForSellPlan; i++) {
            new Client(threadGroup, shop, "Client " + (i + 1), carWaitingTime).start();
        }

        producer.start();

        while (!shop.isFinishedSellPlan()) {
        }
        System.out.println("Plan completed");
        threadGroup.interrupt();
    }
}