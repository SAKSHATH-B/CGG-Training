/**
 * Program1
 */
public class Program1 {

    public static void main(String[] args) {
        Thread t = Thread.currentThread();
        System.out.println("Current Thread: "+t);
        System.out.println("Thread Name: "+t.getName());
    }
}