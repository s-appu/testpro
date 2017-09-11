package test.nestedClasses;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Random;

import org.apache.commons.lang3.RandomStringUtils;

public class ComparatorTest {

    public static void main( final String args[] ) {

        final List<Person> personList = createShortList();

        System.out.println( "=== Initial List ====" );
        System.out.println( personList );

        // Sort with inner class
        final List<Person> innerClassSortPersonList = new ArrayList<>( personList );
        Collections.sort( innerClassSortPersonList, new Comparator<Person>() {

            @Override
            public int compare( final Person o1, final Person o2 ) {
                return o1.getGivenName().compareTo( o2.getGivenName() );
            }
        } );
        System.out.println( "=== Ascending order sort with inner class ====" );
        System.out.println( innerClassSortPersonList );

        // Sort with lambda
        final List<Person> lambdaSortPersonList = new ArrayList<>( personList );
        Collections.sort( lambdaSortPersonList, ( final Person p1, final Person p2 ) -> p2.getGivenName().compareTo( p1.getGivenName() ) );
        System.out.println( "=== Descending order sort with lambda ====" );
        System.out.println( lambdaSortPersonList );

        // Sort with lambda with no reference in argument list
        final List<Person> lambdaNoArgSortPersonList = new ArrayList<>( personList );
        Collections.sort( lambdaNoArgSortPersonList, ( p1, p2 ) -> p1.getGivenName().compareTo( p2.getGivenName() ) );
        System.out.println( "=== Ascending order sort with lambda with no argument ====" );
        System.out.println( lambdaNoArgSortPersonList );

    }

    public static List<Person> createShortList() {
        final List<Person> persons = new ArrayList<>();
        for ( int i = 0; i < 5; i++ ) {
            new Random().toString();
            persons.add( Person.aBuilder().givenName( new Random().nextInt() + "" ).surName( RandomStringUtils.random( 5 ) ).age( new Random().nextInt() ).gender( Gender.MALE ).email( RandomStringUtils.random( 5 ) ).phoneNumber( RandomStringUtils.random( 5 ) ).address( RandomStringUtils.random( 5 ) ).build() );
        }
        return persons;

    }
}
