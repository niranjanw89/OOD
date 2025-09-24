package org.dsa.ringBuffer;

public class CircularTradeQueue {
    private TradeEvent[] buffer;
    private int head = 0;
    private int tail = 0;
    private int count = 0;
    private int capacity;

    public CircularTradeQueue(int capacity) {
        this.capacity = capacity;
        this.buffer = new TradeEvent[capacity];
    }

    public void add(TradeEvent event){
        buffer[tail] = event;
        tail = (tail+1) % capacity;
        if(count == capacity){
            head = (head+1) % capacity;
        }
        else{
            count++;
        }

    }

    public TradeEvent get(int i) {
        if (i < 0 || i >= count) throw new IndexOutOfBoundsException();
        return buffer[(head + i) % capacity];
    }

    public void printAll() {
        for (int i = 0; i < count; i++) {
            System.out.println(get(i));
        }
    }

    public static void main(String[] args) {
        CircularTradeQueue tradeQueue = new CircularTradeQueue(3);

        tradeQueue.add(new TradeEvent("T1", "BOOK", 100));
        tradeQueue.add(new TradeEvent("T2", "BOOK", 200));
        tradeQueue.add(new TradeEvent("T3", "CANCEL", 50));

        System.out.println("Initial queue:");
        tradeQueue.printAll();

        tradeQueue.add(new TradeEvent("T4", "BOOK", 150)); // overwrites T1

        System.out.println("\nAfter adding T4:");
        tradeQueue.printAll();

        tradeQueue.add(new TradeEvent("T5", "AMEND", 300)); // overwrites T2

        System.out.println("\nAfter adding T5:");
        tradeQueue.printAll();
    }

}
