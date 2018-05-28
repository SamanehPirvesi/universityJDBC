package utitity;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class JdbcConnection {
	public static Connection getConnection() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			String connectionURL="jdbc:mysql://localhost:3306/testdb";
			String user="root";
			String password="";
			Connection conn=DriverManager.getConnection(connectionURL, user, password);
			return conn;
		} catch (ClassNotFoundException e) {
			
			e.printStackTrace();		
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
		return null;
	}
	
	public static void closeConnection(Connection con) {
		try {
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
