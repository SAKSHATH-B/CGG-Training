class Reservation extends Thread{
    public void run(){
        System.out.println("I am reservation Thread - "+Thread.currentThread().getName());
    }
}
class Cancellation extends Thread{
    public void run(){
        System.out.println("I am cancellation Thread - "+Thread.currentThread().getName());
    }
}

public class Program12 {
    public static void main(String[] args) {
        Reservation res = new Reservation();
        Cancellation can = new Cancellation();

        ThreadGroup tg = new ThreadGroup("First Group");

        Thread t1 = new Thread(tg, res, "First Thread");
        Thread t2 = new Thread(tg, res, "Second Thread");

        ThreadGroup tg1 = new ThreadGroup(tg,"Second Group");

        Thread t3 = new Thread(tg1, can, "Third Thread");
        Thread t4 = new Thread(tg1, can, "Fourth Thread");

        //parent group of tg1
        System.out.println("Parent of tg1: "+tg1.getParent());

        //set maxPriority to tg1 as 7
        tg1.setMaxPriority(7);

        //knw thread group of t1 and t3
        System.out.println("Thread group of t1: "+t1.getThreadGroup());
        System.out.println("Thread group of t3: "+t3.getThreadGroup());

        t1.start();
        t2.start();
        t3.start();
        t4.start();
        
        //no of threads actively running
        System.out.println("Active Threads: "+tg.activeCount());
    }
}
