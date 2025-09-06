package org.vendingmachine.model;

/*
A unique identifier (like A1, A2, B1...)

A name (e.g., "Coke", "Chips")

A price

A quantity (stock count)

levels
* */
public class Product {
    private String productId;
    private int productQty;

    private String productName;

    private double price;

    public Product(String productId, int productQty, String productName, Double price){
        this.productId = productId;
        this.productQty = productQty;
        this.productName =  productName;
        this.price = price;

    }

    public String getProductId() {
        return productId;
    }

    public int getProductQty() {
        return productQty;
    }

    public String getProductName() {
        return productName;
    }

    public double getPrice() {
        return price;
    }


}
