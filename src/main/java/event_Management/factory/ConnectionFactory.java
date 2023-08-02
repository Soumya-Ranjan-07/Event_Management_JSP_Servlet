package event_Management.factory;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {
	
	private static Connection con = null;
	
	static
	{
		try
		{
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/event_man","root","root");
		}
		catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		catch (SQLException e) {
			e.printStackTrace();
		}		
	}
	
	public static Connection getConObj()
	{
		return con;
	}
	
	public static void getClose()
	{
		try {
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}		
	}

}
