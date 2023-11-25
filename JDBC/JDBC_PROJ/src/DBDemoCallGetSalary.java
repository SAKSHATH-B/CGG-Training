import java.sql.Types;
import java.math.BigDecimal;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBDemoCallGetSalary {
    public static void main(String[] args) {
        String url = "jdbc:postgresql://localhost:5432/test";
        String username = "postgres";
        String password = "postgres";

        try {
            Class.forName("org.postgresql.Driver");
            Connection conn = DriverManager.getConnection(url, username, password);

            CallableStatement cs = conn.prepareCall("call spGetSalary(?,?)");

            cs.setInt(1, 105);
            cs.registerOutParameter(2, Types.DECIMAL);

            cs.execute();

            BigDecimal salary = cs.getBigDecimal(2);

            if(cs.wasNull()){
                System.out.println("Salary is Null");
            }else{
                System.out.println("Salary = "+salary);
            }

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
