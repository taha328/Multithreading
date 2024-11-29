package org.example.demo;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class CallableFuture {

    // Callable task to validate payment
    static class PaymentValidationTask implements Callable<String> {
        @Override
        public String call() throws InterruptedException {
            Thread.sleep(2000); // Simulating payment validation time
            return "Payment Validated";
        }
    }

    // Callable task to check room availability
    static class RoomAvailabilityTask implements Callable<String> {
        @Override
        public String call() throws InterruptedException {
            Thread.sleep(1000); // Simulating room check time
            return "Room Available";
        }
    }

    // Callable task to calculate fees
    static class FeeCalculationTask implements Callable<String> {
        @Override
        public String call() throws InterruptedException {
            Thread.sleep(1500); // Simulating fee calculation time
            return "Fees Calculated";
        }
    }

    // Callable task to send confirmation email
    static class EmailSendingTask implements Callable<String> {
        @Override
        public String call() throws InterruptedException {
            Thread.sleep(500); // Simulating email sending time
            return "Confirmation Email Sent";
        }
    }

    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(4); // Pool of 4 threads for concurrent tasks

        // Submit tasks
        Future<String> paymentFuture = executorService.submit(new PaymentValidationTask());
        Future<String> roomFuture = executorService.submit(new RoomAvailabilityTask());
        Future<String> feeFuture = executorService.submit(new FeeCalculationTask());
        Future<String> emailFuture = executorService.submit(new EmailSendingTask());

        try {
            // Collecting results of all tasks
            System.out.println(paymentFuture.get()); // Payment validation result
            System.out.println(roomFuture.get()); // Room availability result
            System.out.println(feeFuture.get()); // Fee calculation result
            System.out.println(emailFuture.get()); // Email sending result

            // Final confirmation
            System.out.println("Booking Complete!");

        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        } finally {
            executorService.shutdown(); // Shutdown the executor service
        }
    }
}
