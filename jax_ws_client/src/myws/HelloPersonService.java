package myws;

import java.net.MalformedURLException;
import java.net.URL;
import javax.xml.namespace.QName;
import javax.xml.ws.Service;
import javax.xml.ws.WebEndpoint;
import javax.xml.ws.WebServiceClient;
import javax.xml.ws.WebServiceException;
import javax.xml.ws.WebServiceFeature;

//import java.util.Properties;
import java.io.FileReader;

import javax.xml.stream.*;
import javax.xml.stream.events.XMLEvent;
import javax.xml.stream.events.Attribute;
/**
 * This class was generated by the JAX-WS RI.
 * JAX-WS RI 2.2.4-b01
 * Generated source version: 2.2
 * 
 */
@WebServiceClient(name = "helloPersonService", targetNamespace = "http://myws/", wsdlLocation = "http://localhost:8080/jax_ws/HelloPersonService?wsdl")
public class HelloPersonService
    extends Service
{

    private final static URL HELLOPERSONSERVICE_WSDL_LOCATION;
    private final static WebServiceException HELLOPERSONSERVICE_EXCEPTION;
    private final static QName HELLOPERSONSERVICE_QNAME = new QName("http://myws/", "helloPersonService");

    static {
        URL url = null;
        WebServiceException e = null;
        String s = null;
        try {
        	try{
//        		Properties pro=new Properties();
//        		pro.load(new FileReader(HelloPersonService.class.getResource("location.properties").getFile()));
//        		s = pro.getProperty("URL");
//        		System.out.println(s);
        		
        		XMLInputFactory factory = XMLInputFactory.newInstance();
        		FileReader fileReader = new FileReader(HelloPersonService.class.getResource("HelloPersonService.wsdl").getFile()); 
        		XMLEventReader reader = factory.createXMLEventReader(fileReader);
        		while(reader.hasNext()){
        			XMLEvent event = reader.nextEvent();
        			if(event.isStartElement()){
        				
        				QName q=new QName("location");
        				Attribute att=event.asStartElement().getAttributeByName(q);
        				if(att!=null){
        				s=att.getValue();
        				System.out.println("xml from: "+s);
        				
        				}
        			}
        		}
        		
        	}catch(Exception exx){
        		exx.printStackTrace();
        	}
//            url = new URL("http://localhost:8080/jax_ws/HelloPersonService?wsdl");
        	url = new URL(s);
        } catch (MalformedURLException ex) {
            e = new WebServiceException(ex);
        }
        HELLOPERSONSERVICE_WSDL_LOCATION = url;
        HELLOPERSONSERVICE_EXCEPTION = e;
    }

    public HelloPersonService() {
        super(__getWsdlLocation(), HELLOPERSONSERVICE_QNAME);
    }

    public HelloPersonService(WebServiceFeature... features) {
        super(__getWsdlLocation(), HELLOPERSONSERVICE_QNAME, features);
    }

    public HelloPersonService(URL wsdlLocation) {
        super(wsdlLocation, HELLOPERSONSERVICE_QNAME);
    }

    public HelloPersonService(URL wsdlLocation, WebServiceFeature... features) {
        super(wsdlLocation, HELLOPERSONSERVICE_QNAME, features);
    }

    public HelloPersonService(URL wsdlLocation, QName serviceName) {
        super(wsdlLocation, serviceName);
    }

    public HelloPersonService(URL wsdlLocation, QName serviceName, WebServiceFeature... features) {
        super(wsdlLocation, serviceName, features);
    }

    /**
     * 
     * @return
     *     returns HelloPerson
     */
    @WebEndpoint(name = "helloPersonPort")
    public HelloPerson getHelloPersonPort() {
        return super.getPort(new QName("http://myws/", "helloPersonPort"), HelloPerson.class);
    }

    /**
     * 
     * @param features
     *     A list of {@link javax.xml.ws.WebServiceFeature} to configure on the proxy.  Supported features not in the <code>features</code> parameter will have their default values.
     * @return
     *     returns HelloPerson
     */
    @WebEndpoint(name = "helloPersonPort")
    public HelloPerson getHelloPersonPort(WebServiceFeature... features) {
        return super.getPort(new QName("http://myws/", "helloPersonPort"), HelloPerson.class, features);
    }

    private static URL __getWsdlLocation() {
        if (HELLOPERSONSERVICE_EXCEPTION!= null) {
            throw HELLOPERSONSERVICE_EXCEPTION;
        }
        return HELLOPERSONSERVICE_WSDL_LOCATION;
    }

}
