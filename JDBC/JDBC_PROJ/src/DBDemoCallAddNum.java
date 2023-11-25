import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Types;

public class DBDemoCallAddNum {
    public static void main(String[] args) {
        String url = "jdbc:postgresql://localhost:5432/test";
        String username = "postgres";
        String password = "postgres";

        try {
            Class.forName("org.postgresql.Driver");
            Connection conn = DriverManager.getConnection(url, username, password);

            CallableStatement cs = conn.prepareCall("call spAddNum(?,?,?)");
            cs.setInt(1, 12);
            cs.setInt(2, 5);
            cs.registerOutParameter(3, Types.INTEGER);

            cs.execute();

            int result = cs.getInt(3);

            System.out.println("Sum := "+result);

            cs.close();
            conn.close();
            

        }catch (ClassNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}
