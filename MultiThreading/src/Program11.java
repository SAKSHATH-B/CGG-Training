class Thread11 extends Thread{
    int count = 0;
    public void run(){
        for (int i = 1; i <= 10000; i++) {
            count++;
        }
        System.out.println("Completed Thread: "+ Thread.currentThread().getName());
        System.out.println("Its Priority: "+Thread.currentThread().getPriority());
    }
}

public class Program11 {
    public static void main(String[] args) {
        Thread11 obj = new Thread11();

        Thread t1 = new Thread(obj, "one");
        Thread t2 = new Thread(obj, "Two");

        t1.setPriority(2);
        t2.setPriority(Thread.NORM_PRIORITY);

        t1.start();
        t2.start();
    }
}
