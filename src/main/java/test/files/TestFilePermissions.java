package test.files;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;

public class TestFilePermissions {

    public static void main( final String args[] ) throws Exception {

        final String dirPath = "/Users/swaroop.appu/personal/workspace-gen/TestProject/data";
        final String path = dirPath + "/temp.txt_backup";

        // System.out.println( "<<<< Testing Read file >>>>" );
        // readFile( path );
        //
        // System.out.println( "\n<<<< Testing Write file >>>>" );
        // writeToFile( dirPath + "/newTemp1.txt" );
        //
        // try {
        // System.out.println( "\n<<<< Testing Read file on marking file as not readable >>>>" );
        // changeFileReadPermissions( path, false );
        // readFile( path );
        // } catch ( final Exception e ) {
        // System.out.println( e.getMessage() );
        // changeFileReadPermissions( path, true );
        // }
        //
        // try {
        // System.out.println( "\n<<<< Testing Write file on marking directory as not writable >>>>" );
        // changeFileWritePermissions( dirPath, false );
        // writeToFile( dirPath + "/newTemp2.txt" );
        // } catch ( final Exception e ) {
        // System.out.println( e.getMessage() );
        // changeFileWritePermissions( dirPath, true );
        // }

        // System.out.println( "<<<<<< Rename file >>>>>>>>" );
        // renameFile( path );

        System.out.println( "<<<<<< Reset file name >>>>>>>>" );
        resetFileName( path );

    }

    private static void changeFileWritePermissions( final String path, final boolean isWriteable ) {
        final File f = new File( path );
        f.setWritable( isWriteable );
    }

    private static void changeFileReadPermissions( final String path, final boolean isReadable ) {
        final File f = new File( path );
        f.setReadable( isReadable );
    }

    public static void readFile( final String path ) throws Exception {
        final FileReader fr = new FileReader( new File( path ) );
        final BufferedReader br = new BufferedReader( fr );
        String s;
        while ( ( s = br.readLine() ) != null ) {
            System.out.println( s );
        }
        fr.close();
    }

    static void writeToFile( final String path ) throws Exception {
        final String source = "Now is the time for all good men\\n" + " to come to the aid of their country\\n" + " and pay their due taxes.";
        final char buffer[] = new char[source.length()];
        source.getChars( 0, source.length(), buffer, 0 );
        final FileWriter fw = new FileWriter( new File( path ) );
        for ( int i = 0; i < buffer.length; i += 2 ) {
            fw.write( buffer[i] );
        }
        fw.close();
    }

    static void renameFile( final String path ) throws Exception {
        final File f = new File( path );
        f.renameTo( new File( path.toString() + "_backup" ) );
    }

    static void resetFileName( final String path ) throws Exception {
        final File f = new File( path );

        final String newPath = path.substring( 0, path.indexOf( "_backup" ) );
        System.out.println( "New Path -- " + newPath );

        f.renameTo( new File( newPath ) );
    }
}
