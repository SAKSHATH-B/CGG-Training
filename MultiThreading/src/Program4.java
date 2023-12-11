class Thread4 implements Runnable{
    public void run(){
        task1();
        task2();
        task3();
    }
    void task1(){
        System.out.println("This is Task1");
    }
    void task2(){
        System.out.println("This is Task2");
    }
    void task3(){
        System.out.println("This is Task3");
    }
}

public class Program4 {
    public static void main(String[] args) {
        Thread4 th4 = new Thread4();
        Thread t4 = new Thread(th4);
        t4.start();
    }
}
