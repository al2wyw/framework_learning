package mytest;
import java.util.*;
import java.text.*;
public class testdate {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Calendar now=Calendar.getInstance();
		System.out.println(now.getTimeZone());
		System.out.println(now.get(Calendar.HOUR));
		Date n=now.getTime();
		System.out.println(n);
		now.setTimeZone(TimeZone.getTimeZone("GMT+6"));
		System.out.println(now.getTimeZone());
		System.out.println(now.get(Calendar.HOUR));
		n=now.getTime();
		//TimeZone.setDefault(TimeZone.getTimeZone("GMT+6"));//before System.out.println(n);
		System.out.println(n);
		System.out.println("===================");
		//TimeZone.setDefault(TimeZone.getTimeZone("GMT-7"));//before new SimpleDateFormat("MM/dd yyyy, HH:mm:ss Z")
		System.out.println(n);
		System.out.println(now.get(Calendar.MONTH)+" "+now.get(Calendar.DATE)+" "+now.get(Calendar.DAY_OF_WEEK));
		TimeZone.setDefault(TimeZone.getTimeZone("GMT-7"));
		SimpleDateFormat format=new SimpleDateFormat("MM/dd yyyy, HH:mm:ss Z");
		TimeZone.setDefault(TimeZone.getTimeZone("GMT+8"));
		System.out.println(format.format(n));
		try{

		Date er=format.parse("13/23 2000, 12:34:21 +0000");
		System.out.println(format.format(er));
		System.out.println(er);
		}catch(Exception e){
			
		}
	}
	
}
