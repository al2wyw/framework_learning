
package myws;

import java.util.List;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.ws.Action;
import javax.xml.ws.RequestWrapper;
import javax.xml.ws.ResponseWrapper;


/**
 * This class was generated by the JAX-WS RI.
 * JAX-WS RI 2.2.4-b01
 * Generated source version: 2.2
 * 
 */
@WebService(name = "helloPerson", targetNamespace = "http://myws/")
@XmlSeeAlso({
    ObjectFactory.class
})
public interface HelloPerson {


    /**
     * 
     * @return
     *     returns java.util.List<myws.Person>
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "allPeople", targetNamespace = "http://myws/", className = "myws.AllPeople")
    @ResponseWrapper(localName = "allPeopleResponse", targetNamespace = "http://myws/", className = "myws.AllPeopleResponse")
    @Action(input = "http://myws/helloPerson/allPeopleRequest", output = "http://myws/helloPerson/allPeopleResponse")
    public List<Person> allPeople();

    /**
     * 
     * @param arg0
     * @return
     *     returns myws.Person
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "getPerson", targetNamespace = "http://myws/", className = "myws.GetPerson")
    @ResponseWrapper(localName = "getPersonResponse", targetNamespace = "http://myws/", className = "myws.GetPersonResponse")
    @Action(input = "http://myws/helloPerson/getPersonRequest", output = "http://myws/helloPerson/getPersonResponse")
    public Person getPerson(
        @WebParam(name = "arg0", targetNamespace = "")
        Person arg0);

}
