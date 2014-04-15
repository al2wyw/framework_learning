package vaannila;

import java.util.Locale;
import java.util.ResourceBundle;
import java.io.File;
public class testLocale {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(System.getProperty("user.dir"));
		String dir=System.getProperty("user.dir");
		dir+="\\src\\vaannila\\";
		System.setProperty("user.dir", dir);
		File f=new File("test.txt");
		if(f!=null){
			System.out.println(f.getName()+" "+f.getAbsolutePath());
		}
		System.out.println(System.getProperty("user.dir"));
		Locale myLoc=Locale.getDefault();
		Locale china=Locale.CHINA;
		ResourceBundle myrb=ResourceBundle.getBundle("FileUploadAction");
		System.out.println(myrb.getString("submit"));
	}

}
