package test.some;

import org.junit.Test;

public class TestSomeLogic {

    public static void main( final String args[] ) {
        multiConditionTest();
    }

    public static void multiConditionTest() {
        boolean a = true;
        boolean b = false;
        boolean c = false;

        if ( a || b && c ) {
            System.out.println( "Good" );
        }

        a = false;
        b = true;
        c = false;

        if ( a || b && c ) {
            System.out.println( "Bad" );
        }

        a = false;
        b = true;
        c = true;

        if ( a || b && c ) {
            System.out.println( "Good again" );
        }
    }

    @Test
    public void testSwitch() {
        final String test = "ABC";
        switch ( test ) {
            default:
                System.out.println( "default" );
            case "ABC":
                System.out.println( "ABC" );
                // break;
            case "AC":
                System.out.println( "AC" );
                // break;
            case "AB":
                System.out.println( "AB" );
                // break;

        }
    }
}
