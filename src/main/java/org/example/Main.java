package org.example;

public class Main {
    public static void main(String[] args) {
        final int carNumForSellPlan = 10;
        final int carProducingTime = 2000;
        final int carWaitingTime = 3000;
        final Shop shop = new Shop(carNumForSellPlan);

        ThreadGroup threadGroup = new ThreadGroup("group");

        new Producer(threadGroup, shop, "Toyota", carProducingTime).start();
        new Client(threadGroup, shop, "Client 1", carWaitingTime).start();
        new Client(threadGroup, shop, "Client 2", carWaitingTime).start();
        new Client(threadGroup, shop, "Client 3", carWaitingTime).start();

        while (!shop.isFinishedSellPlan()) {
        }
        System.out.println("Plan completed");
        threadGroup.interrupt();
    }
}