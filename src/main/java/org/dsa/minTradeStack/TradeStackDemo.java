package org.dsa.minTradeStack;

public class TradeStackDemo {

    public static void main(String[] args) {
        MinTradeStack stack = new MinTradeStack();
        stack.push(500);   // Trade 1
        stack.push(200);   // Trade 2
        stack.push(300);   // Trade 3

        System.out.println("Min Trade = " + stack.getMin()); // 200
        stack.pop();
        System.out.println("Min Trade = " + stack.getMin()); // 200
        stack.pop();
        System.out.println("Min Trade = " + stack.getMin()); // 500
    }
}
