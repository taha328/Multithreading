package org.example.demo;

public class ThreadCommunication {
    private final Object lock = new Object();

    public void produce() throws InterruptedException {
        synchronized (lock) {
            System.out.println("Producer thread is running...");
            lock.wait();
            System.out.println("Resumed producer...");
        }
    }

    public void consume() throws InterruptedException {
        synchronized (lock) {
            Thread.sleep(1000);
            System.out.println("Consumer thread is running...");
            lock.notify();
        }
    }

    public static void main(String[] args) {
        ThreadCommunication example = new ThreadCommunication();

        Thread producer = new Thread(() -> {
            try {
                example.produce();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        Thread consumer = new Thread(() -> {
            try {
                example.consume();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        producer.start();
        consumer.start();
    }
}

