package test;

import java.io.IOException;
import java.io.*;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class fileStore
 */
@WebServlet("/fileStore")
public class fileStore extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public fileStore() {
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
		int length=request.getContentLength();
		InputStream pin=request.getInputStream();
		int len=10240;
		byte[] buff=new byte[len];
		BufferedInputStream bpin=new BufferedInputStream(pin,len);
		System.out.println(len);
		File f=new File("test.data");
		FileOutputStream fout=new FileOutputStream(f);
		int l=0;
		System.out.println(pin.available());
		/*while(true){
			l=bpin.read(buff,0,len);//len=1024
			if(l==-1)
				break;
			System.out.println(l);
			//System.out.println(bpin.available());
			try{Thread.sleep(500);}catch(Exception e){}
			fout.write(buff,0,l);
		}*/
		fout.close();
		response.setContentType("text/html");
		PrintWriter pout=response.getWriter();
		pout.println("<h1>test</h1>");
	}

}
