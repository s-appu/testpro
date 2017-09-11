package test.nestedClasses;

import java.util.List;

/**
 *
 * Drivers: Persons over the age of 16
 * Draftees: Male persons between the ages of 18 and 25
 * Pilots (specifically commercial pilots): Persons between the ages of 23 and 65
 */

public class RoboContactsApproach3_WithAnonymousClass {

    public void callDriver( final List<Person> people, final MyTest<Person> aTest ) {
        for ( final Person p : people ) {
            if ( aTest.test( p ) ) {
                this.roboCall( p );
            }
        }
    }

    public void emailDraftees( final List<Person> people, final MyTest<Person> aTest ) {
        for ( final Person p : people ) {
            if ( aTest.test( p ) ) {
                this.roboEmail( p );
            }
        }
    }

    public void mailPilots( final List<Person> people, final MyTest<Person> aTest ) {
        for ( final Person p : people ) {
            if ( aTest.test( p ) ) {
                this.roboMail( p );
            }
        }
    }

    public void roboCall( final Person p ) {
        System.out.println( "Calling " + p.getGivenName() + " " + p.getSurName() + " age " + p.getAge() + " at " + p.getPhone() );
    }

    public void roboEmail( final Person p ) {
        System.out.println( "EMailing " + p.getGivenName() + " " + p.getSurName() + " age " + p.getAge() + " at " + p.getEmail() );
    }

    public void roboMail( final Person p ) {
        System.out.println( "Mailing " + p.getGivenName() + " " + p.getSurName() + " age " + p.getAge() + " at " + p.getAddress() );
    }

}
