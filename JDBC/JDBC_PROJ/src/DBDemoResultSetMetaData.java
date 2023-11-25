import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;

public class DBDemoResultSetMetaData {
    public static void main(String[] args) {
        String url = "jdbc:postgresql://localhost:5432/test";
        String username = "postgres";
        String password = "postgres";

        try {
            Class.forName("org.postgresql.Driver");
            Connection conn = DriverManager.getConnection(url, username, password);
            String query = "select * from emp where 1=2";
            
            Statement stm = conn.createStatement();

            ResultSet rs = stm.executeQuery(query);
            ResultSetMetaData rm = rs.getMetaData();

            int cols = rm.getColumnCount();

            for (int i = 1; i <= cols; i++) {
                
                System.out.print(rm.getColumnName(i)+"\t");
                System.out.print(rm.getColumnType(i)+"\t");
                System.out.print(rm.getColumnTypeName(i)+"\t");
                System.out.println(rm.getColumnClassName(i)+"\t");
                
            }

            rs.close();
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
