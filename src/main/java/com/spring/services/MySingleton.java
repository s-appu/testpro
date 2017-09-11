package com.spring.services;

import org.springframework.stereotype.Component;

@Component
public class MySingleton {

    private static MySingleton mySingleton;

    private MySingleton() {
    }

    public static MySingleton getInstance() {
        synchronized ( MySingleton.class ) {
            if ( mySingleton == null ) {
                mySingleton = new MySingleton();
            }
        }
        return mySingleton;
    }

}
