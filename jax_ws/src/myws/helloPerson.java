package myws;

import java.util.List;
import java.util.ArrayList;
import javax.jws.*;

@WebService
public class helloPerson {
	private List<person> people;
	@WebMethod
	public List<person> allPeople(){
		return people;
	}
	@WebMethod
	public person getPerson(person sb){
		if(people!=null){
		int i=people.indexOf(sb);
		if(i==-1){
			return null;
		}else{
			return people.get(i);
		}
		}
			return null;
		
	}
	public helloPerson(){
		people=new ArrayList<person>(4);
		person a=new person("peter","abc123",23.43d);
		person b=new person("anne","abc543",53.54d);
		person c=new person("ken","abc234",56.23d);
		person d=new person("sue","abc456",34.23d);
		people.add(a);
		people.add(b);
		people.add(c);
		people.add(d);
	}
}
