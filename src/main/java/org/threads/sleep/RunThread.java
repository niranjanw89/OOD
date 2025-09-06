package org.threads.sleep;

public class RunThread implements Runnable{
    @Override
    public void run() {
        for (int i = 1; i <=10; i++) {
            System.out.println("Current thread id" +Thread.currentThread().getId() + " i = " +i);
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
                break;
            }
        }
    }
}
