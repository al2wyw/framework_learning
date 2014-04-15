package mytest;
import java.io.Serializable;
import java.util.ArrayList;

interface cando{
    static class test{
		private int i;
		private int j;
		public test(){
			i=0;
			j=1;
		}
		public test(int m,int n){
			i=m;
			j=n;
		}
		public void testme(){
		}
	}
	void canwrite();
}
interface canfiglt extends cando{
	void canread();
}
public class people implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private transient ArrayList<String> name;
	public people(){
		name=new ArrayList<String>(100);
	}
	public ArrayList<String> getName(){
		return name;
	}
	public void setName(String t){
		name.add(t);
	}
}
