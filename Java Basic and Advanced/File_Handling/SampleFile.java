import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.Writer;

public class SampleFile {
    public static void main(String[] args) {
        // try(FileWriter fw = new FileWriter("abc.txt")) {
        //     // File f = new File("abc.txt");

        //     // BufferedWriter bw = new BufferedWriter(fw);
        //     fw.write("Hey man i am using this resource and it will be closed automatically.");
        //     // fw.close();
        //     // System.out.println("Can Read : "+f.canRead());
        //     // System.out.println("Can Write : "+f.canWrite());
        //     // System.out.println("Is exists : "+f.exists());
        //     // System.out.println("File name : "+f.getName());
        //     // System.out.println("Size : "+f.length());
            
        // } catch (Exception e) {
        //     System.out.println(e.getMessage());
        //     // TODO: handle exception
        // }


        // FileOutputStream


        // try (FileOutputStream fout = new FileOutputStream("C:\\Users\\CGG\\Documents\\Training\\File Handling\\xyz.txt",true)){
        //     String s = "\nJubliee hills branch is mainly specialized for Research and Development Purpose.";
        //     System.out.println(s.length());
        //      char[] a=s.toCharArray();

        //     for(int i=0;i<s.length();i++){
        //         System.out.print((char)i);
        //         fout.write(a[i]);
        //     }
        //     fout.close();
        // } catch (Exception e) {
        //     System.out.println(e.getMessage());
        //     // TODO: handle exception
        // }


        // FileInputStream


        // try {
        //     FileInputStream fis = new FileInputStream("./File Handling/xyz.txt");
        //     int ch;
        //     while((ch = fis.read()) != -1){
        //         System.out.print((char)ch);
        //     }
        //     fis.close();
        // } catch (Exception e) {
        //     System.out.println(e.getMessage());
        //     // TODO: handle exception
        // }


        //BufferedWriter

        // try {
        //     BufferedWriter bw = new BufferedWriter(new FileWriter("./File Handling/xy.txt",true));
        //     bw.write("Hello I am a new File with name xy.txt");
        //     bw.close();
            
        // } catch (Exception e) {
        //     System.out.println(e.getMessage());
        //     // TODO: handle exception
        // }


        //BufferedReader

        
        try {
            BufferedReader br = new BufferedReader(new FileReader("./File Handling/xyz.txt"));
            // int ch = br.read();
            // while((ch) != -1){
            //     System.out.print((char)ch);
            //     ch = br.read();
            // }
            String s;
            while((s = br.readLine()) != null){
                System.out.println(s);
                
            }
            br.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            // TODO: handle exception
        }
    }
}
