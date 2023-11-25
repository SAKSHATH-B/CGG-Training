import java.sql.BatchUpdateException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class DBDemoBatch {
    public static void main(String[] args) throws Exception {
        String url = "jdbc:postgresql://localhost:5432/test";
        String username = "postgres";
        String password = "postgres";

        
        Class.forName("org.postgresql.Driver");
        Connection conn = DriverManager.getConnection(url, username, password);

        Statement stm = conn.createStatement();

        stm.addBatch("insert into emp values(111,'Black',20000)");
        stm.addBatch("insert into emp values(112,'Adam',21000)");
        stm.addBatch("insert into emp values(113,'TOM',10000)");

        int counts[];
        try {
            counts = stm.executeBatch();
            // System.out.println(counts);
        } catch (BatchUpdateException e) {
            // TODO: handle exception
            counts = e.getUpdateCounts();
        }
        System.out.println();
        for (int i = 0; i < counts.length; i++) {
            switch (counts[i]) {
                case Statement.SUCCESS_NO_INFO:
                    System.out.println("SUCCESS NO INFO");
                    break;
                case Statement.EXECUTE_FAILED:
                    System.out.println("EXECUTE FAILED");
                    break;
            
                default:
                    System.out.println(counts[i] + "row(s) effected...");
            }
        }

        stm.close();
        conn.close();
        
    }
}
