package com.spring.services;

import org.springframework.beans.factory.annotation.Autowired;

public abstract class AbstractPaymentService implements MyService {

    @Autowired
    private OrderService orderService;

    public int getCurrentOrderCost() {
        return this.orderService.totalCostAtPresent();
    }
}
