import javafx.print.Collation;
import org.junit.Test;

import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import others.ListRecord;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.xpath.*;
import java.io.InputStream;
import java.lang.reflect.Array;
import java.text.MessageFormat;
import java.util.Arrays;
import java.util.Collection;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


/**
 *
 */
public class TIsForTest {

//    private static Pattern PATTERN = Pattern.compile("(?:\\$\\{([^${}]+)\\})+?");
    private static Pattern PATTERN = Pattern.compile("\\$\\{(.*?)\\}");

    @Test
    public void main() {
        try {
            Matcher matcher = PATTERN.matcher("sdf_${ATTR1}_dsfsd${ATTR2}${ATTR3}");

            StringBuffer sb = new StringBuffer();
            while (matcher.find()) {
                matcher = matcher.appendReplacement(sb, matcher.group(1));
            }

            System.out.println(sb);
        } catch (Throwable e) {
            System.out.println(e);
        }
    }
}
