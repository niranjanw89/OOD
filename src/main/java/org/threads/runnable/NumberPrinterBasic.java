package org.threads.runnable;

public class NumberPrinterBasic {
    public static void main(String[] args) {
        Runnable oddPrinter = () -> {
            for (int i = 1; i <= 10; i += 2) {
                System.out.println("OddThread : " + i);
            }
        };

        Runnable evenPrinter = () -> {
            for (int i = 2; i <= 10; i += 2) {
                System.out.println("EvenThread : " + i);
            }
        };

        Thread t1 = new Thread(oddPrinter);
        Thread t2 = new Thread(evenPrinter);

        t1.start();
        t2.start();
    }
}
