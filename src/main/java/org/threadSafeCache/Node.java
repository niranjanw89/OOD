package org.threadSafeCache;

public class Node {
    String key;
    String val;
    Node prev;
    Node next;

    public Node(String key, String val) {
        this.key = key;
        this.val = val;
    }
}
