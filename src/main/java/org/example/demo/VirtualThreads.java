package org.example.demo;

public class VirtualThreads {

    public static void main(String[] args) throws InterruptedException {
        // Creating a virtual thread for each task
        for (int i = 1; i <= 10; i++) {
            Thread.startVirtualThread(() -> {
                String threadName = Thread.currentThread().getName();
                System.out.println(threadName + " is starting a task...");
                try {
                    Thread.sleep(1000); // Simulate work
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
                System.out.println(threadName + " has completed the task.");
            });
        }

        // Simulate some delay to allow all threads to finish
        Thread.sleep(2000); // Ensures all virtual threads complete
        System.out.println("All tasks are completed!");
    }
}
