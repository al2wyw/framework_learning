package test;
import javax.servlet.jsp.tagext.*;
import javax.servlet.jsp.*;
import java.io.*;

public class myelse extends SimpleTagSupport {

	public void doTag() throws JspException,IOException{
		mytag tag=null;
		try{
			tag=(mytag)getParent();
		}catch(Exception e){
			e.printStackTrace();
		}
		if(tag!=null&&!tag.getFlag()){
			getJspBody().invoke(null);
		}
	}

}
