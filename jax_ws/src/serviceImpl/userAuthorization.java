package serviceImpl;

import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.jws.HandlerChain;


@WebService
@HandlerChain(file = "handlers.xml")
public class userAuthorization implements service.authorize{

	@Override
	@WebMethod
	public String sayHello(String name) {
		// TODO Auto-generated method stub
		return null;
	}

}
