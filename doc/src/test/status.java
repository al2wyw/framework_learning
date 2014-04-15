package test;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
/**
 * Servlet implementation class status
 */
@WebServlet("/status")
public class status extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */

    public void init() throws ServletException{
    	
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
//		ServletInputStream sin=request.getInputStream();
//		byte[] re=new byte[100];
//		if(sin.read(re,0,100)!=0)
//		System.out.println(bytesToHexString(re));
//		System.out.println((char)re[0]);
		String code=request.getParameter("code");
		if(code!=null && !code.trim().equals("")){
			if(code.startsWith("3")){
			try{
				response.setStatus(Integer.valueOf(code));
				response.setHeader("Location", "/doc/status_view.jsp?status="+code);
			}catch(Exception e){
				e.printStackTrace();
			}
			}else{
//				System.setProperty("file.encoding", "UTF-8");
				System.out.println(System.getProperty("file.encoding"));
				if(code.equals("神奇"))
					System.out.println("good");
				System.out.println(code);
				System.out.println(code.length());
				
				System.out.println(java.net.URLEncoder.encode("神奇","UTF-8"));
				
				String t=java.net.URLEncoder.encode(code,"UTF-8");
				System.out.println(t);
				System.out.println("神奇");
				response.sendRedirect(response.encodeRedirectURL("/doc/status_view.jsp?status="+t));
				//server will decode the encoded url which can be transmitted on the internet , we encode the result to recover it to encoded url 
				//which can be transmitted on the internet
			}
		}
				
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request,response);
	}

}
