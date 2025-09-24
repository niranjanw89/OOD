package org.threadSafeCache;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ThreadSafeCache {
    private final int capacity;
    private Node head;
    private Node tail;
    private final Map<String, Node> map;

    private final Lock lock = new ReentrantLock();

    public ThreadSafeCache(final int capacity) {
        this.capacity = capacity;
        this.map = new ConcurrentHashMap<>();
        this.head = new Node("head", "0");
        this.tail = new Node("tail","0");
        head.next = tail;
        tail.prev = head;
    }

    public Map<String, Node> getMap() {
        return map;
    }

    /*
            cache.put("APPL","$285.30");
            cache.put("MSFT", "$400.55");
            cache.put("TSLA", "$379.54");
            cache.put("GOOG", "$450.54");
            cache.get("TSLA");
            cache.put("NVDA", "$186.54");
            cache.get("F");
        * */
    public Map<String, Node> put(String key, String value){
        lock.lock();
        try{
            if(map.size() == capacity){
                remove(tail.prev);
            }
            insert(new Node(key,value));
        }
        finally {
            lock.unlock();
        }
        return map;
    }

    public void get(String key){
        lock.lock();
        try{
            if(map.containsKey(key)){
                Node node = map.get(key);
                remove(node);
                insert(node);
                return;
            }
            System.out.println("Stock symbol " +key+ " is not present in Cache");
        }
        finally {
            lock.unlock();
        }
    }


    /*
    h ----> node2 ---> t
    h <---- node2 <--- t
     */
    private void remove(Node node){
        node.prev.next = node.next;
        node.next.prev = node.prev;
        map.remove(node.key);
    }

    /*
    h ----> node2 ---> node1 ---> t
    h <---- node2 <--- node1 <--- t
     */
    private void insert(Node node){
        map.put(node.key,node);
        head.next.prev = node;
        node.next = head.next;
        node.prev = head;
        head.next = node;
    }
}
