package test;

import myws.*;

public class personClient {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		HelloPersonService service = new HelloPersonService();
		HelloPerson port = service.getHelloPersonPort();
		java.util.List<Person> result=port.allPeople();
		if(result!=null){
			for(Person r:result)
			System.out.println(r.getName()+" "+ r.getId()+ " "+r.getSalary());
		}
		Person per=new Person();
		per.setName("perter");
		per.setId("abc123");
		per.setSalary(23.43d);
		Person p=port.getPerson(per);//forget to write compare for person class
		if(p!=null)
			System.out.println("good");
	}

}
