package test.collections;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class KeywordsGroup {

    public static void main( final String arg[] ) {

        test2();

    }

    static void test1() {
        final Keyword k1 = new Keyword( "city", "New York" );
        final Keyword k2 = new Keyword( "city", "New Jersey" );
        final Keyword k3 = new Keyword( "city", "Buffalo" );
        final Keyword k4 = new Keyword( "city", "Old York" );
        final Keyword k5 = new Keyword( "city", "Old Monk" );

        final List<Keyword> keywords = Arrays.asList( k1, k2, k3, k4, k5 );
        keywords.stream().forEach( k -> k.setGroup( getKeywordGroup( k ) ) );

        keywords.stream().forEach( p -> {
            System.out.println( p );
        } );
    }

    static String getKeywordGroup( final Keyword keyword ) {
        return keyword.getValue().startsWith( "New" ) ? "New" : keyword.getValue().startsWith( "Old" ) ? "Old" : "Other";
    }

    static void test2() {
        final Keyword k1 = new Keyword( "city", "New York" );
        final Keyword k2 = new Keyword( "State", "New Jersey" );
        final Keyword k3 = new Keyword( "Country", "Buffalo" );

        final Map<String, Keyword> m = new HashMap<>();
        m.put( k1.getKey(), k1 );
        m.put( k2.getKey(), k2 );
        m.put( k3.getKey(), k3 );

        final List<String> l = Arrays.asList( "city", "town" );

        final Set<Keyword> keywords = l.stream().filter( k -> m.containsKey( k ) ).map( p -> m.get( p ) ).collect( Collectors.toSet() );

        keywords.stream().forEach( p -> {
            System.out.println( p );
        } );
    }
}
