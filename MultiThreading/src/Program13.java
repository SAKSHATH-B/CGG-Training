import java.io.IOException;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;

class MultiServer implements Runnable {

  static ServerSocket ss;
  static Socket s;

  public void run() {
    String name = Thread.currentThread().getName();
    for (;;) {
      try {
        System.out.println("Thread " + name + " ready to accept...");
        s = ss.accept();
        System.out.println("Thread " + name + " accepted a connection");
        PrintStream ps = new PrintStream(s.getOutputStream());
        ps.println("Thread " + name + " Contacted you.");
        ps.close();
        s.close();
      } catch (IOException e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
      }
    }
  }

  public static void main(String[] args) throws IOException {
    MultiServer ms = new MultiServer();
    ss = new ServerSocket(999);

    Thread t1 = new Thread(ms, "one");
    Thread t2 = new Thread(ms, "Two");

    t1.start();
    t2.start();
  }
}
