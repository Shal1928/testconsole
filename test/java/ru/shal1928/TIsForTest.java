package ru.shal1928;

import org.junit.Test;

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
