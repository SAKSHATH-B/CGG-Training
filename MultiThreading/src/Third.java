class MyThreadRunnable1 implements Runnable{
public void run(){
    int i=0;
    while (i<400) {
        System.out.println("I am a Thread 1");
        i++;
    }
    }
}
class MyThreadRunnable2 implements Runnable{
public void run(){
    int i=0;
    while (i<400) {
        System.out.println("I am a Thread 2");
        i++;
    }
    }
}

public class Third {
    public static void main(String[] args) {
        MyThreadRunnable1 b1 = new MyThreadRunnable1();
        Thread g1 = new Thread(b1);
        MyThreadRunnable2 b2 = new MyThreadRunnable2();
        Thread g2 = new Thread(b2);
        g1.start();
        g2.start();

    }
}
