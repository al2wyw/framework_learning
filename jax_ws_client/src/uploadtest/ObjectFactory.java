
package uploadtest;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the uploadtest package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _UploadCustomerByNameResponse_QNAME = new QName("http://uploadtest/", "uploadCustomerByNameResponse");
    private final static QName _UploadCustomerByName_QNAME = new QName("http://uploadtest/", "uploadCustomerByName");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: uploadtest
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link UploadCustomerByName }
     * 
     */
    public UploadCustomerByName createUploadCustomerByName() {
        return new UploadCustomerByName();
    }

    /**
     * Create an instance of {@link UploadCustomerByNameResponse }
     * 
     */
    public UploadCustomerByNameResponse createUploadCustomerByNameResponse() {
        return new UploadCustomerByNameResponse();
    }

    /**
     * Create an instance of {@link Customer }
     * 
     */
    public Customer createCustomer() {
        return new Customer();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link UploadCustomerByNameResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://uploadtest/", name = "uploadCustomerByNameResponse")
    public JAXBElement<UploadCustomerByNameResponse> createUploadCustomerByNameResponse(UploadCustomerByNameResponse value) {
        return new JAXBElement<UploadCustomerByNameResponse>(_UploadCustomerByNameResponse_QNAME, UploadCustomerByNameResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link UploadCustomerByName }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://uploadtest/", name = "uploadCustomerByName")
    public JAXBElement<UploadCustomerByName> createUploadCustomerByName(UploadCustomerByName value) {
        return new JAXBElement<UploadCustomerByName>(_UploadCustomerByName_QNAME, UploadCustomerByName.class, null, value);
    }

}
