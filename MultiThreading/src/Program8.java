class BookTicket extends Thread{
    Object train,comp;
    BookTicket(Object train,Object comp){
        this.train = train;
        this.comp = comp;
    }
    public void run(){
        synchronized(train){
            System.out.println("BookTicket locked on Train");
            try {
                Thread.sleep(150);
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
            System.out.println("BookTicket now waiting to lock on compartment..");
            synchronized(comp){
                System.out.println("BookTicket locked on Compartment");
            }
        }
    }
}
class CancelTicket extends Thread{
    Object train,comp;
    CancelTicket(Object train,Object comp){
        this.train = train;
        this.comp = comp;
    }
    public void run(){
        synchronized(train){
            System.out.println("CancelTicket locked on train");
            try {
                Thread.sleep(200);
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
            System.out.println("CancelTicket now waiting to lock on Compartment...");
            synchronized(comp){
                System.out.println("CancelTicket locked on Compartment");
            }
        }
    }
}

public class Program8 {
    public static void main(String[] args) {
        Object train = new Object();
        Object comp = new Object();

        BookTicket obj1 = new BookTicket(train, comp);
        CancelTicket obj2 = new CancelTicket(train, comp);

        obj1.start();
        obj2.start();        
    }
}
