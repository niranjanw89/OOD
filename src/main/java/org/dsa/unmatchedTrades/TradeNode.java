package org.dsa.unmatchedTrades;

public class TradeNode {
     String tradeId;
     TradeNode next;

        public TradeNode(String tradeId) {
            this.tradeId = tradeId;
            this.next = null;
        }

}
