package org.dsa.linkedListLoop;

public class TradeNode {
    private int tradeId;
    TradeNode next;

    public TradeNode(int tradeId) {
        this.tradeId = tradeId;
        this.next = null;
    }

    public int getTradeId() {
        return tradeId;
    }
}
