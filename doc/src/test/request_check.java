package test;

import javax.servlet.ServletRequestEvent;
import javax.servlet.ServletRequestListener;
import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpServletRequest;

/**
 * Application Lifecycle Listener implementation class request_check
 *
 */
@WebListener
public class request_check implements ServletRequestListener {

    /**
     * Default constructor. 
     */
    public request_check() {
        // TODO Auto-generated constructor stub
    }

	/**
     * @see ServletRequestListener#requestDestroyed(ServletRequestEvent)
     */
    public void requestDestroyed(ServletRequestEvent arg0) {
        // TODO Auto-generated method stub
    }

	/**
     * @see ServletRequestListener#requestInitialized(ServletRequestEvent)
     */
    public void requestInitialized(ServletRequestEvent arg0) {
        // TODO Auto-generated method stub
    	HttpSession ses=((HttpServletRequest)arg0.getServletRequest()).getSession();
    	if(ses!=null){
    		java.util.Date now=new java.util.Date();
    		System.out.println(now+" INFO "+ses.getId());
    	}
    }
	
}
