package test.some;

import java.io.File;
import java.io.FileWriter;

public class TestFileIO {

    public static void main( final String[] args ) throws Exception {

        final File f = new File( "test" );

        final FileWriter writer = new FileWriter( f );
        final StringBuilder sb = new StringBuilder();
        for ( int i = 0; i < 54; i++ ) {
            final String s = "The Spring Framework is an application framework and inversion of control container for the Java platform\n";
            writer.write( s );
            sb.append( s );
        }
        final String s1 = "The Spring Framework is an application framework and inversion of control container";
        writer.write( s1 );
        sb.append( s1 );

        System.out.println( sb.length() ); // 8192 characters ( 1024 * 8)

        // writer.flush();
        // writer.close();
        // bw.flush();
        /*
         * final FileReader reader = new FileReader( f );
         * // Thread.sleep( 1000 );
         *
         *
         * final BufferedReader rd = new BufferedReader( reader );
         * final String data = rd.readLine();
         *
         * System.out.println( data );
         */

    }
}
