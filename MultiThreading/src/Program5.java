class Thread5 implements Runnable{
    String str;
    public Thread5(String str){
        this.str = str;
    }
    public void run(){
        for (int i = 1; i <= 10; i++) {
            System.out.println(str+ " : "+i);
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
    }
}

public class Program5 {
    public static void main(String[] args) throws InterruptedException {
        Thread5 th5 = new Thread5("Salaar");
        Thread5 th6 = new Thread5("Cease Fire");

        Thread t1 = new Thread(th5);
        Thread t2 = new Thread(th6);

        t1.start();
        t2.start();
    }
}
