
package myws.jaxws;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlRootElement(name = "getPersonResponse", namespace = "http://myws/")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "getPersonResponse", namespace = "http://myws/")
public class GetPersonResponse {

    @XmlElement(name = "return", namespace = "")
    private myws.person _return;

    /**
     * 
     * @return
     *     returns person
     */
    public myws.person getReturn() {
        return this._return;
    }

    /**
     * 
     * @param _return
     *     the value for the _return property
     */
    public void setReturn(myws.person _return) {
        this._return = _return;
    }

}
