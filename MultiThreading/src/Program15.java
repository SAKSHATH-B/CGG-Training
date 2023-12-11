import java.awt.*;

public class Program15 extends Frame implements Runnable {

  String str =
    "195W BACHUPALLY - WAVEROCK via Jntu - HitechCity - Raidurg - GachiBowli - Wipro ";

  Program15() {
    setLayout(null);
    setBackground(Color.CYAN);
    setForeground(Color.RED);
  }

  public void paint(Graphics g) {
    Font f = new Font("Times New Roman", Font.BOLD, 40);
    g.setFont(f);
    g.drawString(str, 10, 200);
  }

  public void run() {
    for (;;) {
      repaint();
      try {
        Thread.sleep(400);
      } catch (Exception e) {
        // TODO: handle exception
      }
      char ch = str.charAt(0);
      str = str.substring(1, str.length());
      str = str + ch;
    }
  }

  public static void main(String[] args) {
    Program15 p = new Program15();
    p.setSize(400, 400);
    p.setTitle("My Banner");
    p.setVisible(true);

    Thread t = new Thread(p);
    t.start();
  }
}
