package org.threads.executorservice;

import java.util.concurrent.*;

public class FixedPoolExample {
    public static void main(String[] args) {
        Long startTime = System.currentTimeMillis();
        ExecutorService executorService = Executors.newFixedThreadPool(3);
        for(int i=1;i<10;i++){
            int finalI = i;
            executorService.submit(() -> {
                long res = fact(finalI);
                System.out.println(res);
            });
        }
        executorService.shutdown();
        try {
            executorService.awaitTermination(4000, TimeUnit.MILLISECONDS);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println("Total time: " +(System.currentTimeMillis() - startTime));
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
