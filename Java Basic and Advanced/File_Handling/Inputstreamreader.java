import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;

class Inputstreamreader{
    public static void main(String[] args) {
        // try(InputStreamReader isr = new InputStreamReader(System.in)){
        //     System.out.print("Enter some characters : ");
        //     int letters = isr.read();
        //     System.out.println(letters);
            // while(isr.ready()){
        //         System.out.println((char)letters);
        //         letters = isr.read();
        //     }

        // }
        // catch(IOException e){
        //     System.out.println(e.getMessage());
        // }


        // try (FileReader fr = new FileReader("abc.txt")){
        //     int letters = fr.read();
        //     while(fr.ready()){
        //         System.out.println((char)letters);
        //         letters = fr.read();
        //     }
        //     System.out.println();
            
        // } catch (IOException e) {
        //     System.out.println(e.getMessage());
        //     // TODO: handle exception
        // }


        //byte to char stream and reading the char stream
        // try {BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        //     System.out.println("You typed : " + br.readLine());
        // } catch (IOException e) {
        //     System.out.println(e.getMessage());
        //     // TODO: handle exception
        // }

        // try (BufferedReader br = new BufferedReader(new FileReader("abc.txt"))){
        //     while(br.ready()){
        //         System.out.println(br.readLine());
        //     }
        // } catch (IOException e) {
        //     System.out.println(e.getMessage());
        //     // TODO: handle exception
        // }



        //output

        // try (OutputStreamWriter osw = new OutputStreamWriter(System.out)){
        //     osw.write("Hello");
        //     osw.write(96);
        //     osw.write(10);
        //     osw.write('A');
        //     osw.write("Hello");
        //     char[] arr = "Hello Sakshath".toCharArray();
        //     osw.write(arr);

            
        // } catch (IOException e) {
        //     System.out.println(e.getMessage());
        //     // TODO: handle exception
        // }

        // try (FileWriter fw = new FileWriter("abc.txt",true)){
        //     fw.write("My bad");
            
        // } catch (Exception e) {
        //     System.out.println(e.getMessage());
        //     // TODO: handle exception
        // }

        //CREATE

        try {
            File fo = new File("Hello.txt");
            fo.createNewFile();
            
        } catch (IOException e) {
            System.out.println(e.getMessage());
            // TODO: handle exception
        }

        //WRITE

        try {
            FileWriter fw = new FileWriter("Hello.txt");
            fw.write("Hello I am new File and I have written this into it.");
            fw.close();
        } catch (IOException ed) {
            System.out.println(ed.getMessage());
            // TODO: handle exception
        }

        //READ

        try {
            FileReader fr = new FileReader("Hello.txt");
            int chars;
            while((chars = fr.read()) != -1){
                System.out.print((char)chars);
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
            // TODO: handle exception
        }

        //DELETE

        try {
            File fo = new File("Main.txt");
            fo.createNewFile();
            if(fo.delete()){
                System.out.println(fo.getName());
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
            // TODO: handle exception
        }
    }
}