package others;

/**
 *
 */
public class QueueKey {

    private Long key;
    private boolean isTaken;

    public QueueKey(long key) {
        this.key = key;
        this.isTaken = false;
    }

    public long getKey() {
        return key;
    }

    public boolean isTaken() {
        return isTaken;
    }

    public void take(){
        this.isTaken = true;
    }

    public void finish(){
        this.key = this.key * -1;
    }

    public boolean isFinished(){
        return this.key < 0;
    }

    @Override
    public int hashCode() {
        return key.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        if(obj == null) return false;
        if(!(obj instanceof QueueKey)) return false;

        QueueKey other = (QueueKey) obj;
        return Math.abs(this.key.longValue()) == Math.abs(other.key.longValue());
    }
}
