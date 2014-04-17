package test;

import javax.xml.ws.Response;
import myws.*;

public class helloAsyncClient {
	 


	    public static void main(String[] args) throws Exception {

	        HelloService service = new HelloService();
	        Hello port = service.getHelloPort();
	        Response<NameResponse> nameAsync = port.nameAsync("Peter");

	        while (!nameAsync.isDone()) {

	            System.out.println("is not down");

	        }

	        try {

	            NameResponse callNameResponse = nameAsync.get();

	            String message = callNameResponse.getReturn();

	            System.out.println(message);

	        } catch (Exception ex) {

	        }

	    }

	 

}

