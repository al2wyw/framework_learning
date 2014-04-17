package test;

import com.eutesttools.*;

public class addClient {

	 public static void main(String[] args) throws Exception {

		 	EUWS service = new EUWS();
	        EUWSSoap port = service.getEUWSSoap();
	        double result = port.add(34D, 46D);


	        System.out.println(result);

	    }

}


