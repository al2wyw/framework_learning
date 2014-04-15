package mytest;

//interupt() will set the interupt bit true before sleep is called,then sleep will throw exception immediately
class CanStop extends Thread {  
  
    private int counter = 0;  
  
    public void run() {  
        boolean done = false;  
        try{  
            Thread.sleep(1000);//设置成100比主线程中的500要小  
        }catch(InterruptedException ie){  
            ie.printStackTrace();  
            //return;假如要使用interrupt来终止线程则在捕获的InterruptedException中return  
        }  
        interrupt();
        while (counter < 10000 &&!done) {  
            System.out.println(counter++);  
            //在主线程中调用stoppable.interrupt()之前为false,假如之后没有调用Thread.interrupted()则一直为true,  
            //否则为第一次为true,调用Thread.interrupted之后为false  
            System.out.println("in thread stoppable.isInterrupted() "+isInterrupted());  
              
            //System.out.println("stoppable.isInterrupted() "+Thread.interrupted());////在主线程中调用stoppable.interrupt()之前为false,之后只有第一个会显示为true,之后全为false  
              
           
            //调用Thread.interrupted()一次会清除线程的中断标志位,因此以后都为false  
//            if(Thread.interrupted()==true){  
                try{  
                    //Thread.interrupted()会清除中断标志位,显然这里面只会调用一次  
                    System.out.println("in thread after Thread.interrupted() "+isInterrupted());  
                    sleep(10000);  
                }catch(InterruptedException ie){  
                    ie.printStackTrace();  
                      
                }  
//            }  
        }  
    }  
      
}  
  
public class test_interrupted {  
    public static void main(String[] args) throws Exception{  
        final CanStop stoppable = new CanStop();  
        stoppable.start();  
        Thread.sleep(500); // run() after 500 milliseconds  
//                System.out.println("Requesting Interrupt");  
//                stoppable.interrupt();//不会中断正在执行的线程,原因是因为interrupt()方法只设置中断状态标志位为true  
//                System.out.println("in timer stoppable.isInterrupted() "+stoppable.isInterrupted());  
            
        
    }  
}  

  


