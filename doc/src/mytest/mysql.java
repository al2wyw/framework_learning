package mytest;
import java.sql.*;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;
import java.util.*;

public class mysql{
	private HashMap<String,String> people = new HashMap<String,String>(50);
	public mysql(){
		getResult();
	}
	public char getcharvar(){
		return 'A';
	}
	public HashMap<String,String> getPeople(){
		return people;
	}
	public void getResult(){
		try{
		Context text=new InitialContext();
		DataSource data=(DataSource)text.lookup("java:comp/env/jdbc/TestDB");
		Connection con=data.getConnection();
	
		con.setAutoCommit(false);
		Statement s=con.createStatement();
		ResultSet set=s.executeQuery("select * from mytab");

		while(set.next()){
			people.put(set.getString(2),String.format("%+013.2f", set.getFloat(3)));//the width including the sign and the decimal point
		}
		set.close();
		s.close();
		con.close();

		}catch(Exception e){e.printStackTrace();}

	}
}
