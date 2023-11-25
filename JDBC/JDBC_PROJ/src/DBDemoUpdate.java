import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class DBDemoUpdate {
    public static void main(String[] args) {
        String url = "jdbc:postgresql://localhost:5432/test";
        String username = "postgres";
        String password = "postgres";

        try {
            Class.forName("org.postgresql.Driver");
            Connection conn = DriverManager.getConnection(url, username, password);
            String updateCommand = "update emp set ename='dinakar', salary=28700 where empno="+105;
            

            Statement stm = conn.createStatement();

            int count = stm.executeUpdate(updateCommand);

            System.out.println(count + " row(s) Updated");

            stm.close();
            conn.close();

        } catch (ClassNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }catch(SQLException e){
            e.printStackTrace();
        }

    }
}
