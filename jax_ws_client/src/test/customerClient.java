package test;

import uploadtest.*;
import javax.xml.ws.soap.MTOMFeature;
import java.io.FileInputStream;

public class customerClient {

	public static void main(String[] args) {
		byte[] file = null;
		try{
		FileInputStream fin=new FileInputStream("ans.jpg");
		long len=fin.available();
		System.out.println(len);
		file=new byte[(int)len];
		fin.read(file);
		fin.close();
		}catch(Exception e){
			e.printStackTrace();
		}
		Customer cus=new Customer();
		cus.setName("peter");
		cus.setId(56784556L);
		cus.setFile(file);
		CustomerServiceService service = new CustomerServiceService();
		CustomerService port = service.getCustomerServicePort(new MTOMFeature());
		port.uploadCustomerByName(cus);
	}

}
