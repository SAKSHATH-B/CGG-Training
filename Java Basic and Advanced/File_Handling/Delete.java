import java.io.File;

public class Delete {
    public static void main(String[] args) {
        try {
            File f = new File("Hello.txt");
            File fa = new File("abc.txt");
            f.delete();
            fa.delete();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            // TODO: handle exception
        }
    }
}
