import archive.ClassOne;
import archive.ClassThree;
import archive.ClassTwo;
import com.filenet.api.collection.FolderSet;
import com.filenet.api.core.Folder;
import com.filenet.api.core.ObjectStore;
import com.sun.javafx.binding.StringFormatter;
import foundation.S;
import fr.opensagres.xdocreport.document.IXDocReport;
import fr.opensagres.xdocreport.document.registry.XDocReportRegistry;
import fr.opensagres.xdocreport.template.IContext;
import fr.opensagres.xdocreport.template.TemplateEngineKind;
import fr.opensagres.xdocreport.template.formatter.FieldsMetadata;
import org.apache.poi.xwpf.extractor.XWPFWordExtractor;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xwpf.usermodel.XWPFParagraph;
import org.apache.poi.xwpf.usermodel.XWPFRun;
import org.apache.poi.xwpf.usermodel.XWPFTable;
import org.apache.velocity.Template;
import org.apache.velocity.VelocityContext;
import org.apache.velocity.app.VelocityEngine;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTR;
import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.Attributes;
import org.xml.sax.ContentHandler;
import org.xml.sax.EntityResolver;
import org.xml.sax.InputSource;
import org.xml.sax.Locator;
import org.xml.sax.SAXException;
import org.xml.sax.SAXNotRecognizedException;
import org.xml.sax.SAXNotSupportedException;
import org.xml.sax.XMLFilter;
import org.xml.sax.XMLReader;
import org.xml.sax.ext.LexicalHandler;
import org.xml.sax.helpers.DefaultHandler;
import org.xml.sax.helpers.XMLFilterImpl;
import org.xml.sax.helpers.XMLReaderFactory;
import others.*;
import ru.blogic20.easy_java_development_kit.misc.decorators.StringBuilderAdvanced;
import ru.blogic20.easy_subscription_development_kit.filenet.ce.MiscHelper;
import sun.net.www.protocol.file.FileURLConnection;

import javax.xml.bind.JAXBContext;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.stream.XMLOutputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamWriter;
import javax.xml.transform.Result;
import javax.xml.transform.Source;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpression;
import javax.xml.xpath.XPathExpressionException;
import javax.xml.xpath.XPathFactory;
import java.io.*;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URL;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.attribute.BasicFileAttributes;
import java.text.DateFormat;
import java.text.MessageFormat;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.concurrent.ConcurrentSkipListMap;
import java.util.zip.Adler32;
import java.util.zip.CRC32;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

import static foundation.FoundationJavaRules.sign;
import static java.text.MessageFormat.format;
import static ru.blogic20.easy_java_development_kit.misc.TimeDifferenceHelper.getSmartDifferenceFromCurrent;
import static ru.blogic20.easy_subscription_development_kit.filenet.ce.parts.LogMessageHelper.f;


/**
 *
 */
public class TIsForTest {

    private File file;

    private XPath xpath;
    private Document doc;

    @Test
    public void Test() throws Exception {
        try{

            String path = MessageFormat.format("{0}books.xml",
                getClass().getProtectionDomain().getCodeSource().getLocation().getPath());


            XMLReader reader = XMLReaderFactory.createXMLReader();
            reader.setContentHandler(new DummyHandler());
            File file = new File(path);
            reader.parse(new InputSource(new FileInputStream(file)));



        }catch (Throwable e){
            e.printStackTrace();
        }
    }

    public class DummyHandler implements ContentHandler
    {
        private XMLStreamWriter writer;
        public DummyHandler() throws IOException, XMLStreamException {
            File file = File.createTempFile("temp", ".xml");
            System.out.println(file.getAbsolutePath());
            OutputStream out = new FileOutputStream(file);

            XMLOutputFactory factory = XMLOutputFactory.newInstance();
            writer = factory.createXMLStreamWriter(out);
        }

        public void setDocumentLocator (Locator locator) {
            System.out.println("");
        }

        public void startDocument ()
            throws SAXException  {
            try {
                writer.writeStartDocument("UTF-8", "1.0");
            } catch (XMLStreamException e) {
                e.printStackTrace();
            }
        }

        public void endDocument()
            throws SAXException  {
            try {
                writer.flush();
            } catch (XMLStreamException e) {
                e.printStackTrace();
            }
        }

        public void startPrefixMapping (String prefix, String uri)
            throws SAXException  {
            System.out.println("");
        }

        public void endPrefixMapping (String prefix)
            throws SAXException  {
            System.out.println("");
        }

        private boolean skipElement;

        public void startElement (String uri, String localName,
            String qName, Attributes atts)
            throws SAXException  {
            String l = localName;
            System.out.println(localName);

            if(atts.getValue("id") != null) {
                try {
                    writer.writeCharacters("New characters".toCharArray(), 0, "New characters".length());
                } catch (XMLStreamException e) {
                    e.printStackTrace();
                }
                skipElement = true;
                return;
            }

            try {
                writer.writeStartElement("", localName);
            } catch (XMLStreamException e) {
                e.printStackTrace();
            }
        }

        public void endElement (String uri, String localName,
            String qName)
            throws SAXException {
            try {
                if(skipElement) {
                    skipElement = false;
                    return;
                }

                writer.writeEndElement();
            } catch (XMLStreamException e) {
                e.printStackTrace();
            }
        }

        public void characters (char ch[], int start, int length)
            throws SAXException {
            try {
                writer.writeCharacters(ch, start, length);
            } catch (XMLStreamException e) {
                e.printStackTrace();
            }
        }

        public void ignorableWhitespace (char ch[], int start, int length)
            throws SAXException {
        }

        public void processingInstruction (String target, String data)
            throws SAXException {
        }

        public void skippedEntity (String name)
            throws SAXException {
        }
    }
}
