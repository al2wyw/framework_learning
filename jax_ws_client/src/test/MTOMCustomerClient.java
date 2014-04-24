package test;

import java.net.URL;
import javax.activation.DataHandler;
import javax.activation.FileDataSource;

import mtomupload.*;
import javax.xml.ws.soap.MTOMFeature;
public class MTOMCustomerClient {

         public static void main(String[] args) {

                   // TODO Auto-generated method stub

                   Customer customer = new Customer();

                   String endPoint =

 "http://10.30.152.147:8080/jax_ws/MTOMCustomerService?wsdl";

                   try {

                            MTOMCustomerService customerService = new MTOMCustomerService(

                                               new URL(endPoint));

                            MTOMCustomer customerPort = customerService

                                               .getMTOMCustomerServicePort(new MTOMFeature());

                            customer.setId(101);

                            customer.setName("mk");

                            customer.setMyPhoto(new DataHandler(new FileDataSource(

                                               "ans.jpg")));

                            customerPort.uploadCustomerByName(customer);

                   } catch (Exception e) {

                            e.printStackTrace();

                   }

         }

}
