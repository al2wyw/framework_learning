package mytest;

import java.util.*;

class key implements Comparable{
	
	public int compareTo(Object o){

		return 1;
	}
}
public class collection {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		HashSet<StringBuilder> name=new HashSet<StringBuilder>();
		name.add(new StringBuilder("lee"));
		name.add(new StringBuilder("john"));
		name.add(null);
		name.add(new StringBuilder("lee"));
		Iterator<StringBuilder> it=name.iterator();
		while(it.hasNext()){
			System.out.println(it.next());
		}
		StringBuilder t=new StringBuilder("test");
		System.out.print(t.hashCode());
		System.out.print("lee".hashCode()+" "+"lee".hashCode());
	}

}
