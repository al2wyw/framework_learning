package mytest;

import java.io.*;
//base class implements serializable and then its child class will be serializable!
class baseclass {
	private int h;
	public int getH() {
		return h;
	}

	public void setH(int h) {
		this.h = h;
	}

	public baseclass(int h) {
		super();
		this.h = h;
	}
	public baseclass(){ //deserialize will call this constructor to create this instance
		super();
	}
}
class myclass extends baseclass implements Serializable{

	private static final long serialVersionUID = 1L;
	private com c = new com();
	public int i;
	public myclass(int h){
		super(h);
	}
	public String toString(){
		return c.name + " " + getH();
	}
}

class com implements Serializable{ //must implements Serializable
	protected String name="test";
	
}

class test_read_write implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -3977814629666252172L;
	private int i = 10;
	private void writeObject(ObjectOutputStream out) throws IOException{
		out.defaultWriteObject();
		System.out.println("test output");
	}
	private void readObject(ObjectInputStream in) throws IOException,ClassNotFoundException{
		in.defaultReadObject();
		System.out.println("test input");
	}
	public String toString(){
		String a="testfortest";
		return a+i;
	}
}
public class testSerializable {

	/**
	 * @param args
	 */
	public static void main(String[] args) throws IOException,ClassNotFoundException{
		FileOutputStream fout=new FileOutputStream("test.dat");
		ObjectOutputStream oout=new ObjectOutputStream(fout);
		myclass test=new myclass(999);
		System.out.println(test);
		oout.writeObject(test);
		test_read_write rw=new test_read_write();
		System.out.println(rw);
		oout.writeObject(rw);
		oout.close();
		FileInputStream fin=new FileInputStream("test.dat");
		ObjectInputStream oin=new ObjectInputStream(fin);
		myclass t=(myclass)oin.readObject();
		test_read_write rwt=(test_read_write)oin.readObject();
		System.out.println(t);
		System.out.println(rwt);
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
    private Object readReslove(){
    	return null;
    }
    public final void setName(String s){
    	name = s;
    }
    
    public String toString() {
        return "[ "+name+" ]";
    }
     
}

class ExternalizableDemo implements Externalizable {
    private String name;
    static {
        System.out.println("调用静态代码块");
    }
 
    public ExternalizableDemo() {
    	name = "test"; //will not affect the deserialize
        System.out.println("调用默认无参构造函数");
    }
 
    public ExternalizableDemo(String name) {
        this.name = name;
        System.out.println("调用有参构造函数");
    }
 
    @Override
    public void writeExternal(ObjectOutput out) throws IOException {
        out.writeObject(name);
    }
 
    @Override
    public void readExternal(ObjectInput in) throws IOException,
            ClassNotFoundException {
        name = (String) in.readObject();
    }
 
    @Override
    public String toString() {
        return "[" + name + "]";
    }
 
    public static void main(String[] args) throws Exception {
        ExternalizableDemo demo = new ExternalizableDemo("rollen");
        ByteArrayOutputStream buf = new ByteArrayOutputStream();
        ObjectOutputStream out = new ObjectOutputStream(buf);
        out.writeObject(demo);
 
        ObjectInputStream in = new ObjectInputStream(new ByteArrayInputStream(
                buf.toByteArray()));
        demo = (ExternalizableDemo) in.readObject();
        System.out.println(demo);
    }
}