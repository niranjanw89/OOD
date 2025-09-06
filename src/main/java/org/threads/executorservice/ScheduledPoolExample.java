package org.threads.executorservice;


import java.util.concurrent.*;

public class ScheduledPoolExample {

    private static ScheduledExecutorService executorService = Executors.newScheduledThreadPool(50);


    public static void main(String[] args) {
       Future<Double> doubleFuture =  executorService.schedule(() -> {
           Thread.sleep((int) (Math.random()*200));
           System.out.println(1 + "Thread id: " +Thread.currentThread().getId());
           return Math.random();
       },1000, TimeUnit.MILLISECONDS);

        try {
            System.out.println(doubleFuture.get(100, TimeUnit.MILLISECONDS));
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        } catch (ExecutionException e) {
            throw new RuntimeException(e);
        } catch (TimeoutException e) {
            throw new RuntimeException(e);
        }

        executorService.shutdown();
    }
}
