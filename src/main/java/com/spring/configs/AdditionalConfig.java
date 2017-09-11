package com.spring.configs;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.spring.services.OrderService;

@Configuration
// @ComponentScan(basePackages = "com.spring.services")
public class AdditionalConfig {

    @Bean
    public OrderService oldOrderService() {
        return new OrderService( "Old Pizza" );
    }

    @Bean
    @Qualifier(value = "bean2OrderService")
    public OrderService orderService() {
        return new OrderService( "Fruits" );
    }
}
