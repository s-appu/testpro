package test.xml.operations;

import java.io.Reader;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.Unmarshaller;
import javax.xml.stream.XMLEventReader;
import javax.xml.stream.XMLInputFactory;

public class JaxbTest {

    public static void main( final String ssp[] ) {

    }

    public static <T> T unmarshal( final Reader reader, final Class<T> clz ) throws Exception {

        final JAXBContext jc = JAXBContext.newInstance( clz );

        final Unmarshaller jaxbUnmarshaller = jc.createUnmarshaller();
        // unmarshaller.setSchema(schema);
        // jaxbUnmarshaller.setEventHandler( new MyValidationEventHandler() );
        // final Customer customer = (Customer) jaxbUnmarshaller.unmarshal( new File( "input.xml" ) );

        // final JAXBContext context = getContext( clz );
        // final Unmarshaller jaxbUnmarshaller = context.createUnmarshaller();
        final XMLInputFactory xif = XMLInputFactory.newInstance();
        final XMLEventReader xer = xif.createXMLEventReader( reader );
        // final String rootElementName = getXmlRootElementName( clz );
        // if ( rootElementName != null && rootElementName.length() > 0 ) {
        // validateXmlRootElement( xer, rootElementName );
        // }
        final JAXBElement<T> element = jaxbUnmarshaller.unmarshal( xer, clz );
        return element.getValue();
    }
}
