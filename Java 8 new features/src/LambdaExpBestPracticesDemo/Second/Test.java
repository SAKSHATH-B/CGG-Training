package LambdaExpBestPracticesDemo.Second;

public class Test {

  public static void main(String[] args) {
    //whenever we try to use a functional interface we should not create a anonymous class of that interface and overRide the methods present in that interface but make to write a lambda expression

    // Runnable runnable = new Runnable() {
    //   @Override
    //   public void run() {
    //     System.out.println("My Task");
    //   }
    // };

    Runnable r = () -> System.out.println("Hello Task");

    // Thread t1 = new Thread(runnable);
    Thread t1 = new Thread(r);
    t1.start();
  }
}
