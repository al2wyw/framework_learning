package mytest;
import java.io.*;
public class testBuffered{

	/**
	 * @param args
	 */
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		File f=new File("123.data");
		if(!f.exists()){
			System.out.println("test");
			return;
		}
		FileInputStream fin=new FileInputStream(f);
		int len=10240;
		byte[] buffer=new byte[len];
		System.out.println(fin.available());
		BufferedInputStream bin=new BufferedInputStream(fin,len);
		int l=bin.read(buffer);
		System.out.println(l);
		fin.close();
	}

}
