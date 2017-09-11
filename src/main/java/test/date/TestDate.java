package test.date;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class TestDate implements ITestDate {

    public static void main( final String s[] ) throws Exception {
        // getDateFromLong();
        convertDate();
        // convertCurrentDateToLong();
        // convertCurrentDateMinusInputDaysToLong( -2 );

    }

    static void getDateInLong() {
        final Date d = new Date( 2016 - 1900, 4, 25, 10, 30 );
        System.out.println( d );
        System.out.println( d.getTime() );
    }

    public static void getDateFromLong() {
        final long d = 1450557445560l;
        final Date dt = new Date( d );
        System.out.println( "getDateFromLong : " + dt );
    }

    static void convertDate() throws Exception {
        final String dtString = "2016-10-05T22:13:29.544Z";
        final String format = "yyyy-MM-dd'T'HH:mm:ss.SSS'Z'";
        final DateFormat dtFormat = new SimpleDateFormat( format );
        final Date dt = dtFormat.parse( dtString );
        System.out.println( "convertDate : " + dt );
        System.out.println( "convertDate : " + dt.getTime() );
    }

    static void convertCurrentDateToLong() {
        final Date d = new Date();
        System.out.println( d );
        System.out.println( d.getTime() );
    }

    static void convertCurrentDateMinusInputDaysToLong( final int days ) {
        final Calendar cl = Calendar.getInstance();
        cl.add( Calendar.DAY_OF_MONTH, days );
        final Date d = new Date( cl.getTimeInMillis() );
        System.out.println( d );
        System.out.println( d.getTime() );
    }

}

// Fri Jan 08 14:54:01 EST 2016
// Sat Dec 19 15:37:25 EST 2015