package org.vendingmachine.services;

//For future upgrades
public class DigitalPayment implements PaymentService {

    @Override
    public void insertMoney(double coinValue) {

    }

    @Override
    public boolean isPaymentSufficient(double price) {
        return false;
    }

    @Override
    public double dispenseChange(double price) {
        return 0;
    }

    @Override
    public double refund() {
        return 0;
    }

    @Override
    public void reset() {

    }

    @Override
    public double getInsertedAmount() {
        return 0;
    }
}
