package mytest;

import java.util.concurrent.*;
import java.util.Date;

class myTask extends Thread{
	private String name;
	private Boolean flag=false;
	public myTask(){
		super();
		name="no name";
	}
	public myTask(String name) {
		super();
		this.name = name;
	}
	
	public void run(){
		if(flag){
			try{
				thread.sleep(1000);
			}catch(Exception e){
				
			}
		}
		System.out.println(new Date());
		System.out.println("test for "+name);
	}
	public void set(){
		flag=!flag;
	}
}
public class scheduledpool {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		myTask t1=new myTask("task 1");
		myTask t2=new myTask("task 2");
		myTask t3=new myTask("task 3");
		ScheduledThreadPoolExecutor sexe=new ScheduledThreadPoolExecutor(10);
		System.out.println(new Date());
		sexe.schedule(t1, 3, TimeUnit.SECONDS);
		sexe.schedule(t2, 3, TimeUnit.SECONDS);
		sexe.schedule(t3, 3, TimeUnit.SECONDS);
		Future<?> f=sexe.submit(t3);
		sexe.execute(t3);
		System.out.println(f.isDone());
		try{
			thread.sleep(3000);
		}catch(Exception e){
			
		}
		t1.set();
		sexe.scheduleWithFixedDelay(t1, 5, 1, TimeUnit.SECONDS);
	}

}
