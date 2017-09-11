package test.collections;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Test;

public class TestCollections {

    public static void main( final String args[] ) {

        final List<String> l = new ArrayList<>();

        System.out.println( l.stream().findFirst() );
    }

    @Test
    public void testArraysAsList() {
        // final List<String> l = Collections.singletonList( null );
        final List<String> l = new ArrayList<>();
        // l.add( null );

        final String s = l.stream().findFirst().orElse( null );
        System.out.println( s );

    }

    @Test
    public void testNullMapKeys() {
        final Map<String, String> mp = new HashMap<>();
        mp.put( null, "Appu" );
        mp.put( null, "Swaroop" );

    }
}
