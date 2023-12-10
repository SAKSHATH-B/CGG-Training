class Thr implements Runnable{
    String name;
    public Thr(String name){
        this.name = name;
    }
    public void run(){

    }
}

public class FifthThreadConstRunnable {
    public static void main(String[] args) {
        Thr t = new Thr("RunnableThread");
        Thread a = new Thread(t, t.name);
        a.start();
        System.out.println("Thread id: "+ a.getId());
        System.out.println("Thread name: "+a.getName());
    }
}
