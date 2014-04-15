package test.struts2.service.imp;
import test.struts2.service.*;
import java.util.*;
public class IocTestImpl implements IocTestInterface{
	public List getList() {
		List l = new ArrayList();
		l.add("abc");
		l.add("def");
		l.add("hig");
		return l;
	}
}
