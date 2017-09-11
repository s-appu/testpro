package com.spring.services;

import org.springframework.stereotype.Service;

@Service
public class ManagementService {

    private PaymentService service;

    public ManagementService( final PaymentService service ) {
        this.service = service;
    }

    public PaymentService getService() {
        return this.service;
    }

}
