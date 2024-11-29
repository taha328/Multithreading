package org.example.demo;

import java.util.concurrent.CountDownLatch;

public class CountdownLatch implements Runnable {
    private final CountDownLatch latch;
    private final String name;

    public CountdownLatch(CountDownLatch latch, String name) {
        this.latch = latch;
        this.name = name;
    }
    @Override
    public void run() {
        try {
            System.out.println(name + " is starting work.");
            // Simulate work with a random delay
            Thread.sleep((long) (Math.random() * 5000));
            System.out.println(name + " has finished work.");
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        } finally {
            // Decrement the latch counter
            latch.countDown();
        }
    }

    public static void main(String[] args) throws InterruptedException {
        // Create a CountDownLatch with a count of 3
        CountDownLatch latch = new CountDownLatch(3);

        // Create and start 3 worker threads
        Thread worker1 = new Thread(new CountdownLatch(latch, "Thread 1"));
        Thread worker2 = new Thread(new CountdownLatch(latch, "Thread 2"));
        Thread worker3 = new Thread(new CountdownLatch(latch, "Thread 3"));

        worker1.start();
        worker2.start();
        worker3.start();

        // Main thread waits until the latch count reaches 0
        latch.await();

        // After all worker threads have finished, the main thread continues
        System.out.println("All threads have finished, main thread continues.");
    }
}
