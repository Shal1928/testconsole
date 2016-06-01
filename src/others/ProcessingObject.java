package others;

import com.filenet.api.core.ObjectStore;

/**
 *
 */
public class ProcessingObject<T extends HardObj> {

    private T object;

    private boolean isFinished;
    private boolean isMoveToErrorFolder;
    private ObjectStore os;

    /**
     * Конструктор только для объекто Relationship
     * @param object extends Relationship
     */
    public ProcessingObject(T object) {
        init(object, false, false);
    }

    private void init(T object, boolean isFinished, boolean isMoveToErrorFolder){
        this.object = object;
        this.isFinished = false;
        this.isMoveToErrorFolder = false;
    }


    public T get() {
        return object;
    }


    public boolean isFinished() {
        return isFinished;
    }

    public void setFinished() {
        this.isFinished = true;
    }

    public boolean isMoveToErrorFolder() {
        return isMoveToErrorFolder;
    }

    public void setMoveToErrorFolder() {
        this.isMoveToErrorFolder = true;
    }

    @Override
    public int hashCode() {
        return get().id.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        ProcessingObject hObj = (ProcessingObject)obj;
        return hObj != null &&  hObj.get().id != null && hObj.get().id.equals(this.get().id);
    }
}
