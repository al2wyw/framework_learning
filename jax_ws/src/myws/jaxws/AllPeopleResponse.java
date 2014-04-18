
package myws.jaxws;

import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlRootElement(name = "allPeopleResponse", namespace = "http://myws/")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "allPeopleResponse", namespace = "http://myws/")
public class AllPeopleResponse {

    @XmlElement(name = "return", namespace = "")
    private List<myws.person> _return;

    /**
     * 
     * @return
     *     returns List<person>
     */
    public List<myws.person> getReturn() {
        return this._return;
    }

    /**
     * 
     * @param _return
     *     the value for the _return property
     */
    public void setReturn(List<myws.person> _return) {
        this._return = _return;
    }

}
