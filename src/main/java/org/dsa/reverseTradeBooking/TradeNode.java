package org.dsa.reverseTradeBooking;

public class TradeNode {
    String tradeId;
    double amount;
    TradeNode next;
    TradeNode prev;

    public TradeNode(String tradeId, double amount) {
        this.tradeId = tradeId;
        this.amount = amount;
        this.next = null;
        this.prev = null;
    }
}
