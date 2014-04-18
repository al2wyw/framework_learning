
package myws;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the myws package. 
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

    private final static QName _GetPerson_QNAME = new QName("http://myws/", "getPerson");
    private final static QName _GetPersonResponse_QNAME = new QName("http://myws/", "getPersonResponse");
    private final static QName _AllPeople_QNAME = new QName("http://myws/", "allPeople");
    private final static QName _AllPeopleResponse_QNAME = new QName("http://myws/", "allPeopleResponse");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: myws
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link AllPeopleResponse }
     * 
     */
    public AllPeopleResponse createAllPeopleResponse() {
        return new AllPeopleResponse();
    }

    /**
     * Create an instance of {@link AllPeople }
     * 
     */
    public AllPeople createAllPeople() {
        return new AllPeople();
    }

    /**
     * Create an instance of {@link GetPersonResponse }
     * 
     */
    public GetPersonResponse createGetPersonResponse() {
        return new GetPersonResponse();
    }

    /**
     * Create an instance of {@link GetPerson }
     * 
     */
    public GetPerson createGetPerson() {
        return new GetPerson();
    }

    /**
     * Create an instance of {@link Person }
     * 
     */
    public Person createPerson() {
        return new Person();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetPerson }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://myws/", name = "getPerson")
    public JAXBElement<GetPerson> createGetPerson(GetPerson value) {
        return new JAXBElement<GetPerson>(_GetPerson_QNAME, GetPerson.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetPersonResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://myws/", name = "getPersonResponse")
    public JAXBElement<GetPersonResponse> createGetPersonResponse(GetPersonResponse value) {
        return new JAXBElement<GetPersonResponse>(_GetPersonResponse_QNAME, GetPersonResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link AllPeople }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://myws/", name = "allPeople")
    public JAXBElement<AllPeople> createAllPeople(AllPeople value) {
        return new JAXBElement<AllPeople>(_AllPeople_QNAME, AllPeople.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link AllPeopleResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://myws/", name = "allPeopleResponse")
    public JAXBElement<AllPeopleResponse> createAllPeopleResponse(AllPeopleResponse value) {
        return new JAXBElement<AllPeopleResponse>(_AllPeopleResponse_QNAME, AllPeopleResponse.class, null, value);
    }

}
