package MTOMUpload;

import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import javax.jws.WebService;
import javax.xml.ws.WebServiceContext;
import javax.annotation.Resource;
import org.apache.log4j.*;
import javax.servlet.http.HttpServletRequest;
import handler.validationHandler;
import javax.xml.ws.handler.*;
@WebService(serviceName = "MTOMCustomerService", portName =
              "MTOMCustomerServicePort", targetNamespace ="http://MTOMUpload/",
endpointInterface = "MTOMUpload.MTOMCustomer")

 
public class MTOMCustomerImpl implements MTOMCustomer {

		 @Resource
		 private WebServiceContext ctx;

         private static Logger log=Logger.getLogger(validationHandler.class);
         public void uploadCustomerByName(Customer customer) {

                   InputStream is = null;

                   OutputStream os = null;

                   try {
                	   		if(ctx!=null){
                	   			MessageContext mctx=ctx.getMessageContext();
                	   			HttpServletRequest request = (HttpServletRequest) mctx.get(MessageContext.SERVLET_REQUEST);
                	   			String s=request.getRemoteAddr();
                	   			log.info("the request from "+s+" is being processed");
                	   		}else{
                	   			log.error("WebServiceContext is null, can not get request infomation");
                	   		}

                            log.info("customer====" + customer.getId() + "  "

                                               + customer.getName());

                            log.info("generate jpg......");

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