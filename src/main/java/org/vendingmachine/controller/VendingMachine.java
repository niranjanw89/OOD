package org.vendingmachine.controller;

import org.vendingmachine.enums.Mode;
import org.vendingmachine.model.Inventory;
import org.vendingmachine.model.Product;
import org.vendingmachine.services.PaymentService;

/*
has an Inventory, PaymentService and tracks the mode
* */
public class VendingMachine {
    private Inventory inventory;
    private PaymentService paymentService;
    private Mode mode;

    private Product selectedProduct;


    public VendingMachine(Inventory inventory, PaymentService paymentService, Mode mode) {
        this.inventory = inventory;
        this.paymentService = paymentService;
        this.mode = mode;
    }

    public void displayProducts() {
        inventory.getProducts();
    }

    public void restockProduct(Product product, int quantity) {
        if(mode == Mode.ADMIN){
            inventory.restockProduct(product, quantity);
        }
        else{
            throw new UnsupportedOperationException("Only admin can restock products.");
        }

    }

    public void selectProduct(String productId) {
        // Logic to select a product by its ID
        Product product = inventory.getProduct(productId);
        if (product == null) {
            System.out.println("Invalid product code, please enter the correct code " + productId);
            return;
        }
        this.selectedProduct = product;
        System.out.println("Selected product: " + product.getProductName() + " with price: " + product.getPrice() + " and quantity: " + product.getProductQty());
        System.out.println("Please insert payment to proceed.");

    }

    public Product dispenseProduct() {
        // Logic to dispense the selected product
        if(selectedProduct == null) {
            System.out.println("No product selected. Please select a product first.");
            return null;
        }

        //Deduct one item from inventory
        Product product = this.inventory.getProduct(selectedProduct.getProductId());

        if(product == null) {
            System.out.println("Product is out of stock. Please select another product.");
            return null;
        }
        this.selectedProduct = null; // Reset selected product after dispensing
        paymentService.reset();
        return product;

    }

    public void processPayment(double amount) {
        // Logic to process payment for the selected product
        if (selectedProduct == null) {
            System.out.println("No product selected. Please select a product first.");
            return;
        }
        this.paymentService.insertMoney(amount);
        if(this.paymentService.isPaymentSufficient(selectedProduct.getPrice())) {
            dispenseProduct();
            double change = this.paymentService.dispenseChange(selectedProduct.getPrice());
            System.out.println("Thank you for your purchase! Your change is: $" + change);
        } else {
            System.out.println("Insufficient payment. Please insert more money.");
        }
    }

    public void cancelTransaction() {
        // Logic to cancel the current transaction
    }


}
