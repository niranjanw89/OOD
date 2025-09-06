package org.vendingmachine;

import org.vendingmachine.controller.VendingMachine;
import org.vendingmachine.enums.Mode;
import org.vendingmachine.model.Inventory;
import org.vendingmachine.model.Product;
import org.vendingmachine.services.CashPayment;

public class Server {

    public static void main(String[] args) {
        // Initialize the vending machine application
        Product product = new Product("001", 10, "Coke", 1.50);
        Inventory inventory = new Inventory();
        inventory.restockProduct(product, 10);
        VendingMachine vendingMachineApp = new VendingMachine(inventory,new CashPayment(), Mode.CUSTOMER);
    }

}

