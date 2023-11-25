import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class DBDemoCreate {
    public static void main(String[] args) {
        String url = "jdbc:postgresql://localhost:5432/test";
        String username = "postgres";
        String password = "postgres";

        try {
            Class.forName("org.postgresql.Driver");
            Connection conn = DriverManager.getConnection(url, username, password);
            // String dropCommand = "drop table if exists emp";
            // String createCommand = "create table emp(empno int primary key, ename varchar(50),salary decimal(7,2))";
            // String dropCommand = "drop table if exists emp2";
            // String createCommand = "create table emp2(empno serial primary key, ename varchar(50),salary decimal(7,2))";
            String dropCommand = "drop table if exists attachment";
            String createCommand = "create table attachment(id serial primary key, filename varchar(250),filedata bytea)";

            Statement stm = conn.createStatement();

            stm.execute(dropCommand);
            stm.execute(createCommand);

            System.out.println("Table Created");

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
