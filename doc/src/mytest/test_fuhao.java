package mytest;
import java.util.*;
public class test_fuhao {

	/**
	 * @param args
	 */
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		byte i = 12;
		byte j = 3;
		i = (byte)(i | j & j); 
//		i = (byte)((i | j) & j);
		System.out.printf("0x%x\n",i);
		long h=551903297536l;
		float f=234.43f;
		float r=h+f;
		System.out.println(r);
	}

}
