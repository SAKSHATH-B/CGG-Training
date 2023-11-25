import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class DBDemoInsertBinary {
    public static void main(String[] args) throws Exception {
        String url = "jdbc:postgresql://localhost:5432/test";
        String username = "postgres";
        String password = "postgres";

        
        Class.forName("org.postgresql.Driver");
        Connection conn = DriverManager.getConnection(url, username, password);

        String insertCommand = "insert into attachment(filename,filedata) values(?,?)";
        PreparedStatement ps = conn.prepareStatement(insertCommand,Statement.RETURN_GENERATED_KEYS);

        File file = new File("img.png");
        String filename = file.getName();
        int fileLength = (int)file.length();

        InputStream source = new FileInputStream(file);

        ps.setString(1, filename);
        ps.setBinaryStream(2, source, fileLength);

        int count = ps.executeUpdate();

        if(count>0){
            System.out.println(count + " row(s) inserted..");
            ResultSet rs = ps.getGeneratedKeys();
            rs.next();
            int generetedKey = rs.getInt(1);
            System.out.println("ID assigned : "+generetedKey);
            rs.close();
        }

        source.close();
        ps.close();
        conn.close();

    }
}
