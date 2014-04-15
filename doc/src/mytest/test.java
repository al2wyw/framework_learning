package mytest;

import java.io.Serializable;
public class test implements Serializable{

	private String text;
	public test(){
		text="peter";
	}
	public String getText(){
		return text;
	}
	public void setText(String tt){
		text=tt;
	}

}