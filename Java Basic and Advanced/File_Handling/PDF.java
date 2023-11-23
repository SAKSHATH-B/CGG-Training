import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.LineNumberReader;
import java.nio.file.Path;
import java.nio.file.Paths;

public class PDF {

    // FileInputStream fin; FileOutputStream fout;
    // public void init(String arg1,String arg2){
    //     try {
    //         fin = new FileInputStream(arg1);
    //         fout = new FileOutputStream(arg2);
    //     } catch (FileNotFoundException e) {
    //         System.out.println("File not Found : "+e.getMessage());
    //         // TODO: handle exception
    //     }
    // }

    // public void CopyContents(){
    //     try {
    //         int i = fin.read();
    //         while(i!=-1){
    //             fout.write(i);
    //             i = fin.read();
    //         }
    //     } catch (IOException e) {
    //         System.out.println("Exception : "+e);
    //         // TODO: handle exception
    //     }
    // }

    // public void CloseFiles(){
    //     try {
    //         fin.close();
    //         fout.close();
    //     } catch (IOException ioe) {
    //         System.out.println("Exception : "+ioe);
    //         // TODO: handle exception
    //     }
    // }





    public static void main(String[] args) {
        // PDF obj = new PDF();
        // obj.init(args[0],args[1]);
        // obj.CopyContents();
        // obj.CloseFiles();


        // USING STRINGBUFFER

        // StringBuffer sb = new StringBuffer();
        // char c;
        // try {
        //     while((c=(char)System.in.read())!='\n'){
        //         sb.append(c);
        //     }
        // } catch (IOException e) {
        //     System.out.println("Error while reading"+e.getMessage());
        //     // TODO Auto-generated catch block
        // }
        // String s = new String(sb);
        // System.out.println("Entered message is : "+s);



        //USING CHARACTER ARRAY TO PASS AS A ARGUMENT IN READ METHOD'

        // try (FileReader f = new FileReader("./File Handling/xy.txt")){
        //     File f1 = new File("./File Handling/xy.txt");
            
        //     char a[] = new char[(int)f1.length()];
        //     f.read(a);
        //     for(char c : a){
        //         System.out.print(c);
        //     }
        //     // f.close();
            
        // }catch (IOException e) {
        //     // TODO Auto-generated catch block
        //     e.printStackTrace();
        // }


        
        // USING LINEREADER WITH BUFFEREDREADER TO DISPLAY THE OUTPUT CONTAINS IN NAMES.TXT FILE

        // String s;
        // try (FileReader f1 = new FileReader("names.txt");BufferedReader f2 = new BufferedReader(f1);LineNumberReader f3 = new LineNumberReader(f2)) {
        //     while((s = f3.readLine())!=null){
        //         System.out.println(f3.getLineNumber()+ " "+ s);
        //     }
            
        // } catch (IOException e) {
        //     e.printStackTrace();
        //     // TODO: handle exception
        // }

        //USING FILE CLASS

        // File n1 = new File("names.txt");
        // System.out.println("Can Read : "+n1.canRead());
        // System.out.println("exists : "+n1.exists());
        // System.out.println("can write : "+n1.canWrite());
        // System.out.println("Length : "+n1.length());
        // System.out.println("IS FILE : "+n1.isFile());
        // System.out.println("Is Directory : "+n1.isDirectory());
        // System.out.println("GEt Absolute path : "+n1.getAbsolutePath());
        // System.out.println("Name : "+n1.getName());
        // System.out.println("Path : "+n1.getPath());
        // System.out.println("Parent : "+n1.getParent());
        // System.out.println("Last Modified : "+n1.lastModified());
        // System.out.println("list : "+n1.list());
        
        File f1 = new File("ns");
        try {
            f1.createNewFile();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        f1.mkdir();
        f1.delete();


        Path home = Paths.get("C:\\Users\\CGG\\Documents\\Training\\File Handling\\names.txt");
        System.out.println(home.getFileName());
        System.out.println(home.getRoot());
        System.out.println(home.getNameCount());
        System.out.println(home.getName(1));
        System.out.println(home.getParent());

    }

}
