package org.threads.collections;

import java.util.concurrent.BlockingDeque;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.LinkedBlockingDeque;

public class CollectionIntrefaces {
    public static void main(String[] args) {
        ConcurrentMap<String, String> map = new ConcurrentHashMap<>();
        map.put("Niranjan", "Java Developer");
        map.put("John", "Python Developer");

        BlockingDeque<String> queue = new LinkedBlockingDeque<>();
        queue.offer("Aniket");

    }
}
