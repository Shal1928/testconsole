import com.filenet.api.constants.TypeID;
import others.TestEnum;

import javax.xml.bind.annotation.*;
import java.util.Date;

@XmlRootElement(name = "GeneralSettings")
@XmlType(propOrder = {"value", "enumVal", "objects", "typeID"})
@XmlAccessorOrder(XmlAccessOrder.ALPHABETICAL)
public class GeneralSettings {

    @XmlAttribute(name = "TypeID", required = true)
    public int getTypeID() {
        return typeID;
    }

    public void setTypeID(int typeID) {
        this.typeID = typeID;
    }


    public TypeID getTypeIDValue(){
        return TypeID.getInstanceFromInt(typeID);
    }


    private int typeID;


    private String value;

    @XmlAttribute(name = "Value", required = true)
    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    private TestEnum enumVal;

    @XmlAttribute(name = "Enumka", required = true)
    public TestEnum getEnumVal() {
        return enumVal;
    }

    public void setEnumVal(TestEnum enumVal) {
        this.enumVal = enumVal;
    }

//    @XmlElementWrapper(name = "Objects")
    @XmlElements(
            {
                    @XmlElement(name = "str", type = String.class),
                    @XmlElement(name = "int", type = Integer.class),
                    @XmlElement(name = "dou", type = Double.class),
                    @XmlElement(name = "flo", type = Float.class),
                    @XmlElement(name = "lon", type = Long.class),
                    @XmlElement(name = "dat", type = Date.class)
            }
    )
    public Object[] getObjects() {
        return objects;
    }

    public void setObjects(Object[] objects) {
        this.objects = objects;
    }

    private Object[] objects;
}
