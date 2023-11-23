

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;

public class ScannerEx1 {
    public static void main(String[] args) {
        try (Scanner sc = new Scanner(new FileReader("num.txt"))) {

            while(sc.hasNextInt()){
                int x = sc.nextInt();
                System.out.println(x);
            }
        } catch (FileNotFoundException e) {
            
            e.printStackTrace();
        }
        finally{
            System.out.println("Finally executed.");
        }
        
    }
}
