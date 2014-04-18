
package myws.jaxws;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlRootElement(name = "getPerson", namespace = "http://myws/")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "getPerson", namespace = "http://myws/")
public class GetPerson {

    @XmlElement(name = "arg0", namespace = "")
    private myws.person arg0;

    /**
     * 
     * @return
     *     returns person
     */
    public myws.person getArg0() {
        return this.arg0;
    }

    /**
     * 
     * @param arg0
     *     the value for the arg0 property
     */
    public void setArg0(myws.person arg0) {
        this.arg0 = arg0;
    }

}
