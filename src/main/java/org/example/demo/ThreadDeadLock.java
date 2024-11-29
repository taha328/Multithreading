package org.example.demo;

public class ThreadDeadLock {

    private static final Object lock1 = new Object();  // Lock object 1
    private static final Object lock2 = new Object();  // Lock object 2

    // Thread 1 tries to lock lock1, then lock2
    public static void methodA() {
        synchronized (lock1) {
            System.out.println(Thread.currentThread().getName() + " is in methodA, locked lock1");
            // Simulate work that causes the deadlock
            synchronized (lock2) {
                System.out.println(Thread.currentThread().getName() + " locked lock2 in methodA");
            }
        }
    }

    // Thread 2 tries to lock lock2, then lock1
    public static void methodB() {
        synchronized (lock2) {
            System.out.println(Thread.currentThread().getName() + " is in methodB, locked lock2");
            // Simulate work that causes the deadlock
            synchronized (lock1) {
                System.out.println(Thread.currentThread().getName() + " locked lock1 in methodB");
            }
        }
    }

    public static void main(String[] args) {

        // Thread-1 will try to lock lock1 and then lock2
        Thread t1 = new Thread(() -> {
            methodA();
        }, "Thread-1");

        // Thread-2 will try to lock lock2 and then lock1
        Thread t2 = new Thread(() -> {
            methodB();
        }, "Thread-2");

        t1.start();
        t2.start();
    }
}
