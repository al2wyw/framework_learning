package test.service.impl;
import test.service.messageProvider;
import test.model.*;

public class Hellomessage implements messageProvider {
	private person object;
	@Override
	public String getMessage() {
		// TODO Auto-generated method stub
		StringBuilder sb=new StringBuilder(100);
		sb.append("Id : "+object.getId()+"\n");
		sb.append("First name : "+object.getFirstName()+"\n");
		sb.append("Last name : "+object.getLastName()+"\n");
		sb.append("Sex : "+object.getSex()+"\n");
		return sb.toString();
	}

	public person getObject() {
		return object;
	}
	public void setObject(person object) {
		this.object = object;
	}
	
}
