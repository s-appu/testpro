package com.spring.services;

import org.springframework.stereotype.Component;

@Component
public class PaymentService extends AbstractPaymentService {

    @Override
    public int getItemsCount() {
        return 1;
    }

}
