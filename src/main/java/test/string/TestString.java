package test.string;

import java.io.File;
import java.net.URI;

public class TestString {
    public static void main( final String args[] ) throws Exception {
        // testFile();
        // testBool();
        // nullTest();
        System.out.println( testSwitch() );
        // testStringPlus();
        // testStringFormat();
    }

    public static void testStringFormat() {
        System.out.println( String.format( "%s %s.test", null, "my" ) );
    }

    static void testSubstring() {
        final String str = "123123/asd/incoming/ABCD/";
        System.out.println( str.substring( 0, str.indexOf( "/incoming" ) ) );
    }

    static void testFile() throws Exception {

        final URI u = new URI( "/Users/swaroop.appu/Dev/abc/" );
        final File f = new File( u );

    }

    static void testStringPlus() throws Exception {
        String message = "Message is ";
        message += "something";
        System.out.println( message );
    }

    static void testBool() {

        final Integer aId1 = null;
        final Integer aId2 = null;

        if ( aId1 != null ? !aId1.equals( aId2 ) : aId2 != null ) {
            System.out.println( "Bad" );
        } else {
            System.out.println( "Good" );
        }
    }

    static void nullTest() {
        if ( null == null ) {
            System.out.println( "Nulls are equal" );
        }

        final String a = null;
        final String b = null;
        if ( a == b ) {
            System.out.println( "a and b are equal" );
        }
    }

    static String testSwitch() {

        final String currentGame = "CRICKET";
        final String GAME_SOCCER = "SOCCER";
        final String GAME_CRICKET = "CRICKET";
        final String ONE = "1";
        String val = "";
        switch ( currentGame ) {
            case GAME_SOCCER:
                val = GAME_SOCCER;
                break;
            case GAME_CRICKET:
                val = GAME_CRICKET;
                break;
            default:
                val = "DEFAULT";
                break;
        }

        return val;
    }
}
