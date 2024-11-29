package org.example.demo;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

public class CyclicBarrierExample implements Runnable{
    private final CyclicBarrier barrier;
    private final String name;

    public CyclicBarrierExample(CyclicBarrier barrier, String name) {
        this.barrier = barrier;
        this.name = name;
    }
    @Override
    public void run() {
        try {
            System.out.println(name + " is starting work.");
            // Simulate work with a random delay
            Thread.sleep((long) (Math.random() * 5000));
            System.out.println(name + " has finished work and is waiting at the barrier.");

            // Wait for others at the barrier
            barrier.await();

            // After the barrier, proceed with the next phase
            System.out.println(name + " is proceeding to the next phase.");
        } catch (InterruptedException | BrokenBarrierException e) {
            Thread.currentThread().interrupt();
        }
    }

    public static void main(String[] args) {
        // Create a CyclicBarrier for 3 threads
        CyclicBarrier barrier = new CyclicBarrier(3, () -> {
            // This will be called once all threads have reached the barrier
            System.out.println("All threads have reached the barrier, proceeding to the next phase.");
        });

        // Create and start 3 worker threads
        Thread worker1 = new Thread(new CyclicBarrierExample(barrier, "Thread 1"));
        Thread worker2 = new Thread(new CyclicBarrierExample(barrier, "Thread 2"));
        Thread worker3 = new Thread(new CyclicBarrierExample(barrier, "Thread 3"));

        worker1.start();
        worker2.start();
        worker3.start();
    }
}