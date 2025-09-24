package org.threads.lock;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ReentrantExample {

    private final Lock lock = new ReentrantLock();

    public void outerMethod(){
        lock.lock();
        try{
            System.out.println("Outer method");
            innerMethod();
        }
        finally {
            lock.unlock();
        }
    }

    private void innerMethod() {
        lock.lock();
        try{
            System.out.println("Inner method");
        }
        finally {
            lock.unlock();
        }
    }

    public static void main(String[] args) {
        ReentrantExample ex = new ReentrantExample();
        ex.outerMethod();
    }
}
