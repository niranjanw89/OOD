package org.threads.basics;

public class ThreadsBasic {

    public static void main(String[] args) {
        long startTime = System.currentTimeMillis();
        Thread[] threadArr = new Thread[9];
        for(int i=1;i<10;i++) {
            int finalI = i;
            threadArr[i-1] = new Thread(() -> {
                long res = fact(finalI);
                System.out.println(res);
            });
            threadArr[i-1].start();
        }
        for (Thread t : threadArr) {
            try {
                t.join();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        System.out.println("Total time take: " +(System.currentTimeMillis() - startTime));
    }

    public static long fact(int num){
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        long result = 1;
        for(int i=1;i<=num;i++){
            result *= num;
        }
        return result;
    }
}
