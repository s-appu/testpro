package com.spring.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class PaymentService extends AbstractPaymentService {

    private static final double STATE_TAX = 0.07;

    @Autowired
    PaymentService self;

    @Override
    public int getItemsCount() {
        return 1;
    }

    public double totalCost() {
        System.out.println( "self is :" + this.self );
        final int currentOrderCost = this.self.getCurrentOrderCost();
        final double totalCost = currentOrderCost + currentOrderCost * STATE_TAX;
        return totalCost;
    }
}
