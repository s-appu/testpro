package com.spring.services;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component("order2Service")
@Qualifier(value = "abc")
public class OrderService implements MyService {

    private String serviceName;

    public OrderService() {
    }

    public OrderService( final String serviceName ) {
        this.serviceName = serviceName;
    }

    public String getServiceName() {
        return this.serviceName;
    }

    @Override
    public int getItemsCount() {
        return 20;
    }

    public int totalCostAtPresent() {
        return 1000;
    }
}
