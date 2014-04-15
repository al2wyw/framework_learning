package mysql;
import java.sql.*;
import java.util.Map;

public class mysql {

	/**
	 * @param args
	 */
	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		
		Class.forName("com.mysql.jdbc.Driver");
		DriverManager.setLoginTimeout(1);
		String user="developer";
		String password="al2wyw";
		Connection con=DriverManager.getConnection("jdbc:mysql://10.30.178.108:3306/test", user, password);
		DatabaseMetaData dbMeta = con.getMetaData();
		System.out.println(dbMeta.supportsResultSetHoldability(ResultSet.CLOSE_CURSORS_AT_COMMIT));
		System.out.println(dbMeta.supportsResultSetType(ResultSet.TYPE_SCROLL_INSENSITIVE));
		Map<String,Class<?>> t=con.getTypeMap();
		for(Map.Entry<String, Class<?>> entry:t.entrySet()){
			System.out.println(entry.getKey()+" "+entry.getValue().getName());
		}
		con.setAutoCommit(false);
		con.setTransactionIsolation(Connection.TRANSACTION_REPEATABLE_READ);
//		con.setHoldability(ResultSet.CLOSE_CURSORS_AT_COMMIT);
		Statement s=con.createStatement();
		s.setQueryTimeout(3);
		ResultSet set=s.executeQuery("select * from mytab");
		con.commit();
		ResultSetMetaData data=set.getMetaData();
		System.out.println(data.getColumnTypeName(6));
		while(set.next()){
			System.out.println(set.getInt(1)+" "+set.getString(2)+" "+set.getFloat(3)+" "+set.getShort("level"));
		}
		set.close();
		s.close();
		con.close();
		System.out.println(Long.MAX_VALUE);
	}
}
