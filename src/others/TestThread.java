package others;

import java.util.Collection;

import static ru.blogic20.easy_subscription_development_kit.filenet.ce.parts.LogMessageHelper.f;

/**
 *
 */
public class TestThread extends Thread {
    QueueKey key;
    Collection<Integer> collection;


    public TestThread(QueueKey key, Collection<Integer> collection){
        this.key = key;
        this.collection = collection;
        start();
    }

    @Override
    public void run(){
        key.take();
        String keyStr = f("Key: {0} IsTaken: {1} IsFinished: {2}", key.getKey(), key.isTaken(), key.isFinished());
        for(int i:collection){
            SOP.print(f("{0} - {1}", keyStr, i));
        }
        key.finish();
        SOP.print("\n");
    }
}

