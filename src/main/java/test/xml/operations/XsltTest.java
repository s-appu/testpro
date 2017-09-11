package test.xml.operations;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import javax.xml.transform.Result;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;

public class XsltTest {

    public static void main( final String[] args ) throws Exception {

        final XsltTest st = new XsltTest();
        final Path p = Paths.get( "/Users/swaroop.appu/Documents/workspace/Test/src/com/test/xslt", "test.xml" );
        final String dataXML = new String( Files.readAllBytes( p ) );

        final Path p2 = Paths.get( "/Users/swaroop.appu/Documents/workspace/Test/src/com/test/xslt", "test.xsl" );
        final String inputXSL = new String( Files.readAllBytes( p2 ) );

        final String output = "";

        try {
            st.transform( dataXML, output );
            // st.readFile();
        } catch ( final TransformerConfigurationException e ) {
            System.err.println( "TransformerConfigurationException" );
            System.err.println( e );
        } catch ( final TransformerException e ) {
            System.err.println( "TransformerException" );
            System.err.println( e );
        }
    }

    public void readFile() throws Exception {
        final File f = new File( "/Users/swaroop.appu/Documents/workspace/Test/src/com/test/xslt/test.xml" );
        final FileReader fr = new FileReader( f );
        final char[] a = new char[50];
        fr.read( a ); // reads the content to the array
        for ( final char c : a ) {
            System.out.print( c ); // prints the characters one by one
        }
        fr.close();
    }

    // public void transform( final String dataXML, final String output ) throws TransformerConfigurationException, TransformerException {
    // final File xslFile = new File( "/Users/swaroop.appu/Documents/workspace/Test/src/com/test/xslt/test.xsl" );
    // final TransformerFactory factory = TransformerFactory.newInstance();
    // final StreamSource xslStream = new StreamSource( xslFile );
    // final Transformer transformer = factory.newTransformer( xslStream );
    // final StreamSource in = new StreamSource( dataXML );
    // final StreamResult out = new StreamResult( output );
    // transformer.transform( in, out );
    // System.out.println( "The generated HTML file is:" + output );
    // }

    public void transform( final String dataXML, final String output ) throws TransformerConfigurationException, TransformerException, IOException {
        final File xslFile = new File( "test.xsl" );
        final TransformerFactory factory = TransformerFactory.newInstance();
        final StreamSource xslStream = new StreamSource( new FileInputStream( new File( "/Users/swaroop.appu/Documents/workspace/Test/src/com/test/xslt/test.xml" ) ) );
        final Transformer transformer = factory.newTransformer( xslStream );
        final StreamSource in = new StreamSource( dataXML );

        final ByteArrayOutputStream baos = new ByteArrayOutputStream();
        final Result result = new StreamResult( baos );
        transformer.transform( in, result );
        System.out.println( "The generated HTML file is:" + baos.toString() );
    }
}
