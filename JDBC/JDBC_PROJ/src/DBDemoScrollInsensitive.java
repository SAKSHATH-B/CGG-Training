import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.Statement;
import java.sql.Driver;


public class DBDemoScrollInsensitive {
    public static void main(String[] args) throws Exception {
        String url = "jdbc:postgresql://localhost:5432/test";
        String username = "postgres";
        String password = "postgres";

        
        Class.forName("org.postgresql.Driver");
        Connection conn = DriverManager.getConnection(url, username, password);
        Statement stm = conn.createStatement(ResultSet.CONCUR_UPDATABLE,ResultSet.TYPE_SCROLL_SENSITIVE);

        String query = "select * from emp";
        ResultSet rs = stm.executeQuery(query);

        ResultSetMetaData rm = rs.getMetaData();
        int cols = rm.getColumnCount();
        for (int i = 1; i <= cols; i++) {
            System.out.print(rm.getColumnName(i)+"\t");
        }
        System.out.println();
        Thread.sleep(60000);
        while(rs.next()){
            for (int i = 1; i <= cols; i++) {
                System.out.print(rs.getString(i)+"\t");
            }
            System.out.println();
        }
        
        rs.close();
        stm.close();
        conn.close();
    }
}
