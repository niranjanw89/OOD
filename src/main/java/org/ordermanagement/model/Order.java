package org.ordermanagement.model;

public class Order {
    private String orderId;
    private String symbol;
    private int quantity;
    private double strikePrice;
    private String orderType; // e.g., "Market", "Limit", "Stop"
    private String orderStatus; // e.g., "Pending", "Executed", "Cancelled"

    public Order(String orderId, String symbol, int quantity, double strikePrice, String orderType,String orderStatus){
        this.orderId = orderId;
        this.symbol = symbol;
        this.quantity = quantity;
        this.strikePrice = strikePrice;
        this.orderType = orderType;
        this.orderStatus = orderStatus;
    }




}
