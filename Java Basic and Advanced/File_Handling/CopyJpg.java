import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;


public class CopyJpg {
    public static void main(String[] args) {
        try  {
            FileOutputStream f = new FileOutputStream("C:\\Users\\CGG\\Documents\\Training\\File Handling\\img.jpg");
            FileInputStream f1 = new FileInputStream("C:\\Users\\CGG\\Documents\\Training\\File Handling\\_MG_2389.jpg");
            int i;
            while((i=f1.read())!=-1){
                f.write(i);
            }
            // File f2 = new File("C:\\Users\\CGG\\Documents\\Training\\File Handling\\img.jpg");
            // System.out.println(f2.delete());
        } catch (IOException e) {
            System.out.println(e.getMessage());
            // TODO: handle exception
        }
    }
}
