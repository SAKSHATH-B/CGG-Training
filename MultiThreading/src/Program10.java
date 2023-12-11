class Producer extends Thread{
    StringBuffer sb;
    Producer(){
        sb=new StringBuffer();
    }
    public void run(){
        synchronized(sb){
            for (int i = 1; i <= 10; i++) {
                try {
                    sb.append(i+" : ");
                    Thread.sleep(100);
                    System.out.println("Appending");
                } catch (InterruptedException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }
            sb.notify();
        }
    }
}
class Consumer extends Thread{
    Producer prod;
    Consumer(Producer prod){
        this.prod = prod;
    }
    public void run(){
        synchronized(prod.sb){
            try {
                prod.sb.wait();
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
            System.out.println(prod.sb);

        }
    }
    
}

public class Program10 {
    public static void main(String[] args) {
        Producer obj1 = new Producer();
        Consumer obj2 = new Consumer(obj1);

        obj1.start();
        obj2.start();
    }
}
