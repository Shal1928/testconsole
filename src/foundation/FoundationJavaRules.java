package foundation;

/**
 *
 */
public class FoundationJavaRules {

    public static String sign(int i) {
        if(i == 0) return "=";
        if(i > 0) return ">";

        return "<";
    }

    public static String f(String... parts) {
                StringBuilder result = new StringBuilder();
        if(parts != null) {
            for(String p:parts) {
                result.append(p);
            }
        }

        return result.toString();
    }
}
