package org.threads.lock;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.logging.Logger;

public class BankAccount {

    private int balance = 100;

    private final Lock lock = new ReentrantLock();

    public  void withdraw(int amount){
        System.out.println(Thread.currentThread().getName() + " attempting to Withdraw " + amount);
        try {
            if(lock.tryLock(12000, TimeUnit.MILLISECONDS)){
                if(amount > balance){
                    System.out.println(Thread.currentThread().getName() + " insufficient balance");
                }
                else {
                    try {
                        System.out.println(Thread.currentThread().getName() + " proceeding with withdrawal");
                        Thread.sleep(10000);
                        balance -= amount;
                        System.out.println(Thread.currentThread().getName() + " withdrawal complete. Balance is: " + balance);
                    } catch (InterruptedException e) {
                        Thread.currentThread().interrupt();
                    } finally {
                        lock.unlock();
                    }
                }
            }
            else{
                System.out.println(Thread.currentThread().getName() + " Could not acquire the lock will try again later");
            }
        } catch (Exception e) {
            Thread.currentThread().interrupt();
        }
        if(Thread.currentThread().isInterrupted()){
            System.out.println("Thread was interrupted");
        }
    }
}
