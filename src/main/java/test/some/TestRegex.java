package test.some;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TestRegex {

    public static void main( final String args[] ) {

        final String directory = "googledrive01_1";

        final Pattern p = Pattern.compile( "drive(\\d)\\d\\d_" );
        final Matcher m = p.matcher( directory );

        if ( m.find() ) {
            System.out.println( "Found " );
        } else {
            System.out.println( "Not found" );
        }
    }
}
