import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class DBDemoCreateAddNum {
    public static void main(String[] args) {
        String url = "jdbc:postgresql://localhost:5432/test";
        String username = "postgres";
        String password = "postgres";

        try {
            Class.forName("org.postgresql.Driver");
            Connection conn = DriverManager.getConnection(url, username, password);

            Statement stm = conn.createStatement();
            String drop_spAddNum = "drop procedure if exists spAddNum";
            String create_spAddNum = "create procedure spAddNum(a int, b int,inout c int) language plpgsql as $$"+"Begin"+" c:= a+b;"+"end; $$";
            

            stm.execute(drop_spAddNum);
            stm.execute(create_spAddNum);

            System.out.println("Procedure spAddNum Created...");

            stm.close();
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
