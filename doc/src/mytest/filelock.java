package mytest;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.channels.FileLock;
import java.nio.channels.OverlappingFileLockException;

//run several process to test the file lock
class thread extends Thread{
	public thread(){
		super();
	}
	public thread(String name){
		super(name);
	}
	public void run(){
		try{
		File f = new File("test.dat");
		if(!f.exists()){
			f.createNewFile();
		}
		RandomAccessFile rf=new RandomAccessFile(f,"rw");
		FileChannel fc = rf.getChannel();
		FileLock fl=null;
		try{
			fl=fc.lock(0, fc.size(), true);
			ByteBuffer b=ByteBuffer.allocate(100);
			fc.read(b);
			System.out.println("good");
			String s = new String(b.array(),"UTF-8");
			System.out.println(s);
			Thread.sleep(100000);
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			if(fl!=null&&fl.isValid()){
				try{
				fl.release();
				}catch(Exception e){
					e.printStackTrace();
				}
			}
		}
		}catch(Exception e){
			e.printStackTrace();
		}
	}
}
public class filelock {

	/**
	 * @param args
	 */
	public static void main(String[] args) throws FileNotFoundException,IOException,OverlappingFileLockException{
		
		new thread("thread").start();
	}

}
