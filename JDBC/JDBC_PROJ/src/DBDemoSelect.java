import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;

public class DBDemoSelect{
    public static void main(String[] args) {
        String url = "jdbc:postgresql://localhost:5432/test";
        String username = "postgres";
        String password = "postgres";

        try {
            Class.forName("org.postgresql.Driver");

            Connection conn = DriverManager.getConnection(url, username, password);
            Statement stm = conn.createStatement();
            
            String query = "select empno,ename,salary from emp";
            ResultSet rs = stm.executeQuery(query);
            ResultSetMetaData rm = rs.getMetaData();

            int cols = rm.getColumnCount();
            System.out.println();

            for (int i = 1; i <= cols; i++) {
                System.out.print(rm.getColumnName(i)+"\t");
            }
            System.out.println();
            while(rs.next()){
                for (int i = 1; i <= cols; i++) {
                    System.out.print(rs.getString(i)+"\t");
                }
                System.out.println();
            }

            rs.close();
            stm.close();
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