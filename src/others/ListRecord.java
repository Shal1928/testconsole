package others;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 */
public class ListRecord implements Serializable {

    /**
     * Id записи .
     */
    private String foreignId;

    /**
     * Дата создания записи.
     */
    private Date createDate;

    /**
     * Дата модификации записи.
     */
    private Date modifyDate;

    /**
     * Список колонок записи, хранящая наименование колонки, ее значение и тип данных.
     */
    private Map<String, Attribute> attributes = new HashMap<String, Attribute>();

    public String getForeignId() {
        return foreignId;
    }

    public void setForeignId(String foreignId) {
        this.foreignId = foreignId;
    }

    public void addAttribute(String attrName, Object value, DataType dataType) {
        attributes.put(attrName.toLowerCase(), new Attribute(value, dataType));
    }

    public Object getAttributeValue(String attrName) {
        String name = attrName.toLowerCase();
        return attributes.containsKey(name) ? attributes.get(name).getValue() : null;
    }

    public List<String> getAttributes() {
        return new ArrayList<String>(attributes.keySet());
    }

    public DataType getAttributeType(String attrName) {
        String name = attrName.toLowerCase();
        return attributes.containsKey(name) ? attributes.get(name).getType() : null;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public Date getModifyDate() {
        return modifyDate;
    }

    public void setModifyDate(Date modifyDate) {
        this.modifyDate = modifyDate;
    }

    static class Attribute implements Serializable {

        private Object value;
        private DataType type;

        public Attribute(Object value, DataType type) {
            this.value = value;
            this.type = type;
        }

        public Object getValue() {
            return value;
        }

        public DataType getType() {
            return type;
        }
    }

    @Override public String toString() {
        return "ListRecord{" +
            "foreignId='" + foreignId + '\'' +
            '}';
    }
}

