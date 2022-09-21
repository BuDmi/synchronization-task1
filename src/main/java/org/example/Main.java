package org.example;

public class Main {
    public static void main(String[] args) {
        final Shop shop = new Shop();

        ThreadGroup threadGroup = new ThreadGroup("group");

        Producer producer = new Producer(threadGroup, shop, "Toyota", 2000);

        for(int i = 1; i < 11; i++) {
            new Client(threadGroup, shop, "Client " + i, 3000).start();
        }

        producer.start();

        while (!shop.isFinishedSellPlan()) {
        }
        System.out.println("Plan completed");
        threadGroup.interrupt();
    }
}