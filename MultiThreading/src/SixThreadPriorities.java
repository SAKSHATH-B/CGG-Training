class Thd extends Thread{
    public Thd(String name){
        super(name);
    }
    public void run(){
        int i=0;
        while (i<1000) {
            System.out.println("Thread "+this.getName());
            i++;
        }
    }
}

public class SixThreadPriorities {
    public static void main(String[] args) {
        Thd t1 = new Thd("I");
        Thd t2 = new Thd("am");
        Thd t3 = new Thd("good");
        t1.setPriority(Thread.MAX_PRIORITY);
        t2.setPriority(Thread.MIN_PRIORITY);
        t3.setPriority(Thread.MIN_PRIORITY);
        t1.start();
        t2.start();
        t3.start();
    }
}
