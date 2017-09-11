package test.xml.operations;

import java.io.StringReader;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathFactory;

import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;

public class XpathTester {

    static String contentXPath = "//content/@version";
    static String XML = "<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"yes\"?><content version=\"1.1\"><metadata><title>Afternoon groups to watch</title></metadata></content>";

    public static void main( final String ss[] ) {
        try {
            fetchAttributeUsingXpath();
        } catch ( final Exception e ) {
            e.printStackTrace();
        }

    }

    public static String fetchAttributeUsingXpath() throws Exception {

        final String contentXml = getXml();
        final Document doc = buildXmlDocumentFromContentXml( contentXml );

        final XPath xPath = XPathFactory.newInstance().newXPath();
        final NodeList contentNode = (NodeList) xPath.evaluate( contentXPath, doc, XPathConstants.NODESET );

        final String titleNode = (String) xPath.compile( "//content/metadata/title" ).evaluate( doc, XPathConstants.STRING );

        System.out.println( contentNode );
        System.out.println( contentNode.getLength() );
        System.out.println( contentNode.item( 0 ) );
        final String key = contentNode.item( 0 ).getTextContent();
        System.out.println( key );

        System.out.println( titleNode );

        return null;
    }

    public static String getXml() {
        return XML;
    }

    public static Document buildXmlDocumentFromContentXml( final String contentXml ) throws Exception {
        final DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder documentBuilder = null;
        documentBuilder = documentBuilderFactory.newDocumentBuilder();
        Document document = null;
        document = documentBuilder.parse( new InputSource( new StringReader( contentXml ) ) );
        return document;
    }
}
