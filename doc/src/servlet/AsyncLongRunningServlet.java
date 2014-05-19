package servlet;

import java.io.IOException; 
import mytest.AsyncRequestProcessor;
import mytest.AppAsyncListener;
import javax.servlet.AsyncContext; 
import javax.servlet.ServletException; 
import javax.servlet.annotation.WebServlet; 
import javax.servlet.http.HttpServlet; 
import javax.servlet.http.HttpServletRequest; 
import javax.servlet.http.HttpServletResponse; 
import java.util.Date;
@WebServlet("/async") 
public class AsyncLongRunningServlet extends HttpServlet { 
    private static final long serialVersionUID = 1L; 
 
    protected void doGet(HttpServletRequest request, 
            HttpServletResponse response) throws ServletException, IOException { 
        long startTime = System.currentTimeMillis();
        Date current=new Date(startTime);
        System.out.println(current+" AsyncLongRunningServlet Start::Name=" 
                + Thread.currentThread().getName() + "::ID=" 
                + Thread.currentThread().getId()); 
 
        request.setAttribute("org.apache.catalina.ASYNC_SUPPORTED", true); 
 
        String time = request.getParameter("time"); 
        int secs = Integer.valueOf(time); 
        // 如果超过10秒则设置为10秒 
        if (secs > 10000) 
            secs = 10000; 
 
        AsyncContext asyncCtx = request.startAsync(); 
        asyncCtx.addListener(new AppAsyncListener()); 
        asyncCtx.setTimeout(9000); 
        asyncCtx.start(new AsyncRequestProcessor(asyncCtx, secs)); 
        //asyncCtx.dispatch();//loop
//        try{
//        	Thread.sleep(3000);
//        }catch(Exception e){
//        	e.printStackTrace();
//        }
        
        long endTime = System.currentTimeMillis(); 
        current=new Date(endTime);
        System.out.println(current+" AsyncLongRunningServlet End::Name=" 
                + Thread.currentThread().getName() + "::ID=" 
                + Thread.currentThread().getId() + "::Time Taken=" 
                + (endTime - startTime) + " ms."); 
    } 
 
} 
