package test;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.*;
import java.io.PrintWriter;

/**
 * Servlet Filter implementation class replace_xxx
 */
@WebFilter("/responseFilter")


public class replace_xxx implements Filter {

    /**
     * Default constructor. 
     */
    public replace_xxx() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		// TODO Auto-generated method stub
		// place your code here
		myWrapper res=new myWrapper((HttpServletResponse)response);
		// pass the request along the filter chain
		chain.doFilter(request, res);
		System.out.println(response.isCommitted());
		PrintWriter pout=response.getWriter();
		pout.println(res.getHeader("My-Special"));
		pout.println(((HttpServletResponse)response).getHeader("My-Special"));//response is the same one as the response in res
		((HttpServletResponse)response).setHeader("My-Special", "changed by filter");
		String test=res.getString();
		String s=test.replaceAll("xxx", "new words");
		pout.println(s);
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
