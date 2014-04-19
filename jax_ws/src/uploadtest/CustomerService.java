package uploadtest;

import java.io.FileOutputStream;
import java.io.ByteArrayInputStream;
import java.io.OutputStream;
import java.io.ObjectOutputStream;
import javax.jws.WebService;
import javax.jws.WebMethod;
import java.io.File;

@WebService
public class CustomerService implements CustomerAction{
	@WebMethod
	public void uploadCustomerByName(Customer customer) {

        ByteArrayInputStream is = null;

        OutputStream os = null;

        try {

                 System.out.println("customer====" + customer.getId() + "  "

                                    + customer.getName());

                 System.out.println("generate jpg......");
                 
                 File f = new File(this.getClass().getResource("/").getFile());
                 f=f.getParentFile().getParentFile();
                 String path =f.getAbsolutePath();
                 is = new ByteArrayInputStream(customer.getFile());

                 os = new FileOutputStream(path+"/customer.jpg");

                 byte[] bytes = new byte[1024];

                 int c;

                 while ((c = is.read(bytes)) != -1) {

                          os.write(bytes, 0, c);

                 }
                 
                 ObjectOutputStream fout=new ObjectOutputStream(new FileOutputStream(path+"/people"));
                 fout.writeLong(customer.getId());
                 fout.writeObject(customer.getName());
                 fout.writeObject("customer.jpg");
                 fout.close();
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
