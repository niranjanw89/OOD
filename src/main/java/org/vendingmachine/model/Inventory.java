package org.vendingmachine.model;

import java.util.*;

//Holds multiple Products
public class Inventory {
    private Map<String, Queue<Product>> productsInventory = new HashMap<>();

    public Map<String,Queue<Product>> getProducts(){
        return productsInventory;
    }

    public Product getProduct(String productId){
        if(productsInventory.containsKey(productId)){
            Queue<Product> productQueue = productsInventory.get(productId);
            if(!productQueue.isEmpty()){
                return productQueue.poll(); // Remove and return the product from the queue
            }
        }
        return null;
    }

    public void restockProduct(Product product, int quantity) {
        productsInventory.putIfAbsent(product.getProductId(), new LinkedList<>());
        int currentQty = productsInventory.get(product.getProductId()).size();
        int maxCapacity = product.getProductQty();
        int availableSpace = maxCapacity - currentQty;
        if(availableSpace <=0){
            System.out.println("Shelf " +product.getProductId()+ " is full, cannot restock. Current quantity: " + currentQty + ", Max capacity: " + maxCapacity);
            return;
        }
        int actualQty = Math.min(quantity, availableSpace);
        Queue<Product> productQueue = productsInventory.get(product.getProductId());
        for(int i=0;i< actualQty;i++){
            productQueue.add(product);
        }
        System.out.println(actualQty + "units of" + product.getProductName() + " restocked. Current quantity: " + productQueue.size() + ", Max capacity: " + maxCapacity);

    }
}
