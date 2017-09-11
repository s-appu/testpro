package test.nestedClasses;

import java.util.List;

public class RoboContactsApproach3Test {

    public static void main( final String args[] ) {

        final List<Person> people = Person.createShortList();

        final RoboContactsApproach3_WithAnonymousClass robo = new RoboContactsApproach3_WithAnonymousClass();

        System.out.println( "===== Robo Contact Test with Anonymous Class =====" );

        System.out.println( "===== Calling all drivers ======" );
        robo.callDriver( people, new MyTest<Person>() {
            @Override
            public boolean test( final Person t ) {
                return t.getAge() >= 16;
            }
        } );

        System.out.println( "===== Emailing all draftees ======" );
        robo.emailDraftees( people, new MyTest<Person>() {
            @Override
            public boolean test( final Person t ) {
                return t.getGender() == Gender.MALE && t.getAge() >= 18 && t.getAge() <= 25;
            }
        } );

        System.out.println( "===== Mail all pilots ======" );
        robo.mailPilots( people, new MyTest<Person>() {
            @Override
            public boolean test( final Person t ) {
                return t.getAge() >= 23 && t.getAge() <= 65;
            }
        } );

    }
}
