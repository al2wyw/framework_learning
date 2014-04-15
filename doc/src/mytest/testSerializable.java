package mytest;

import java.io.Serializable;
import java.io.*;

class myclass implements Serializable{

	private static final long serialVersionUID = 1L;
	private com c = new com();
	public int i;
	public String toString(){
		return c.name;
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
		myclass test=new myclass();
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
