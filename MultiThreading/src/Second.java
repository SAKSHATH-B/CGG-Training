class MultiThreading extends Thread{
    public void run(){
        try {
            System.out.println("Thread "+Thread.currentThread().getId()+" is running");
        } catch (Exception e) {
            System.out.println("Exception");
        }
    }
}

public class Second {
    public static void main(String[] args) {
        int n=8;
        for (int i = 0; i <n; i++) {
            MultiThreading obj = new MultiThreading();
            obj.start();
        }
    }
}
