package servlet;

import java.io.CharArrayWriter;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpServletResponseWrapper;

public class myWrapper extends HttpServletResponseWrapper{
	private CharArrayWriter cwriter=new CharArrayWriter();
	//private ByteArrayOutputStream bout=new ByteArrayOutputStream();
	public myWrapper(HttpServletResponse res){
		super(res);
	}
	public PrintWriter getWriter(){
		PrintWriter pout=new PrintWriter(cwriter);
		return pout;
	}
	/*
	public ServletOutputStream getOutputStream(){
		OutputStream out=bout;
		return (ServletOutputStream)out;
	}
	*/
	public String getString(){
		return cwriter.toString();
	}
}
