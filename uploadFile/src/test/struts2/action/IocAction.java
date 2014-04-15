package test.struts2.action;
import com.opensymphony.xwork2.*;
import test.struts2.service.*;
import java.util.*;
public class IocAction extends ActionSupport {
	private IocTestInterface iti;
	private List list;
	
	public List getList() {
		return list;
	}
	public void setList(List list) {
		this.list = list;
	}
	public IocTestInterface getIti() {
		return iti;
	}
	public void setIti(IocTestInterface iti) {
		this.iti = iti;
	}
	
	public String execute() throws Exception {
		this.setList(iti.getList());
		return super.execute();
	}
}