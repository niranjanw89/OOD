package org.dsa.unmatchedTrades;

import java.util.*;

//Given two linked lists representing trades booked in two systems (System A and System B), write a function to find unmatched trades.
public class TradeMatcher {

    public static List<String> findUnmatchedTrades(TradeNode headA, TradeNode headB){
        List<String> unmatchedTrades = new ArrayList<>();
        Set<String> setA = new HashSet<>();
        Set<String> setB = new HashSet<>();

        TradeNode current = headA;
        while(current != null){
            setA.add(current.tradeId);
            current = current.next;
        }

        current = headB;
        while(current != null){
            setB.add(current.tradeId);
            current = current.next;
        }

        for (String tradeId: setA) {
            if(!setB.contains(tradeId)){
                unmatchedTrades.add(tradeId);
            }
        }

        for (String tradeId: setB) {
            if(!setA.contains(tradeId)){
                unmatchedTrades.add(tradeId);
            }
        }

        return unmatchedTrades;
    }

}
