package org.cache;


import java.util.Map;

public class CacheLoader {
    public static void main(String[] args) {
        SimpleCache cache = new SimpleCache(2);
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

    private static void printCache(Map<String,Node> data) {

        for (Node node: data.values()) {
            System.out.println("Price for " +node.key + "is: " +node.val);
        }
    }
}
