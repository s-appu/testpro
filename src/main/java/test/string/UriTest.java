package test.string;

import java.net.URI;

public class UriTest {

    public static void main( final String args[] ) {

        final URI u = URI.create( "s3://mybucket_name/data/excel/" );
        System.out.println( u.getHost() );
        System.out.println( u.getPath() );
        System.out.println( u.getPath().substring( 1 ) );
    }
}
