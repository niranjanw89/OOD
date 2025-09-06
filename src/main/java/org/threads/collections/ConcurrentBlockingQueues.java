package org.threads.collections;

import java.util.concurrent.BlockingDeque;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.TimeUnit;

public class ConcurrentBlockingQueues {
    public static void main(String[] args) {
        BlockingDeque<String> queue = new LinkedBlockingDeque<>();
        queue.offer("Niranjan");
        queue.offer("Aniket");
        queue.offer("Aishwarya");

        System.out.println(queue.peek());
        System.out.println(queue.poll());
        System.out.println(queue.size());
        System.out.println(queue.contains("Aniket"));
        System.out.println(queue);

        //special for concurrent queue
        try{
            queue.offer("Mandar", 200, TimeUnit.MILLISECONDS);
            queue.poll(300, TimeUnit.MILLISECONDS);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(queue);
    }
}
