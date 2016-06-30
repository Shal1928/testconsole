import org.junit.Test;

import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import others.ListRecord;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.xpath.*;
import java.io.InputStream;


/**
 *
 */
public class TIsForTest {

    @Test
    public void main() {
        try {
            InputStream inputStream = TIsForTest.class.getResourceAsStream("Persons.XML");

            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder;
            Document doc;
            try {
                builder = factory.newDocumentBuilder();
                doc = builder.parse(inputStream);
            } catch (Exception e) {
                throw new RuntimeException(e);
            }

            XPath xpath = XPathFactory.newInstance().newXPath();

            String expression = "//RECORD/FIELD[@NAME='NREC' and text() ='00150000000014B9h' and @NAME='PERSNUMBER' or text() ='30100009']";

            System.out.println(xpath.compile("../FIELD[@NAME='FULLNAME']").evaluate(xpath.compile(expression).evaluate(doc, XPathConstants.NODE), XPathConstants.STRING));

        } catch (Throwable e) {
            System.out.println(e);
        }
    }
}
