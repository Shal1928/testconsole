package others;

/**
 *
 */
public enum DataType {

    INTEGER, DATE, STRING, FLOAT, DOUBLE, BOOLEAN, LONG, BINNARY, GUID, OBJECT;

    private static final org.slf4j.Logger logger = org.slf4j.LoggerFactory.getLogger(DataType.class);

    /**
     * Определяет значение DataType по строке (регистронезависимо).
     * @param value Строка по которой следует определить DataType
     * @return Значение DataType соответствующее строке
     */
    public static DataType valueFrom(String value) {
        logger.trace("enter - define(value = [{}])", new Object[]{value});

        DataType result = null;
        for(DataType t : values()) {
            if (t.name().equalsIgnoreCase(value)) {
                result = t;
                break;
            }
        }

        logger.trace("exit - define():{}", result);
        return result;
    }
}
