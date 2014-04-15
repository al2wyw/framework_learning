package mytest;

class mythread extends Thread{
	public final String lock="test";
	public mythread(String name){
		super(name);
	}
	public void run(){
		synchronized(lock){
			System.out.println("obtain first lock");
			synchronized(lock){
				System.out.println("obtain second lock");
			}
		}
		try{
		Thread.sleep(Integer.MAX_VALUE);
		}catch(Exception e){
			
		}
	}
}
public class test_syn {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		mythread test=new mythread("test");
		test.start();

	}

}
