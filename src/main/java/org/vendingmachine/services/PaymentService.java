package org.vendingmachine.services;

public interface PaymentService {
    void insertMoney(double coinValue);
    boolean isPaymentSufficient(double price);
    double dispenseChange(double price);
    double refund();
    void reset();
    double getInsertedAmount();


}
