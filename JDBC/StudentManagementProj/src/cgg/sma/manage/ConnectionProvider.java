package cgg.sma.manage;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionProvider {

	static Connection conn;
	
	public static Connection createC() {
		try {
			//load the driver
		Class.forName("com.mysql.cj.jdbc.Driver");
		
		conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/student_manage","root","root");
		
		
		}
		catch(ClassNotFoundException|SQLException e) {
			e.printStackTrace();
		}
		
		return conn;
	}
}
