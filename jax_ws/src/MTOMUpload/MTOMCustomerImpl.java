package MTOMUpload;

import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import javax.jws.WebService;

@WebService(serviceName = "MTOMCustomerService", portName =
              "MTOMCustomerServicePort", targetNamespace ="http://fromjava.ws.ctsjavacoe/",
endpointInterface = "ctsjavacoe.ws.fromjava.MTOMCustomer")

 
public class MTOMCustomerImpl implements MTOMCustomer {

         @Override

         public void uploadCustomerByName(Customer customer) {

                   InputStream is = null;

                   OutputStream os = null;

                   try {

                            System.out.println("customer====" + customer.getId() + "  "

                                               + customer.getName());

                            System.out.println("generate jpg......");

                            is = customer.getMyPhoto().getInputStream();

                            os = new FileOutputStream("customer.jpg");

                            byte[] bytes = new byte[1024];

                            int c;

                            while ((c = is.read(bytes)) != -1) {

                                     os.write(bytes, 0, c);

                            }

                   } catch (Exception e) {

                            e.printStackTrace();

                   } finally {

                            try {

                                     if (os != null) {

                                               os.close();

                                               os = null;

                                     }

                            } catch (Exception e) {

                            }

                            try {

                                     if (is != null) {

                                               is.close();

                                               is = null;

                                     }

                            } catch (Exception e) {

                            }

                   }

         }

}