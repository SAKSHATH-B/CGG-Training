package cgg.sma.manage;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionProvider {

	static Connection conn;
	
	public static Connection createC() {
		try {
			//load the driver
		Class.forName("org.postgresql.Driver");
		
		conn=DriverManager.getConnection("jdbc:postgresql://localhost:5432/test","postgres","postgres");
		System.out.println("Connection Established");
		
		}
		catch(ClassNotFoundException|SQLException e) {
			e.printStackTrace();
		}
		
		return conn;
	}
}
