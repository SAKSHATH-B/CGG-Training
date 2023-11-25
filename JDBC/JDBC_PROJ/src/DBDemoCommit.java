import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class DBDemoCommit {
    public static void main(String[] args) throws Exception {
        String url = "jdbc:postgresql://localhost:5432/test";
        String username = "postgres";
        String password = "postgres";

        
        Class.forName("org.postgresql.Driver");
        Connection conn = DriverManager.getConnection(url, username, password);

        conn.setAutoCommit(false);

        Statement stm = conn.createStatement();
        String deleteCommand = "delete from emp where empno=201";

        int count = stm.executeUpdate(deleteCommand);
        if(count > 0){
            System.out.println("Employee Deleted...");
        }else{
            System.out.println("No Such Employee..");
        }
        conn.rollback();
        System.out.println("Transaction rollbacked");

        conn.setAutoCommit(true);

        stm.close();
        conn.close();
    }
}
