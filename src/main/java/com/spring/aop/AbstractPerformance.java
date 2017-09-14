package com.spring.aop;

public abstract class AbstractPerformance implements Performance {

    public void setup() {
        System.out.println( "Set up for Performance.." );
    }
}
