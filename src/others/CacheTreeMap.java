package others;

import java.util.TreeMap;

/**
 *
 */
public class CacheTreeMap<TKey, TValue> extends TreeMap<TKey, TValue> {

    @Override public boolean containsKey(Object key) {
        //Необходимо, т. к. ключ является сложным
        //(одни поля используются для проверки эквивалентности, другие для cортировки).
        //TreeMap при проверке ContainsKey и выполнении put начинает с середины
        //и двигается в сторону результата сравнения
        for(TKey k:keySet()) {
            if(k.equals(key)) {
                return true;
            }
        }

        return false;
    }

    @Override public TValue put(TKey key, TValue value) {
        if(containsKey(key)) {
            return null;
        }

        return super.put(key, value);
    }
}
