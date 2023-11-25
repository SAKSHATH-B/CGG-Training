import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class DBDemoCreateGetSalary {
    public static void main(String[] args) {
        String url = "jdbc:postgresql://localhost:5432/test";
        String username = "postgres";
        String password = "postgres";

        try {
            Class.forName("org.postgresql.Driver");
            Connection conn = DriverManager.getConnection(url, username, password);

            Statement stm = conn.createStatement();
            String drop_spGetSalary = "drop procedure if exists spGetSalary";
            String create_spGetSalary = "create procedure spGetSalary(p_empno int, inout p_sal decimal(7,2)) language plpgsql as $$"+"Begin "+"select salary into p_sal from emp where empno = p_empno;"+"end; $$";

            stm.execute(drop_spGetSalary);
            stm.execute(create_spGetSalary);

            System.out.println("Procedure spGetSalary Created...");

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
