package others;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Calendar;

/**
 *
 */
public class CacheKey implements Comparable {

    private static final Logger logger = LoggerFactory.getLogger(CacheKey.class);

    private String modelId;
    private String query;
    private Calendar calendar;
    private boolean serviceKey;

    public CacheKey(String modelId, String query) {
        this.modelId = modelId;
        this.query = query;
        this.calendar = Calendar.getInstance();
        this.serviceKey = false;
    }

    public CacheKey(int liveInterval) {
        this.modelId = null;
        this.query = null;
        this.calendar = Calendar.getInstance();
        this.calendar.add(Calendar.MINUTE, -liveInterval);
        this.serviceKey = true;
    }

    public String getModelId() {
        return modelId;
    }

    public String getQuery() {
        return query;
    }

    public Calendar getCalendar() {
        return calendar;
    }

    public boolean isServiceKey() {
        return serviceKey;
    }

    @Override public int hashCode() {
        logger.trace("enter - hashCode()", new Object[]{});
        int result = getModelId() != null ? getModelId().hashCode() : 0;
        result = 31 * result + (getQuery() != null ? getQuery().hashCode() : 0);
        logger.trace("exit - hashCode():{}", result);
        return result;
    }

    @Override public boolean equals(Object o) {
        logger.trace("enter - equals(o = [{}])", new Object[]{o});

        boolean result = false;
        try {
            if (this == o) {
                result = true;
                return result;
            }

            if (!(o instanceof CacheKey)) {
                result = false;
                return result;
            }

            CacheKey otherKey = (CacheKey) o;

            //region getModelId Eq
            if (getModelId() != null) {
                result = getModelId().equals(otherKey.getModelId());
            } else {
                result = otherKey.getModelId() != null;
            }

            if (!result) {
                return result;
            }
            //endregion

            result = getQuery() != null ?
                getQuery().equals(otherKey.getQuery()) :
                otherKey.getQuery() == null;
            return result;
        } finally {
            logger.trace("exit - equals():{}", result);
        }
    }

    @Override public int compareTo(Object o) {
        logger.trace("enter - compareTo(o = [{}])", new Object[]{o});
        CacheKey otherKey = (CacheKey) o;
        //Если ключи по методу equals == true, возвращаем результат сравнения 0, иначе используем compareTo по дате
        int result = 0;
        if(!this.equals(otherKey)) {
            result = getCalendar().compareTo(otherKey.getCalendar());
            result = result == 0 ? 1 : result;
        }

        logger.trace("exit - compareTo():{}", result);
        return  result;
    }
}
