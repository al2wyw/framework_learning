package servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;
/**
 * Servlet implementation class login
 */
@WebServlet("/login")
public class login extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public login() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setHeader("Cache-Control", "no-store, no-cache, must-revalidate");
		response.setDateHeader("Expires", -1);
		response.setHeader("Pragma", "no-cache");
		response.setHeader("Content-Type", "text/plain");
		String user=request.getParameter("user");
		if(user==null||user.trim().equals(""))
			throw new RuntimeException("no name");
		String pass=request.getParameter("password");
		if(pass==null||pass.trim().equals(""))
			throw new RuntimeException("no password");
		if(request.getRemoteUser()==null){
			System.out.println("login");
			request.login(user,pass);
		}
		PrintWriter pout=response.getWriter();
		if(request.getRemoteUser()!=null){
			pout.println("good");
		}else{
			pout.println("bad");
		}
			
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
