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

    public static final String CONST = "Const yes!";

    public static Object checkNull = null;

    public Test() {
        checkNull = new Object();
    }

    public static String staticMethod() {
        return "Static method yes!";
    }

    public static boolean isNull() {
        return checkNull == null;
    }

    public static void main(String[] args) throws IOException, ClassNotFoundException, NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException, ParseException {

        try {
            //1
            Test nullObj = null;
            System.out.println(nullObj.CONST);
            System.out.println(nullObj.staticMethod());
            //2
            System.out.println(((Test) null).CONST);
            System.out.println(((Test) null).staticMethod());

            Test test = new Test();
            System.out.println(test.isNull());

            Test test1 = null;
            System.out.println(test.isNull());

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
