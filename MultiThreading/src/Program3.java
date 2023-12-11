import java.io.IOException;

class Thread3 extends Thread{
    boolean stop = false;
    public void setStop(boolean stop){
        this.stop = stop;
    }
    public void run(){
        for (int i = 1; i <= 10000; i++) {
            System.out.println(i);
            if(stop) return;
        }
    }
}

public class Program3 {
    public static void main(String[] args) throws IOException {
        Thread3 th3 = new Thread3();
        th3.start();
        System.out.println("Press Enter to stop the thread...");
        System.in.read();
        th3.setStop(true);
    }
}

