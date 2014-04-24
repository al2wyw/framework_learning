package test;

import java.net.URL;

import javax.xml.ws.Response;
import myws.*;

public class helloAsyncClient {
	 


	    public static void main(String[] args) throws Exception {

	    	String endPoint="http://10.30.152.147:8080/jax_ws/HelloService?wsdl";
	        HelloService service = new HelloService(new URL(endPoint));
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

