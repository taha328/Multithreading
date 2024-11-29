package org.example.demo;

public class ThreadByExtendingThread extends Thread {
    @Override
    public void run() {
        System.out.println("Current thread:"+ Thread.currentThread().getName());
    }

    public static void main(String[] args) {
        ThreadByExtendingThread thread = new ThreadByExtendingThread();
        thread.start();
    }
}
