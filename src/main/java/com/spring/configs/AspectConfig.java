package com.spring.configs;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

import com.spring.aop.Audience;

@Configuration
@EnableAspectJAutoProxy(proxyTargetClass = true)
@ComponentScan(basePackages = "com.spring.aop")
public class AspectConfig {

    @Bean
    public Audience audience() {
        return new Audience();
    }

    // @Bean
    // public PerformanceSetupAspect performanceSetupAspect() {
    // return new PerformanceSetupAspect();
    // }

}
