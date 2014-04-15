package mytest;
import java.lang.reflect.*;

//proxy attribute:
//Proxy classes are public, final, and not abstract. 
//The space of class names that begin with the string "$Proxy" should be, however, reserved for proxy classes. 
//A proxy class extends java.lang.reflect.Proxy. 
//The java.security.ProtectionDomain of a proxy class is the same as that of system classes loaded by the bootstrap class loader,
//duplicate methods:
//when a duplicate method is invoked on a proxy instance, the Method object for the method in the foremost interface that contains the method (either directly or inherited through a superinterface) in the proxy class's list of interfaces
//hashCode, equals, or toString methods of java.lang.Object, when such a method is invoked on a proxy instance, the Method object passed to the invocation handler will have java.lang.Object as its declaring class

interface creature{
	void speak() throws Exception;
	String toString();
}
class student implements creature{
	public void speak(){
		System.out.println("Student can speak...");
	}
}
class chief implements creature{
	public void speak() throws ClassNotFoundException{
		System.out.println("Chief can speak...");
	}
}
class nurse implements creature{
	private int i;
	private String s;
	public void speak(){
		System.out.println("Nurse can speak...");
	}
	public String toString(){
		return "this is nurse string";
	}
	public nurse(){}
	public nurse(int i,String s){}
}
//factory+reflection
class Person {
	public static creature getInstance(String person) throws InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException{
		if(person != null){
			person="mytest."+person;
			try{
				Class<?> clazz=Class.forName(person);
				Constructor<creature> con=(Constructor<creature>) clazz.getConstructor(int.class,String.class);
				creature x=(creature)con.newInstance(1,"test");
				return x;
			}catch(ClassNotFoundException e){
				e.printStackTrace();
			}
		}
		return null;
	}
}
//proxy
class CreatureProxy implements InvocationHandler {
	private Object o;
	public CreatureProxy(){
		o=null;
	}
	public CreatureProxy(Object o){
		this.o=o;
	}
	public Object getProxyObject()throws Exception{
		return Proxy.newProxyInstance(o.getClass().getClassLoader(),new Class[]{creature.class} ,this);
	}
	public Object invoke(Object p,Method m,Object[] o) throws Exception{
		System.out.println("call the original function");
		System.out.println(m.getDeclaringClass().getName());
		Object ob=m.invoke(this.o, o);
		return ob;
	}
}
public class test_Proxy {

	/**
	 * @param args
	 */
	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		System.out.println(nurse.class.getName());
		creature a=Person.getInstance("nurse");
		a.speak();
		CreatureProxy p=new CreatureProxy(a);
		creature b=(creature)p.getProxyObject();
		b.speak();
		System.out.println(b.toString());
		System.out.println(b instanceof Proxy);
		System.out.println(Proxy.isProxyClass(b.getClass()));
	}

}
