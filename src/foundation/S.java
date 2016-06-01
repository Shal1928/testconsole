package foundation;

/**
 *
 */
public class S  {

    private StringBuilder builder = new StringBuilder();

    public S a(String s) {
        builder.append(s);
        return this;
    }

    @Override public String toString() {
        return builder.toString();
    }
}
