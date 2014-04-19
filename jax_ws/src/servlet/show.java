package servlet;

import java.io.File;
import java.io.IOException;
import java.io.FileInputStream;
import java.io.ObjectInputStream;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class show
 */
public class show extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public show() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		File f = new File(this.getClass().getResource("/").getFile());
        f=f.getParentFile().getParentFile();
        String path =f.getAbsolutePath();
		path=path+"/people";
		try{
		ObjectInputStream oin=new ObjectInputStream(new FileInputStream(path));
		customer c=new customer();
		c.setId(oin.readLong());
		c.setName((String)oin.readObject());
		c.setPath((String)oin.readObject());
		request.setAttribute("customer", c);
		request.getRequestDispatcher("show.jsp").forward(request, response);
		}catch(Exception e){
			e.printStackTrace();
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
