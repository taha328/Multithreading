package org.example.demo;

import java.util.concurrent.locks.ReentrantLock;

public class ReentrantLockExample {

    private final ReentrantLock lock = new ReentrantLock(true);

    public void accessResource(String threadName) {
        try {
            System.out.println(threadName + " is trying to acquire the lock.");
            lock.lock(); // Acquiring the lock
            System.out.println(threadName + " has acquired the lock.");

            // Simulate some work
            Thread.sleep(1000);

            System.out.println(threadName + " is releasing the lock.");
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        } finally {
            lock.unlock(); // Always release the lock in the 'finally' block
        }
    }

    public static void main(String[] args) {
        ReentrantLockExample resource = new ReentrantLockExample();

        Runnable task = () -> {
            String threadName = Thread.currentThread().getName();
            resource.accessResource(threadName);
        };

        Thread thread1 = new Thread(task, "Thread-1");
        Thread thread2 = new Thread(task, "Thread-2");
        Thread thread3 = new Thread(task, "Thread-3");

        thread1.start();
        thread2.start();
        thread3.start();
    }
}

