package org.example.demo;


public class ThreadByImplementingRunnable implements Runnable  {
        @Override
        public void run() {
            System.out.println("Current thread:"+ Thread.currentThread().getName());
        }


        public static void main(String[] args) {
        Thread thread = new Thread(new ThreadByImplementingRunnable());
        thread.start();
    }
}
