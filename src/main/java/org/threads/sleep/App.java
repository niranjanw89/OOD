package org.threads.sleep;

public class App {

    public static void main(String[] args) {
        Thread t1 = new Thread(new RunThread());
        t1.start();

        try {
            t1.join(1500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        Thread t2 = new Thread(new RunThread());
        t2.start();                                 

    }
}
