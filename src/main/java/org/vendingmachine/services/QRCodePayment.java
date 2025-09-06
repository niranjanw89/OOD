package org.vendingmachine.services;

public abstract class QRCodePayment implements PaymentService{

    @Override
    public boolean isPaymentSufficient(double price) {
        return false;
    }


    @Override
    public double refund() {
        return 0;
    }

    @Override
    public void reset() {

    }

}
