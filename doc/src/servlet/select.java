package servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;
import java.util.*;
/**
 * Servlet implementation class select
 */
@WebServlet("/select/*")
public class select extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public select() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String[] select=request.getParameterValues("select");
		response.setContentType("text/html");
		response.setDateHeader("Expires", new Date().getTime());
		PrintWriter pout=response.getWriter();
		pout.println("<!DOCTYPE html><html><body><h1>");
		for(int i=0,j=select.length;i<j;i++){
		pout.println("The option selected is "+ select[i]);
		}
		pout.println("</h1>" + request.getPathInfo()+
				"</body></html>");
		System.out.println(request.getPathInfo());
		System.out.println(request.getPathTranslated());
	}

}
