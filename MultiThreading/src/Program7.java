class Reserve1 implements Runnable{
    int available=1;
    int wanted;

    Reserve1(int i){
        wanted=i;
    }

    public void run(){
        synchronized(this){
            System.out.println("Available Berths= "+available);
            if(available>=wanted){
                String name = Thread.currentThread().getName();
                System.out.println(wanted+" Berths reserved for "+name);
                try {
                    Thread.sleep(1000);
                    available = available - wanted;
                } catch (InterruptedException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }else{
                System.out.println("Sorry, no berths");
            }
        }
    }
}

public class Program7 {
    public static void main(String[] args) throws InterruptedException {
        Reserve1 obj = new Reserve1(1);

        Thread t1 = new Thread(obj);
        Thread t2 = new Thread(obj);

        t1.setName("First Person");
        t2.setName("Second Person");

        t1.start();
        t2.start();
    }
}
