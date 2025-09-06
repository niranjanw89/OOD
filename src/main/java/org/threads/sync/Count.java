package org.threads.sync;

public class Count {
    public static int counter = 0;

    public synchronized static void incrementCounter() {
        int current = counter;
        System.out.println("Before: " + counter + " Current Thread: " + Thread.currentThread().getId());
        counter = current + 1;
        System.out.println("After: " + counter + " Current Thread: " + Thread.currentThread().getId());
    }

    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            Thread t1 = new Thread(() -> incrementCounter());
            t1.start();
        }
    }
}
