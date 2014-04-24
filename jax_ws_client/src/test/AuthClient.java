package test;

import javax.xml.ws.handler.Handler;
import javax.xml.ws.handler.HandlerResolver;
import javax.xml.ws.handler.PortInfo;

import serviceimpl.*;
import java.net.*;
import java.util.*;
public class AuthClient {

         public static void main(String[] args) {
        	 
        	 String endPoint =
        			
        			 "http://10.30.152.147:8080/jax_ws/UserAuthorizationService?wsdl";
        	 try{
        	 URL u=new URL(endPoint);
        	 UserAuthorizationService service = new UserAuthorizationService(u);

                   service.setHandlerResolver(new HandlerResolver() {

                            public List<Handler> getHandlerChain(PortInfo arg0) {

                                     List<Handler> handlerList = new ArrayList<Handler>();

                                     handlerList.add(new Authhandler());

                                     return handlerList;

                            }

                   });

                   UserAuthorization authorService = service.getUserAuthorizationPort();

                   String msg = authorService.sayHello("MK");

                   System.out.println("rtn msg=====" + msg);

         }catch(Exception e){
        	 e.printStackTrace();
         }
         }

}
