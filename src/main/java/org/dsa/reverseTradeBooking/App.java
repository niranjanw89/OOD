package org.dsa.reverseTradeBooking;



//Implement a function to reverse a singly linked list of trades, where each node contains trade ID, timestamp, and amount.
public class App {
    public static void main(String[] args) {
        TradeNode node1 = new TradeNode("T1",100.21);
        TradeNode node2 = new TradeNode("T2", 200.14);
        TradeNode node3 = new TradeNode("T3", 425.25);
        TradeNode node4 = new TradeNode("T4", 203.6);
        TradeNode node5 = new TradeNode("T5", 104.36);

        node1.prev = null;
        node1.next = node2;

        node2.prev = node1;
        node2.next = node3;

        node3.prev = node2;
        node3.next = node4;

        node4.prev = node3;
        node4.next = node5;

        node5.prev = node4;
        node5.next = null;

        ReverseTradeList.reverseList(node1);

    }


}
