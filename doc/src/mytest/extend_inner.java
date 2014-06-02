package mytest;

class outer{
	private int i;
	public outer(int j){
		i = j;
	}
	public void print(){
		System.out.println(i);
	}
	public class inner{
		private int i;
		public inner(int j){
			i = j;
		}
		public void print(){
			System.out.println(outer.this.i);
			System.out.println(i);
		}
	}
}
class ex extends outer.inner{
	public ex(outer o,int j){
		o.super(j+1);
		
	}
}
class ee extends outer{
	public ee(int j){
		super(j);
	}
	public class inn extends inner{
		public inn(int j){
			super(j);
		}
	}
}
class node implements Comparable<node>{
	private int i;
	public node(int j){
		i = j;
	}
	
	public int getI() {
		return i;
	}

	public void setI(int i) {
		this.i = i;
	}

	public int compareTo(node e){
		if(i<e.getI())
			return -1;
		else if(i>e.getI())
			return 1;
		else
			return 0;
	}
}
public class extend_inner {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ex test=new ex(new outer(11),10);
		test.print();
		
	}

}
