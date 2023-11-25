import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;


public class DBPrepared {
    public static void main(String[] args) {
        String url = "jdbc:postgresql://localhost:5432/test";
        String username = "postgres";
        String password = "postgres";

        try {
            Class.forName("org.postgresql.Driver");

            Connection conn = DriverManager.getConnection(url, username, password);
            String insertCommand = "insert into emp values(?,?,?)";

            PreparedStatement ps = conn.prepareStatement(insertCommand);
            ps.setLong(1, 109);
            ps.setString(2, "Alex");
            ps.setDouble(3, 18000);

            int count = ps.executeUpdate();
            System.out.println(count + " row(s) inserted...");

            ps.setLong(1, 110);
            ps.setString(2, "Carey");
            ps.setDouble(3, 19000);

            count = ps.executeUpdate();
            System.out.println(count + " row(s) inserted...");
            
            

            ps.close();
            conn.close();

        } catch (ClassNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
    }
