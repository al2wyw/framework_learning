package mytest;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

class A{
	public static interface test{
		
	}
	public static int d(){
		System.out.println("A");
		return 1;
	}
}

class B extends A{
	public static int d(){
		System.out.println("D");
		return 1;
	}
}
class C extends A{
	public static void d(String d){
		System.out.println("D");
	}
}
public class testHideStatic {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		B b=new B();
		B.d();
		C c=new C();
		c.d();

	}

}

class simpleSerializableTest {
    public static void main(String[] args) throws Exception {
    	
        ObjectOutputStream out=new ObjectOutputStream(new FileOutputStream("objectFile.obj"));
         
        String strObj="name";
        Customer customer=new Customer("rollen");
        //序列化,此处故意将同一对象序列化2次
        out.writeObject(strObj);
        out.writeObject(customer);
        customer.setName("roll");
        out.writeObject(customer);
        out.close();
        //反序列化
        ObjectInputStream in=new ObjectInputStream(new FileInputStream("objectFile.obj"));
        String strobj1=(String)in.readObject();
        Customer cus1=(Customer)in.readObject();
        Customer cus2=(Customer)in.readObject();
        in.close();
        System.out.println(strobj1+": "+cus1);
        System.out.println(strObj==strobj1);
        System.out.println(cus1==customer);
        System.out.println(cus1==cus2);
        System.out.println(cus1);
        System.out.println(cus2);
    }
}
 
class Customer implements Serializable {
    private static final long serialVersionUID = 1L;
    private String name;
 
    public Customer() {
        System.out.println("无参构造方法");
    }
 
    public Customer(String name) {
        System.out.println("有参构造方法");
        this.name = name;
    }
    
    public final void setName(String s){
    	name = s;
    }
    
    public String toString() {
        return "[ "+name+" ]";
    }
     
}
