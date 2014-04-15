package test;

import java.io.IOException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.io.*;
/**
 * Servlet implementation class param_in_webconf
 */
@WebServlet(urlPatterns =  "/webparam" , 
initParams = @WebInitParam(name = "name", value = "super man coming!")
)


public class param_in_webconf extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public param_in_webconf() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		ServletConfig sc=getServletConfig();
		String name=sc.getInitParameter("name");
		response.setContentType("text/html");
		PrintWriter pout=response.getWriter();
		pout.println("<html><body>");
		if(name==null){
			pout.println("<h1>no paramters!</h1>");
		}else
			pout.println("<h1>"+name+"</h1>");
		pout.println("</body></html>");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
