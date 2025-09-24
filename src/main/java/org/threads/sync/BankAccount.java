package org.threads.sync;

public class BankAccount {

    private int balance = 100;

    public synchronized void withdraw(int amount){
        System.out.println(Thread.currentThread().getName() + " attempting to Withdraw " + amount);
        if(amount > balance){
            System.out.println(Thread.currentThread().getName() + "account balance low");
        }
        else{
            System.out.println(Thread.currentThread().getName() + " Proceeding with withdrawal of " +amount);
            try {
                Thread.sleep(10000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            balance -= amount;
            System.out.println("Withdwaral complete. Balance is: " +balance);
        }
    }
}
