import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBDemo {
    public static void main(String[] args) {
        String url = "jdbc:postgresql://localhost:5432/test?user=postgres&password=postgres";
        // String username = "postgres";
        // String password = "postgres";

        try {
            Class.forName("org.postgresql.Driver");
            Connection conn = DriverManager.getConnection(url);
            System.out.println("Connection Established");
            conn.close();
        } catch (ClassNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (SQLException e){
            e.printStackTrace();
        }
    }
}
