package com.spring.services.factory;

public enum ServiceType {

    ORDER_SERVICE( "orderService" ), PAYMENT_SERVICE( "paymentService" );

    private final String value;

    ServiceType( final String value ) {
        this.value = value;
    }

    public String getValue() {
        return this.value;
    }

}
