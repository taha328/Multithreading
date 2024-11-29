package org.example.demo;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class ThreadPool {
    public static void main(String[] args) {
        // Create Executor Services
        ExecutorService executor1 = Executors.newFixedThreadPool(5);
        ExecutorService executor2 = Executors.newCachedThreadPool();
        ScheduledExecutorService scheduledExecutorService = Executors.newScheduledThreadPool(2);

        // Task to run
        Runnable task = () -> System.out.println(Thread.currentThread().getName() + " is running...");

        // Submit tasks to executor1
        for (int i = 0; i < 5; i++) {
            executor1.submit(task);
        }

        // Submit tasks to executor2 with error handling
        for (int i = 0; i < 5; i++) {
            executor2.submit(() -> {
                try {
                    System.out.println(Thread.currentThread().getName() + " is handling task.");
                    Thread.sleep(1000);  // Simulate task execution
                } catch (InterruptedException e) {
                    // Handle interruption
                    System.err.println("Task was interrupted: " + e.getMessage());
                    Thread.currentThread().interrupt();  // Restore interruption status
                } catch (Exception e) {
                    // Handle other exceptions
                    System.err.println("An error occurred: " + e.getMessage());
                }
            });
        }

        // Scheduled task with fixed-rate execution (every 2 seconds)
        scheduledExecutorService.scheduleAtFixedRate(() -> {
            System.out.println(Thread.currentThread().getName() + " is running task at fixed rate.");
        }, 0, 2, TimeUnit.SECONDS);  // initial delay = 0, period = 2 seconds

        // Scheduled task with fixed-delay execution (delay after task completion)
        scheduledExecutorService.scheduleWithFixedDelay(() -> {
            System.out.println(Thread.currentThread().getName() + " is running task with fixed delay.");
        }, 1, 3, TimeUnit.SECONDS);  // initial delay = 1 second, delay between executions = 3 seconds

        // Gracefully shut down the executor services
        try {
            Thread.sleep(5000);  // Allow some time for scheduled tasks to run
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        executor1.shutdown();
        executor2.shutdown();
        scheduledExecutorService.shutdown();
    }
}
