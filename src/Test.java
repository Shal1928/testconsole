import others.TestEnum;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import java.io.File;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.util.LinkedList;

/**
 *
 */
public class Test {

    static int p = method();
    static int q = 10;

    private static int method() {
        return p;
    }

    public static void main(String[] args) throws IOException, ClassNotFoundException, NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException, ParseException {

        try {
            GeneralSettings gs = new GeneralSettings();
            LinkedList<String> ls = new LinkedList<String>();
            ls.add("s1");
            ls.add("s2");
            gs.setObjects(ls.toArray());

            gs.setEnumVal(TestEnum.DOC);
            gs.setTypeID(1);

            JAXBContext context = JAXBContext.newInstance(GeneralSettings.class);
            context.createMarshaller().marshal(gs, new File("C:\\test.xml"));

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
