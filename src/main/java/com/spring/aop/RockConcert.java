package com.spring.aop;

import org.springframework.stereotype.Component;

@Component
@Expirable
public class RockConcert extends AbstractPerformance {

    @Override
    public void perform() {
        System.out.println( " This is a concert performance" );
    }

    public String location( final String country, final String state ) {
        final String location = String.format( "Concert is at %s in %s", state, country );
        System.out.println( location );
        return location;
    }

}
