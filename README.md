# Java Multithreading Examples

This document explains key multithreading concepts in Java, focusing on practical use cases and scenarios.

---

## Table of Contents

1. [BlockingQueue (Producer-Consumer)](#blockingqueue-producer-consumer)
2. [Callable and Future](#callable-and-future)
3. [CountdownLatch](#countdownlatch)
4. [CyclicBarrier](#cyclicbarrier)
5. [ReentrantLock](#reentrantlock)
6. [Thread by Extending Thread](#thread-by-extending-thread)
7. [Thread by Implementing Runnable](#thread-by-implementing-runnable)
8. [Thread Communication](#thread-communication)
9. [Thread Deadlock](#thread-deadlock)
10. [Thread Pool](#thread-pool)
11. [Thread Synchronization](#thread-synchronization)
12. [Virtual Threads](#virtual-threads)

---

## 1. BlockingQueue (Producer-Consumer)

**Description:**  
The `BlockingQueue` interface supports a producer-consumer pattern where producers add data to a shared queue, and consumers retrieve it. The queue blocks if full (for producers) or empty (for consumers).

**Use Case:**  
Efficiently handle tasks in a multi-threaded environment, such as logging systems or task scheduling.

---

## 2. Callable and Future

**Description:**  
The `Callable` interface is similar to `Runnable` but can return a result and throw checked exceptions. A `Future` represents the result of an asynchronous computation.

**Use Case:**  
Fetch data from multiple APIs concurrently and collect results once all calls are complete.

---

## 3. CountdownLatch

**Description:**  
`CountdownLatch` blocks a thread until a set number of other threads complete their operations. Threads call `countDown()` when done, and the main thread waits using `await()`.

**Use Case:**  
Ensure dependent services (e.g., databases or caches) are ready before starting a web server.

---

## 4. CyclicBarrier

**Description:**  
`CyclicBarrier` allows a group of threads to wait at a barrier until all threads have reached it. The barrier can be reused for multiple cycles.

**Use Case:**  
Coordinate phases in multi-threaded computations, such as combining partial results of matrix calculations.

---

## 5. ReentrantLock

**Description:**  
`ReentrantLock` provides fine-grained control over thread synchronization compared to `synchronized`. It supports locking, unlocking, and fair access.

**Use Case:**  
Control access to a shared resource with timeout mechanisms for thread safety.

---

## 6. Thread by Extending Thread

**Description:**  
Extend the `Thread` class and override the `run()` method to define a task.

**Use Case:**  
Perform simple concurrent tasks without sharing logic across threads.

---

## 7. Thread by Implementing Runnable

**Description:**  
Implement the `Runnable` interface and pass it to a `Thread` instance. This approach separates the task logic from thread management.

**Use Case:**  
Enable task reusability across threads and decouple task behavior from threading logic.

---

## 8. Thread Communication

**Description:**  
Threads communicate using methods like `wait()`, `notify()`, and `notifyAll()` on shared objects. This approach coordinates thread behavior by allowing one thread to wait for another's signal.

**Use Case:**  
Synchronize producer and consumer threads in data processing pipelines.

---

## 9. Thread Deadlock

**Description:**  
A deadlock occurs when two or more threads are waiting for each other's resources, causing a standstill.

**Use Case:**  
Avoid by designing systems with proper resource allocation and avoiding circular dependencies.

---

## 10. Thread Pool

**Description:**  
A thread pool manages a fixed number of threads to execute a large number of tasks efficiently. Use `Executors.newFixedThreadPool()` or similar methods.

**Use Case:**  
Process incoming HTTP requests on a web server without creating new threads for every request.

---

## 11. Thread Synchronization

**Description:**  
Ensure thread-safe access to shared resources using `synchronized` blocks or methods.

**Use Case:**  
Prevent race conditions when multiple threads update a shared counter or modify a file.

---

## 12. Virtual Threads

**Description:**  
Virtual threads, introduced in Java 19, are lightweight threads decoupled from OS threads. They allow high-concurrency applications with minimal resource usage.

**Use Case:**  
Handle thousands of concurrent tasks (e.g., HTTP requests) in a scalable manner without the overhead of traditional threads.

---


