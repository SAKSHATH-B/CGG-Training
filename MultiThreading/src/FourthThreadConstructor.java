class MyThr extends Thread{
    public MyThr(String name){
        super(name);
    }
    public void run(){
        // while (true) {
        //     System.out.println("I am a Thread");
        // }
    }
}

public class FourthThreadConstructor {
    public static void main(String[] args) {
        MyThr t = new MyThr("Harry");
        t.start();
        System.out.println("Id of this thread: "+ t.getId());
        System.out.println("name of this thread: "+ t.getName());
    }
}
