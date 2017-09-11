package test.collections;

import java.util.PriorityQueue;

public class PriorityQueueTest {

    public static void main( final String args[] ) {

        final PriorityQueue<String> pQ = new PriorityQueue<>( ( x, y ) -> y.length() - x.length() );
        pQ.add( "Sam" );
        pQ.add( "Maaasd" );
        pQ.add( "John" );

        System.out.println( pQ.poll() );
        System.out.println( pQ.poll() );
        System.out.println( pQ.poll() );
    }

    class Product {
        String ID;
        int cnt;

        Product( final String id, final int c ) {
            this.ID = id;
            this.cnt = c;
        }
    }

    // Map<String, Integer> map = new HashMap<>();
    // Queue<Product> minTen = new PriorityQueue<>( ( x, y ) -> x.cnt - y.cnt );
    //
    // void add( final String product ) {
    // int cnt = 0;
    // if ( this.map.containsKey( product ) ) {
    // this.map.put( product, cnt = this.map.get( product ) + 1 );
    // } else {
    // this.map.put( product, cnt = 1 );
    // }
    // if ( this.minTen.size() == 10 ) {
    // this.minTen.poll();
    // }
    // this.minTen.add( new Product( product, cnt ) );
    // }
    //
    // List<String> top10() {
    // final List<String> result = new ArrayList<>();
    // for ( final String id : this.minTen ) {
    // result.add( id );
    // }
    // return result;
    // }
}

// class Producer implements Runnable {
// private final BlockingQueue queue;
//
// Producer( final BlockingQueue q ) {
// this.queue = q;
// }
//
// @Override
// public void run() {
// try {
// while (true) { this.queue.put(this.produce()); }
// } catch (InterruptedException ex) { ... handle ...}
// }
//
// Object produce() { ... }
// }
//
// class Consumer implements Runnable {
// private final BlockingQueue queue;
//
// Consumer( final BlockingQueue q ) {
// this.queue = q;
// }
//
// @Override
// public void run() {
// try {
// while (true) { this.consume(this.queue.take()); }
// } catch (InterruptedException ex) { ... handle ...}
// }
//
// void consume(final Object x) { ... }
// }
//
// class Setup {
// void main() {
// final BlockingQueue q = new ArrayBlockingQueue(10);
// final Producer p = new Producer(q);
// final Consumer c1 = new Consumer(q);
// final Consumer c2 = new Consumer(q);
// new Thread(p).start();
// new Thread(c1).start();
// new Thread(c2).start();
// }
// }}