package com.core.classloader;

public class MyClassLoader extends ClassLoader {

    public MyClassLoader() {
        super( MyClassLoader.class.getClassLoader() );
    }
}
