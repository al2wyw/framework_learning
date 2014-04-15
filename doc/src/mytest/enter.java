package mytest;

import java.io.Serializable;
public class enter implements Serializable{
	
	private String text;
	public enter(){
		text="peter";
	}
	public String getText(){
		return text;
	}
	public void setText(String tt){
		text=tt;
	}

}
