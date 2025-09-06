package org.vendingmachine.services;

/*
CORE METHODS
insertAmount(double amount) → user inserts coins/bills

getInsertedAmount() → current balance inserted

isPaymentSufficient(double price) → check if enough money is inserted

dispenseChange(double price) → calculate and return extra money

refund() → if transaction is canceled

reset() → reset after transaction completes
*/
public class CashPayment implements PaymentService {

    private double insertedAmount;

    public CashPayment() {
        this.insertedAmount = 0.0;
    }

    @Override
    public void insertMoney(double amount) {
        if (amount <= 0) {
            System.out.println("Insert bills to proceed");
            return;
        }
        this.insertedAmount += amount;
        System.out.println("Inserted: $" + amount  + " | Total: $" + this.insertedAmount);
    }

    @Override
    public boolean isPaymentSufficient(double price) {
        return this.insertedAmount >= price;
    }

    @Override
    public double dispenseChange(double price) {
        double change = 0.0;
        if (isPaymentSufficient(price)) {
            change = this.insertedAmount - price;
            this.insertedAmount = 0.0; // Reset after dispensing change
            System.out.println("Dispensing change: $" + change);
            return change;
        } else {
            System.out.println("Insufficient payment. Please insert more money.");
            return 0.0;
        }
    }

    @Override
    public double refund(){
        double refundAmount = this.insertedAmount;
        this.insertedAmount = 0.0; // Reset after refund
        System.out.println("Refunding: $" + refundAmount);
        return refundAmount;
    }

    @Override
    public double getInsertedAmount() {
        return insertedAmount;
    }

    @Override
    // Reset for next transaction
    public void reset() {
        insertedAmount = 0.0;
    }


}
