class PracticeThread1 extends Thread{
    public void run(){
        while (true) {
            System.out.println("Good Morning");
        }
    }
}
class PracticeThread2 extends Thread{
    public void run(){
        // while (true) {
        //     try {
        //         Thread.sleep(500);
        //     } catch (InterruptedException e) {
        //         // TODO Auto-generated catch block
        //         e.printStackTrace();
        //     }
        //     System.out.println("Welcome");
        // }
    }
}

public class Practice {
    public static void main(String[] args) {
        PracticeThread1 p1 = new PracticeThread1();
        PracticeThread2 p2 = new PracticeThread2();
        p1.setPriority(6);
        p2.setPriority(9);
        System.out.println(p1.getPriority());
        System.out.println(p2.getPriority());
        System.out.println(p2.getState());
        // p1.start();
        p2.start();
        System.out.println(p2.getState());
        System.out.println(Thread.currentThread().getState());
    }
}
