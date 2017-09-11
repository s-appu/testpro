package test.nestedClasses;

import java.util.List;
import java.util.function.Predicate;

public class RoboContactsLambdaTest {

    public static void main( final String args[] ) {
        final List<Person> people = Person.createShortList();
        final RoboContactsLambda robo = new RoboContactsLambda();

        final Predicate<Person> allDrivers = p -> p.getAge() >= 16;
        final Predicate<Person> allDraftees = p -> p.getGender() == Gender.MALE && p.getAge() >= 18 && p.getAge() <= 25;
        final Predicate<Person> allPilots = p -> p.getAge() >= 23 && p.getAge() <= 65;

        final Predicate<Person> allDriversWhoCannotBePilots = allDrivers.and( allPilots.negate() );

        System.out.println( "===== Test Robo Contacts on Lamda ======" );

        System.out.println( "===== Calling all drivers ======" );
        robo.phoneContacts( people, allDrivers );

        System.out.println( "===== Emailing all draftees ======" );
        robo.emailContacts( people, allDraftees );

        System.out.println( "===== Mail all pilots ======" );
        robo.mailContacts( people, allPilots );

        System.out.println( "===== Calling Drivers but no pilots ======" );
        robo.mailContacts( people, allDriversWhoCannotBePilots );
    }
}
