package com.spring.aop;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;

@Aspect
public class PerformanceSetupAspect {

    @Before("execution(* com.spring.aop.AbstractPerformance.setup())")
    public void preSetUpTasks() {
        System.out.println( " AbstractPerformance set up is called" );
    }

}
