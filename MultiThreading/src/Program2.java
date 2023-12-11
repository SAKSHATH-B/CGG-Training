class Thread1 extends Thread{
    public void run(){
        for (int i = 1; i <= 10000; i++) {
            System.out.println(i);
        }
    }
}
class Thread2 implements Runnable{
    
    public void run(){
        for (int i = 1; i <= 10000; i++) {
            System.out.println(i);
        }
    }
}

public class Program2 {
    public static void main(String[] args) {
        Thread1 th1 = new Thread1();
        // Thread t1 = new Thread(th);
        th1.start();
        // t1.start();

        Thread2 th2 = new Thread2();
        Thread t2 = new Thread(th2);
        t2.start();
    }
}
