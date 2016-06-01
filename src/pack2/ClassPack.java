package pack2;

import ru.blogic20.easy_java_development_kit.misc.JARHelper;

/**
 *
 */
public class ClassPack {

    public static String get(){
        return JARHelper.getClassLocation(ClassPack.class).toString();
    }
}
