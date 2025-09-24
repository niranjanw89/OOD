package org.dsa.linkedListLoop;

public class TradeCycleDetector {
    public static void main(String[] args) {
        TradeNode t1 = new TradeNode(101);
        TradeNode t2 = new TradeNode(102);
        TradeNode t3 = new TradeNode(103);
        TradeNode t4 = new TradeNode(104);

        t1.next = t2;
        t2.next = t3;
        t3.next = t4;
        t4.next = t2; // introduces a cycle

        System.out.println(hasCycle(t1)); // true
    }

    public static boolean hasCycle(TradeNode root){
        if (root == null)
            return false;
        TradeNode slow = root;
        TradeNode fast = root;

        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
            if(fast != null && slow.getTradeId() == fast.getTradeId()){
                return true;
            }
        }
        return false;
    }
}
