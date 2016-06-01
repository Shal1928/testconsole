package others;

import java.util.*;

import static ru.blogic20.easy_subscription_development_kit.filenet.ce.parts.LogMessageHelper.f;

/**
 *
 */
public class Synchronised {

    private LinkedList<String> value = new LinkedList<String>();

    public static Map<QueueKey, Collection<Integer>> getMap() {
        return map;
    }

    private static Map<QueueKey, Collection<Integer>> map;

    public synchronized void test(String name){
        for(int i=0;i<10;i++){
            value.add(name + " :: "+i+" - from value");
            SOP.print(name + " :: "+i);
            try{
                Thread.sleep(50);
            }
            catch (Exception e){
                SOP.print(e.getMessage());
            }
        }

        for(String i:value)
            SOP.print(i);
    }

    public static void main(String[] args){
        map = new HashMap<QueueKey, Collection<Integer>>();

        QueueKey key1 = new QueueKey(1);
        map.put(key1, new HashSet<Integer>());
        map.get(key1).add(1);
        map.get(key1).add(11);
        map.get(key1).add(111);
        map.get(key1).add(1111);
        map.get(key1).add(11111);

        QueueKey key2 = new QueueKey(2);
        map.put(key2, new HashSet<Integer>());
        map.get(key2).add(2);
        map.get(key2).add(22);
        map.get(key2).add(222);
        map.get(key2).add(2222);
        map.get(key2).add(22222);

        QueueKey key3 = new QueueKey(3);
        map.put(key3, new HashSet<Integer>());
        map.get(key3).add(3);
        map.get(key3).add(33);
        map.get(key3).add(333);
        map.get(key3).add(3333);
        map.get(key3).add(33333);

        SOP.print("\n");
        for(QueueKey key:map.keySet()){
            new TestThread(key, map.get(key));
        }
    }


}
