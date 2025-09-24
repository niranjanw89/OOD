package org.threadSafeCache;


import java.util.Map;

public class CacheLoader {
    public static void main(String[] args) {
        ThreadSafeCache cache = new ThreadSafeCache(2);
        Runnable task = new Runnable() {
            @Override
            public void run() {
                cache.put("APPL","$285.30");
                cache.put("MSFT", "$400.55");
                printCache(cache.getMap());
                cache.put("TSLA", "$379.54");
                printCache(cache.getMap());
                cache.put("GOOG", "$450.54");
                printCache(cache.getMap());
                cache.get("TSLA");
                printCache(cache.getMap());
                cache.put("NVDA", "$186.54");
                printCache(cache.getMap());
                cache.get("F");
                printCache(cache.getMap());
            }
        };

        Thread t1 = new Thread(task, "Thread 1");
        Thread t2 = new Thread(task, "Thread 2");

        t1.start();
        t2.start();

    }

    private static void printCache(Map<String, Node> data) {

        for (Node node: data.values()) {
            System.out.println(Thread.currentThread().getName() + ": Price for " +node.key + "is: " +node.val);
        }
    }
}
