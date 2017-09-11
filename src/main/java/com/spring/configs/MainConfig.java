package com.spring.configs;

import org.springframework.beans.factory.FactoryBean;
import org.springframework.beans.factory.config.ServiceLocatorFactoryBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import com.spring.services.factory.ServiceFactory;

@Configuration
@ComponentScan(basePackages = "com.spring.services")
public class MainConfig {

    // @Bean
    // @Qualifier(value = "beanOrderService")
    // public OrderService orderService() {
    // return new OrderService( "Pizza" );
    // }

    // @Bean
    // @Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
    // public OrderService newOrderService() {
    // return new OrderService( "New Pizza Order" );
    // }
    //
    // @Bean(name = "mySecondSingleton")
    // @Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
    // public MySingleton mySingleton() {
    // return MySingleton.getInstance();
    // }
    //
    // @Bean
    // public DataSource dataSource() {
    // return new EmbeddedDatabaseBuilder().build();
    // }

    @Bean
    public FactoryBean serviceLocatorFactoryBean() {
        final ServiceLocatorFactoryBean factoryBean = new ServiceLocatorFactoryBean();
        factoryBean.setServiceLocatorInterface( ServiceFactory.class );
        return factoryBean;
    }

}
