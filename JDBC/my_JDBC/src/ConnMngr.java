import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnMngr {
    public static Connection createC() throws SQLException, ClassNotFoundException{
        Class.forName("org.postgresql.Driver");
        Connection conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/test", "postgres", "postgres");
        
        System.out.println("Connection Established");
        return conn;
    }

}
