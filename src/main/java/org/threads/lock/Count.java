package org.threads.lock;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Count {
    public static int counter = 0;
    public static Lock lock = new ReentrantLock();

    public static void incrementCounter() {
        if(lock.tryLock()){
            try {
                //lock.lock();
                int current = counter;
                System.out.println("Before: " + counter + " Current Thread: " + Thread.currentThread().getId());
                counter = current + 1;
                System.out.println("After: " + counter + " Current Thread: " + Thread.currentThread().getId());
            } finally {
                lock.unlock();
            }
        }
        else {
            System.out.println("Do something else");
        }

    }

    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            Thread t1 = new Thread(() -> incrementCounter());
            t1.start();
        }
    }
}
