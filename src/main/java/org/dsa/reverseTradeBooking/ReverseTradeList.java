package org.dsa.reverseTradeBooking;
/*
 null <- node1 <-> node2 <-> node3 <-> node4 <-> node5 -> null
                                                    h
                                                    tn
 null <- node5 <-> node4 <-> node3 <-> node2 <-> node1 -> null
*/
public class ReverseTradeList {
    public static TradeNode reverseList(TradeNode head){
        TradeNode tailNode = head;
        while(head.next != null){
            head = head.next;
        }
        head.next = head.prev;
        head.prev = null;



        return head;
    }
}
