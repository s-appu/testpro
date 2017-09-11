package com.spring.services.factory;

import com.spring.services.MyService;

public interface ServiceFactory {

    public MyService getMyService( String serviceName );
}
