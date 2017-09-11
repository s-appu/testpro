package test.nestedClasses;

import java.util.List;
import java.util.function.Predicate;

public class RoboContactsLambda {

    public void phoneContacts( final List<Person> p, final Predicate<Person> pred ) {
        p.stream().filter( k -> pred.test( k ) ).forEach( m -> {
            this.roboCall( m );
        } );
    }

    public void emailContacts( final List<Person> p, final Predicate<Person> pred ) {
        p.stream().filter( k -> pred.test( k ) ).forEach( m -> {
            this.roboEmail( m );
        } );
    }

    public void mailContacts( final List<Person> p, final Predicate<Person> pred ) {
        p.stream().filter( k -> pred.test( k ) ).forEach( m -> {
            this.roboMail( m );
        } );
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
