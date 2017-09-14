package com.spring.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
public class Audience {

    @Pointcut("execution( * com.spring.aop.Performance+.perform(..))")
    public void performPointcut() {
    }

    @Before("performPointcut()")
    public void silenceMobilePhones() {
        System.out.println( "Silencing mobile phones" );
    }

    @Before("performPointcut()")
    public void takeSeats() {
        System.out.println( "Taking seats" );
    }

    @AfterReturning("performPointcut()")
    public void applause() {
        System.out.println( "Good performance..Clap" );
    }

    @AfterThrowing("performPointcut()")
    public void demandRefund() {
        System.out.println( "Demanding a refund" );
    }

    @Around("execution( * com.spring.aop.Performance+.perform(..))")
    public void watchPerformance( final ProceedingJoinPoint pjp ) throws Throwable {
        try {
            System.out.println( "watching performance -- silence mobile phones" );
            System.out.println( "watching performance -- take seats" );
            pjp.proceed();
            System.out.println( "watched performance -- Good Performance.. clap" );
        } catch ( final Throwable e ) {
            System.out.println( "watched performance -- issues, demand refund" );
        }

    }

    @Around("execution(** com.spring.aop.RockConcert.location(..)) && @target(d) && args(..,stateValue)")
    public Object logCountry( final ProceedingJoinPoint pjp, final Expirable d, final String stateValue ) throws Throwable {
        System.out.println( "Loggin country " + stateValue );
        System.out.println( "Expires in " + d.expireWithin() );
        return pjp.proceed();
    }

}
