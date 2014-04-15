package mytest;

import java.io.Serializable;
import java.util.Date;
public class myTestDate implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8955050346426575290L;
	
	/**
	 * @param args
	 */
	public String getdate(){
		return new Date().toString();
	}
	
}
