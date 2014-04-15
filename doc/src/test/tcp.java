package test;
import java.net.*;
import java.io.*;
import mytest.people;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

/**
 * Application Lifecycle Listener implementation class tcp
 *
 */
@WebListener
public class tcp implements ServletContextListener {

    /**
     * Default constructor. 
     */
    public tcp() {
        // TODO Auto-generated constructor stub
    }

	/**
     * @see ServletContextListener#contextInitialized(ServletContextEvent)
     */
    public void contextInitialized(ServletContextEvent arg0) {
        // TODO Auto-generated method stub
    	System.out.println("test");
    	System.out.println("test");
    	System.out.println("test");
    	System.out.println("test");
    	System.out.println("test");
    	people p=new people();
    	arg0.getServletContext().setAttribute("people", p);
    	final ServletContextEvent e=arg0;
		new Thread(){
			public void run(){
				ServerSocket sock ;
				try{
		    		sock = new ServerSocket(8800);
		    		while(true){
			    		Socket s=sock.accept();
			    		BufferedReader r=new BufferedReader(new InputStreamReader(s.getInputStream(),"UTF-8"),256);
			    		String st=r.readLine();
			    		System.out.println("result is "+st);
			    		people p=(people)e.getServletContext().getAttribute("people");
			    		if(p!=null)
			    			p.setName(st);
			    		r.close();
		    		}
		    	}catch(Exception e){
		    		e.printStackTrace();
		    	}finally{
		    		
		    	}
			}
		}.start();
    }

	/**
     * @see ServletContextListener#contextDestroyed(ServletContextEvent)
     */
    public void contextDestroyed(ServletContextEvent arg0) {
        // TODO Auto-generated method stub
    }
	
}
