package servlet;
import javax.servlet.jsp.tagext.*;
import javax.servlet.jsp.*;
import java.io.*;
public class mytag extends SimpleTagSupport{
	private boolean flag;
	public boolean getFlag(){
		return flag;
	}
	public void setFlag(boolean f){
		flag=f;
	}
	public void doTag() throws JspException,IOException{
		getJspContext().setAttribute("flag", flag);
		getJspBody().invoke(null);
	}
}
