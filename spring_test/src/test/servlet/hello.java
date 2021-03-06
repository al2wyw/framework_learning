package test.servlet;

import java.io.IOException;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import test.service.impl.Hellomessage;
import org.springframework.context.support.GenericXmlApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;
import org.springframework.web.context.WebApplicationContext;
/**
 * Servlet implementation class hello
 */
public class hello extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private String path;   
    /**
     * @see HttpServlet#HttpServlet()
     */
    public hello() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Servlet#init(ServletConfig)
	 */
	public void init(ServletConfig config) throws ServletException {
		// TODO Auto-generated method stub
		path=config.getServletContext().getInitParameter("contextConfigLocation");
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
//		GenericXmlApplicationContext ac=new GenericXmlApplicationContext();
//		ac.load(path);
//		ac.refresh();
		//too complex to use genericxmlcontext
//		Hellomessage test=ac.getBean("hello",Hellomessage.class);
		
		WebApplicationContext wc=WebApplicationContextUtils.getWebApplicationContext(request.getServletContext());
		Hellomessage test=wc.getBean("hello",Hellomessage.class);
		request.setAttribute("hello",test.getMessage());
		request.getRequestDispatcher("hello.jsp").forward(request, response);
//		ac.close();
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
