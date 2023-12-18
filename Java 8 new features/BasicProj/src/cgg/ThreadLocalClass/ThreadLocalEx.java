package cgg.ThreadLocalClass;

public class ThreadLocalEx {

  public static void main(String[] args) {
    // ThreadLocal<String> threadLocal = new ThreadLocal<>();
    // threadLocal.set("This is localThread variable");
    // String val = threadLocal.get();
    // System.out.println(val);

    // ThreadLocalDemo r = new ThreadLocalDemo();

    // Thread thread1 = new Thread(r, "Thread1");
    // Thread thread2 = new Thread(r, "Thread2");
    // Thread thread3 = new Thread(r, "Thread3");

    // thread1.start();
    // thread2.start();
    // thread3.start();

    ThreadLocalDemo2 s = new ThreadLocalDemo2();
    Thread thread1 = new Thread(s, "Thread1");
    Thread thread2 = new Thread(s, "Thread2");

    thread1.start();
    thread2.start();
  }
}
