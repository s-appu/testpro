package test.nestedClasses;

import java.util.List;

/**
 *
 * Drivers: Persons over the age of 16
 * Draftees: Male persons between the ages of 18 and 25
 * Pilots (specifically commercial pilots): Persons between the ages of 23 and 65
 */

public class RoboContactsApproach1 {

    public void callDriver( final List<Person> people ) {
        for ( final Person person : people ) {
            if ( person.getAge() >= 16 ) {
                this.roboCall( person );
            }
        }
    }

    public void emailDraftees( final List<Person> people ) {
        for ( final Person person : people ) {
            if ( person.getGender() == Gender.MALE && person.getAge() >= 18 && person.getAge() <= 25 ) {
                this.roboEmail( person );
            }
        }
    }

    public void mailPilots( final List<Person> people ) {
        for ( final Person person : people ) {
            if ( person.getAge() >= 23 && person.getAge() <= 65 ) {
                this.roboMail( person );
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
