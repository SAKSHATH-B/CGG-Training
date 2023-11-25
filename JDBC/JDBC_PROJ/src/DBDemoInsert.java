import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class DBDemoInsert {
    public static void main(String[] args) {
        String url = "jdbc:postgresql://localhost:5432/test";
        String username = "postgres";
        String password = "postgres";

        try {
            Class.forName("org.postgresql.Driver");
            Connection conn = DriverManager.getConnection(url, username, password);
            String insertCommand = "insert into emp2(ename,salary) values('john',54590)";
            

            Statement stm = conn.createStatement();

            int count = stm.executeUpdate(insertCommand);

            System.out.println(count + " row(s) affected");

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
