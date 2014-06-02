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
//	public int d(){ //will be wrong
//		System.out.println("B");
//		return 1;
//	}
	public static int d(){
		System.out.println("B");
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
