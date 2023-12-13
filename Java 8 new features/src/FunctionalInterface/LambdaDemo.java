package FunctionalInterface;

public class LambdaDemo {

  public static void main(String[] args) {
    Runnable r = () -> System.out.println("This is Lambda Runnable");

    Thread thread = new Thread(r);
    thread.start();
  }
}
