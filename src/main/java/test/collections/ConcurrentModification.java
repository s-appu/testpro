package test.collections;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import com.google.common.collect.HashBasedTable;
import com.google.common.collect.Table;

public class ConcurrentModification {

    Map<String, Table<String, String, Keyword>> l1;

    public static void main( final String args[] ) throws InterruptedException {

        final ConcurrentModification cm = new ConcurrentModification();
        cm.l1 = new HashMap<>();

        final Table<String, String, Keyword> groupedKeywords = HashBasedTable.create();
        groupedKeywords.put( "misc", "play", new Keyword( "out", "out-value" ) );
        groupedKeywords.put( "misc", "coach", new Keyword( "hit", "hit-value" ) );
        groupedKeywords.put( "misc", "pro", new Keyword( "view", "view-value" ) );

        cm.l1.put( "ABC", groupedKeywords );
        System.out.println( "Starting " );

        new Thread( new TempThread( cm ) ).start();

        Thread.sleep( 2000 );
        System.out.println( "Main slept" );
        cm.l1 = new HashMap<>();

        System.out.println( "Finished" );

    }

    public Table<String, String, Keyword> getKeywords( final String key ) {
        return this.l1.get( key );
    }
}

class TempThread implements Runnable {
    private final ConcurrentModification cm;

    public TempThread( final ConcurrentModification cm ) {
        this.cm = cm;
    }

    @Override
    public void run() {
        try {
            Thread.sleep( 5000 );
            final Table<String, String, Keyword> input = this.cm.getKeywords( "ABC" );

            final List<String> k = Arrays.asList( "play", "coach" );

            // Thread.sleep( 5000 );
            System.out.println( "Thread slept" );
            System.out.println( "**********Slept for 5 seconds" );
            final Set<Keyword> result = k.stream()
                    .filter( p -> input.contains( "misc", p ) )
                    .map( p -> new Keyword( input.get( "misc", p ).getKey(), input.get( "misc", p ).getValue() + "New Value" ) )
                    .collect( Collectors.toSet() );

            result.forEach( p -> {
                System.out.println( "Set : Key - " + p.getKey() + " Value - " + p.getValue() );
            } );

        } catch ( final InterruptedException e ) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch ( final Exception e ) {
            e.printStackTrace();
        }

    }
}