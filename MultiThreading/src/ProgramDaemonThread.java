/**
 * ProgramDaemonThread
 */
public class ProgramDaemonThread extends Thread {
  public void run(){
    System.out.println("Entering run method");
    try{
      System.out.println("In run Method: current Thread is: "+Thread.currentThread());
      while (true) {
        try {
          Thread.sleep(500);
        } catch (InterruptedException e) {
          // TODO Auto-generated catch block
          e.printStackTrace();
        }
        System.out.println("In run Method: wokeup again");
        
      }
    }finally{
      System.out.println("Leaving run method");
    }
  }

  public static void main(String[] args) throws InterruptedException {
    System.out.println("Entering main method");
    ProgramDaemonThread t = new ProgramDaemonThread();
    t.setDaemon(true);
    t.start();
    Thread.sleep(3000);
    System.out.println("Leaving main method");
  }
}