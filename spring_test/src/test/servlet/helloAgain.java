package test.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import test.service.impl.Hellomessage;
import org.springframework.context.support.*;
/**
 * Servlet implementation class helloAgain
 */
public class helloAgain extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public helloAgain() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		ClassPathXmlApplicationContext wc=new ClassPathXmlApplicationContext("applicationContext.xml");

		Hellomessage test=wc.getBean("hello",Hellomessage.class);
		Hellomessage test1=wc.getBean("hello",Hellomessage.class);
		System.out.println(test+" "+test1);
		try{
			Thread.sleep(3000);
		}catch(Exception e){
			e.printStackTrace();
		}
		request.setAttribute("hello",test.getMessage());
		request.getRequestDispatcher("hello.jsp").forward(request, response);
		wc.close();
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
