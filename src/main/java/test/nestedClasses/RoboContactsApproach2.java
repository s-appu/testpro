package test.nestedClasses;

import java.util.List;

/**
 *
 * Drivers: Persons over the age of 16
 * Draftees: Male persons between the ages of 18 and 25
 * Pilots (specifically commercial pilots): Persons between the ages of 23 and 65
 */

public class RoboContactsApproach2 {

    public void callDriver( final List<Person> people ) {
        for ( final Person person : people ) {
            if ( this.isDriver( person ) ) {
                this.roboCall( person );
            }
        }
    }

    public void emailDraftees( final List<Person> people ) {
        for ( final Person person : people ) {
            if ( this.isDraftee( person ) ) {
                this.roboEmail( person );
            }
        }
    }

    public void mailPilots( final List<Person> people ) {
        for ( final Person person : people ) {
            if ( this.mailPilots( person ) ) {
                this.roboMail( person );
            }
        }
    }

    public boolean isDriver( final Person p ) {
        return p.getAge() >= 16;
    }

    public boolean isDraftee( final Person p ) {
        return p.getGender() == Gender.MALE && p.getAge() >= 18 && p.getAge() <= 25;
    }

    public boolean mailPilots( final Person p ) {
        return p.getAge() >= 23 && p.getAge() <= 65;
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
