package test.files;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.FileVisitResult;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class TestFileVisit {

    public static void main( final String args[] ) throws Exception {

        final String directoryBasePath = "/var/tmp/temp_delete";
        createDirectoriesAndFiles( directoryBasePath );

        Files.walkFileTree( Paths.get( directoryBasePath ), new SimpleFileVisitor<Path>() {

            List<Path> list = new ArrayList<Path>();

            @Override
            public FileVisitResult visitFile( final Path file, final BasicFileAttributes attrs ) throws IOException {
                // Files.delete( file );
                this.list.add( file );
                // System.out.println( file.toString() );
                return FileVisitResult.CONTINUE;
            }

            @Override
            public FileVisitResult postVisitDirectory( final Path dir, final IOException e ) throws IOException {
                if ( e == null ) {
                    // Files.delete( dir );
                    System.out.println( dir );

                    for ( final Path file : this.list ) {
                        Files.delete( file );
                    }

                    this.list = new ArrayList<>();

                    return FileVisitResult.CONTINUE;
                } else {
                    // directory iteration failed
                    throw e;
                }
            }
        } );

    }

    private static void createDirectoriesAndFiles( final String directoryBasePath ) throws IOException {

        final long directories = 1;

        final long filesPerDirectory = 5;

        for ( int i = 0; i < directories; i++ ) {
            final String dirName = directoryBasePath + "/temp_" + UUID.randomUUID().toString();
            Files.createDirectories( Paths.get( dirName ) );

            Files.createFile( Paths.get( directoryBasePath + "/tt_" + UUID.randomUUID().toString() ) );

            for ( int k = 0; k < filesPerDirectory; k++ ) {
                Files.createFile( Paths.get( dirName + "/temp_" + UUID.randomUUID().toString() + ".out" ) );
            }
        }

        System.out.println( "Temp files created" );
    }

    public static void writeFiles( final String baseDir ) throws IOException {

        final String dir = baseDir + "/DIR_ABC/xyz/";
        final Path newDirPath = Files.createDirectories( Paths.get( dir ) );

        final Path newFilePath = Files.createFile( Paths.get( newDirPath + "/FILE_ABC.out" ) );
        final File f = newFilePath.toFile();

        final BufferedWriter bw = new BufferedWriter( new FileWriter( f ) );
        for ( int i = 0; i < 100000; i++ ) {
            bw.write( UUID.randomUUID() + " ----- " + UUID.randomUUID() + " ----- " + UUID.randomUUID() + " ----- " + UUID.randomUUID() );
            bw.write( "\n" );
        }
        bw.close();

    }
}
