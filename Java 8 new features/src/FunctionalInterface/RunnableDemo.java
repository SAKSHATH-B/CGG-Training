package FunctionalInterface;

public class RunnableDemo {

  public static void main(String[] args) {
    Runnable r = new Runnable() {
      @Override
      public void run() {
        System.out.println("My Runnable");
      }
    };

    Thread thread = new Thread(r);
    thread.start();
  }
}
