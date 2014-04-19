package uploadtest;

import java.io.FileOutputStream;
import java.io.ByteArrayInputStream;
import java.io.OutputStream;

import javax.jws.WebService;
import javax.jws.WebMethod;

@WebService
public class CustomerService {
	@WebMethod
	public void uploadCustomerByName(Customer customer) {

        ByteArrayInputStream is = null;

        OutputStream os = null;

        try {

                 System.out.println("customer====" + customer.getId() + "  "

                                    + customer.getName());

                 System.out.println("generate jpg......");
                 
                 String path = this.getClass().getResource("/").getFile();
                 System.out.println(path);
                 is = new ByteArrayInputStream(customer.getFile());

                 os = new FileOutputStream(path+"customer.jpg");

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
