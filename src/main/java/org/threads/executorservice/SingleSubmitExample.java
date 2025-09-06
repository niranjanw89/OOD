package org.threads.executorservice;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class SingleSubmitExample {

    private static ExecutorService executorService = Executors.newSingleThreadExecutor();

    public static Future<Double> getRandom(int i){
        return executorService.submit(() -> {
            System.out.println(i);
            return Math.random();
        });
    }

    public static void main(String[] args) {
        Future<Double> doubleFuture = getRandom(1);
        getRandom(2);
        getRandom(3);
        getRandom(4);
        while(!doubleFuture.isDone()){
            if(doubleFuture.isCancelled()){
                System.out.println("Its cancelled");
                break;
            }
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        try {
            System.out.println(doubleFuture.get());
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        } catch (ExecutionException e) {
            throw new RuntimeException(e);
        }
        executorService.shutdown();
    }
}
