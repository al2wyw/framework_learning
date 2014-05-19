package servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.*;

/**
 * Servlet implementation class add_session_attributes
 */
@WebServlet("/session_attr")
public class add_session_attributes extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public add_session_attributes() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession hs=request.getSession();
		hs.setAttribute("attribute1", new String("valueOfAttribute1"));
		hs.setAttribute("attribute2", new String("valueOfAttribute2"));
		hs.setAttribute("attribute3", new String("valueOfAttribute3"));
		String[] value=request.getParameter("value").split(",");
		hs.setAttribute(value[0], value[1]);
		System.out.println(request.getParameter("value"));
		getServletContext().getRequestDispatcher("/test_session_value.jsp").forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
