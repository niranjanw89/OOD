package org.dsa.ringBuffer;

public class TradeEvent {
    String tradeId;
    String type;
    int qty;

    public TradeEvent(String tradeId, String type, int qty) {
        this.tradeId = tradeId;
        this.type = type;
        this.qty = qty;
    }
}
