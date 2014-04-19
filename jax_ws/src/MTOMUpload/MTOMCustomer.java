package MTOMUpload;

import javax.jws.WebParam; 
import javax.jws.WebService; 
import javax.jws.soap.SOAPBinding;
import javax.xml.ws.soap.MTOM;

@WebService(name="MTOMCustomer") 
@SOAPBinding(style = SOAPBinding.Style.RPC) 
@MTOM
public interface MTOMCustomer {
         public void uploadCustomerByName(@WebParam(name = "customer")Customer customer); 

}
