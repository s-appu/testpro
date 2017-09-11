package test.files;

import java.io.File;

import org.junit.Test;

public class TestFileBasics {

    @Test
    public void testFileName() {

        final File f = new File( "myTest.txt" );
        System.out.println( f.getName() );
    }
}
