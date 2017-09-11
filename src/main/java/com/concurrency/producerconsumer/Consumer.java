package com.concurrency.producerconsumer;

import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;

class Consumer implements Runnable {

    private final Vector sharedQueue;
    private final int SIZE;

    public Consumer( final Vector sharedQueue, final int size ) {
        this.sharedQueue = sharedQueue;
        this.SIZE = size;
    }

    @Override
    public void run() {
        System.out.println( "Consumer starts" );
        while ( true ) {
            try {
                System.out.println( "Consumed: " + this.consume() );
                Thread.sleep( 50 );
            } catch ( final InterruptedException ex ) {
                Logger.getLogger( Consumer.class.getName() ).log( Level.SEVERE, null, ex );
            }

        }
    }

    private int consume() throws InterruptedException {
        // wait if queue is empty
        int start = 0;
        synchronized ( this.sharedQueue ) {
            while ( this.sharedQueue.isEmpty() ) {

                start++;
                if ( start == 1 ) {
                    System.out.println( "Queue is empty " + Thread.currentThread().getName() + " is waiting , size: " + this.sharedQueue.size() );
                    // this.sharedQueue.wait();
                }
            }
        }

        // Otherwise consume element and notify waiting producer
        System.out.println( "Consumer starts to fetch from sharedQueue " );
        synchronized ( this.sharedQueue ) {
            this.sharedQueue.notifyAll();
            return (Integer) this.sharedQueue.remove( 0 );
        }
    }
}
