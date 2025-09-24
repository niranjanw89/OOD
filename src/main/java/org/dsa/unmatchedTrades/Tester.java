package org.dsa.unmatchedTrades;

import java.util.List;

public class Tester {
    public static void main(String[] args) {
        TradeNode tradeNode1 = new TradeNode("T1");
        TradeNode tradeNode2 = new TradeNode("T2");
        TradeNode tradeNode3 = new TradeNode("T3");
        TradeNode tradeNode4 = new TradeNode("T4");
        TradeNode tradeNode5 = new TradeNode("T5");

        tradeNode1.next = tradeNode2;
        tradeNode2.next = tradeNode3;
        tradeNode3.next = tradeNode4;
        tradeNode4.next = tradeNode5;

        TradeNode tradeNode6 = new TradeNode("T1");
        TradeNode tradeNode7 = new TradeNode("T2");
        TradeNode tradeNode8 = new TradeNode("T4");
        TradeNode tradeNode9 = new TradeNode("T6");

        tradeNode6.next = tradeNode7;
        tradeNode7.next = tradeNode8;
        tradeNode8.next = tradeNode9;

        List<String> trades = TradeMatcher.findUnmatchedTrades(tradeNode1, tradeNode6);

        for (String tradeId: trades) {
            System.out.println(tradeId);
        }
    }
}
