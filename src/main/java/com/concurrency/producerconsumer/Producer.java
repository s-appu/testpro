package com.concurrency.producerconsumer;

import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;

class Producer implements Runnable {

    private final Vector sharedQueue;
    private final int SIZE;

    public Producer( final Vector sharedQueue, final int size ) {
        this.sharedQueue = sharedQueue;
        this.SIZE = size;
    }

    // @Override
    // public void run() {
    // for ( int i = 0; i < 7; i++ ) {
    // System.out.println( "Produced: " + i );
    // try {
    // this.produce( i );
    // } catch ( final InterruptedException ex ) {
    // Logger.getLogger( Producer.class.getName() ).log( Level.SEVERE, null, ex );
    // }
    //
    // }
    // }

    @Override
    public void run() {
        final int i = 10;

        System.out.println( "Producer start" );
        try {
            Thread.sleep( 5000 );
            System.out.println( "Producing: " + i );
            this.produce( i );
        } catch ( final InterruptedException ex ) {
            Logger.getLogger( Producer.class.getName() ).log( Level.SEVERE, null, ex );
        }

    }

    private void produce( final int i ) throws InterruptedException {

        // wait if queue is full
        while ( this.sharedQueue.size() == this.SIZE ) {
            synchronized ( this.sharedQueue ) {
                System.out.println( "Queue is full " + Thread.currentThread().getName() + " is waiting , size: " + this.sharedQueue.size() );

                this.sharedQueue.wait();
            }
        }

        // producing element and notify consumers
        System.out.println( "Starts adding to sharedQueue" );
        synchronized ( this.sharedQueue ) {
            this.sharedQueue.add( i );
            System.out.println( "Added to sharedQueue" );
            Thread.sleep( 5000 );
            this.sharedQueue.notifyAll();
        }
    }
}
