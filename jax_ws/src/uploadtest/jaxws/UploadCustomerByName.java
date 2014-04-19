
package uploadtest.jaxws;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlRootElement(name = "uploadCustomerByName", namespace = "http://uploadtest/")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "uploadCustomerByName", namespace = "http://uploadtest/")
public class UploadCustomerByName {

    @XmlElement(name = "arg0", namespace = "")
    private uploadtest.Customer arg0;

    /**
     * 
     * @return
     *     returns Customer
     */
    public uploadtest.Customer getArg0() {
        return this.arg0;
    }

    /**
     * 
     * @param arg0
     *     the value for the arg0 property
     */
    public void setArg0(uploadtest.Customer arg0) {
        this.arg0 = arg0;
    }

}
