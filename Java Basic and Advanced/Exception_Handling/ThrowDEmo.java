import java.io.File;
import java.io.FileNotFoundException;

public class ThrowDEmo {
    void proc(){
        try{
            throw new FileNotFoundException("From Exception");
        }
        catch(FileNotFoundException e){
            System.out.println(e);
            try {
                throw e;
                
            } catch (FileNotFoundException e1) {
                System.out.println("Recaugnt Exception"+e);
            }
        }
    }
    public static void main(String[] args) {
        ThrowDEmo d = new ThrowDEmo();
        d.proc();
    }
}   
