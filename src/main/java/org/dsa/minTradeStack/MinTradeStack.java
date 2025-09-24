package org.dsa.minTradeStack;

import java.util.Stack;

public class MinTradeStack {

    private Stack<Integer> minStack = new Stack<>();
    private Stack<Integer> mainStack = new Stack<>();

    //Push Trade amount
    public void push(int tradeAmount){
        mainStack.push(tradeAmount);
        if(minStack.isEmpty() || tradeAmount <= minStack.peek()){
            minStack.push(tradeAmount);
        }
    }

    //Pop Trade amount
    public int pop(){
        if(mainStack.isEmpty()){
            System.out.println("Stack is empty");
            return -1;
        }
        int removedElement = mainStack.pop();
        if(removedElement == minStack.peek()){
            minStack.pop();
        }
        return removedElement;
    }

    public  int getMin(){
        if(minStack.isEmpty()){
            System.out.println("Min stack is empty");
            return -1;
        }
        return minStack.peek();
    }

}
