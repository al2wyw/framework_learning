package test;

import javax.xml.ws.AsyncHandler;
import javax.xml.ws.Response;
import myws.*;

public class helloCallbackClient {


    public static void main(String[] args) throws Exception {

        HelloService service = new HelloService();

        Hello port = service.getHelloPort();

        port.nameAsync("Anne", new AsyncHandler<NameResponse>() {

            public void handleResponse(Response<NameResponse> res) {

                try {

                    NameResponse response = null;

                    response = res.get();

                    String message = response.getReturn();

                    System.out.println(message);

                } catch (Exception e) {

                    e.printStackTrace();

                }

            }

        });

        Thread.sleep(1000);

    }
}
