package com.concurrency.producerconsumer;

import java.util.Vector;

public class ProducerConsumerSolution {

    public static void main( final String args[] ) {
        final Vector sharedQueue = new Vector();
        final int size = 4;
        final Thread prodThread = new Thread( new Producer( sharedQueue, size ), "Producer" );
        final Thread consThread = new Thread( new Consumer( sharedQueue, size ), "Consumer" );
        prodThread.start();
        consThread.start();
    }

}
