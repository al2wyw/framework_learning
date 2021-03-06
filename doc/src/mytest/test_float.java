package mytest;
import java.math.*;
/*
 * double <- (double + double/float/long/int)
 *  |
 * float <- (float + float/long/int)
 *  |
 * long <- (long + long/int)
 *  |
 * int <- (byte/char/short/int + byte/char/short/int)
 */
public class test_float {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		double a=0.05; //default is double
		double b=0.01;
		double c=a+b;
		System.out.println(c);
		System.out.println(new java.text.DecimalFormat("0.00").format(c));
		System.out.println(1.0-0.42);
		System.out.println(4.015*100);
		System.out.println(123.3/100);
		BigDecimal x=new BigDecimal("0.05");
		BigDecimal y=new BigDecimal("0.01");
		BigDecimal z=x.add(y);
		System.out.println(z.toString());
		
		System.out.println("=================");
		
		int i = 10;
		long l = 10L;
		float f = 12.43f;
		float o = i+ f;
		o = l + f;
		o = f + o;
		
		System.out.println(o);
	}

}
