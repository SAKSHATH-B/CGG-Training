class newThread1 extends Thread{
    public newThread1(String name){
        super(name);
    }
    public void run(){
        System.out.println("This is new Thread 1 id: "+this.getId());
    }
}

class newThread2 extends Thread{
    public void run(){
        int i=0;
        while (true) {
            System.out.println("Thank You Thread "+Thread.currentThread().getId());
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
            // i++;
        }
    }
}

public class SevenThreadMethods {
    public static void main(String[] args) {
        newThread1 nt1 = new newThread1("Hello");
        newThread2 nt2 = new newThread2();
        nt1.start();
        // try {
        //     nt1.join();
        // } catch (InterruptedException e) {
        //     // TODO Auto-generated catch block
        //     e.printStackTrace();
        // }
        nt2.start();
    }
}
