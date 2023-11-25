import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class DBDemoSelectBytes {
    public static void main(String[] args) throws Exception {
        String url = "jdbc:postgresql://localhost:5432/test";
        String username = "postgres";
        String password = "postgres";

        
        Class.forName("org.postgresql.Driver");
        Connection conn = DriverManager.getConnection(url, username, password);

        String selectCommand = "select filename,filedata from attachment where id=2";
        Statement stm = conn.createStatement();
        ResultSet rs = stm.executeQuery(selectCommand);

        String saveDir = "./temp";

        while(rs.next()){
            String filename = rs.getString("filename");
            File saveFile = new File(saveDir,filename);

            OutputStream dest = new FileOutputStream(saveFile);
            byte[] data = rs.getBytes("filedata");
            
            dest.write(data);

            dest.flush();
            dest.close();
            System.out.println("File Saved as : "+ saveFile.getCanonicalPath());
        }
    }
}
