import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {

  public static void main(String[] args) throws IOException {
    Socket socket = null;

    InputStreamReader inputStreamReader = null;
    OutputStreamWriter outputStreamWriter = null;
    BufferedReader bufferedReader = null;
    BufferedWriter bufferedWriter = null;

    ServerSocket serverSocket = new ServerSocket(1000);
    while (true) {
      try {
        socket = serverSocket.accept();
        inputStreamReader = new InputStreamReader(socket.getInputStream());
        outputStreamWriter = new OutputStreamWriter(socket.getOutputStream());
        bufferedReader = new BufferedReader(inputStreamReader);
        bufferedWriter = new BufferedWriter(outputStreamWriter);

        while (true) {
          String msgfromclient = bufferedReader.readLine();
          System.out.println("Client: " + msgfromclient);
          bufferedWriter.write("Msg Recieved");
          bufferedWriter.newLine();
          bufferedWriter.flush();

          if (msgfromclient.equalsIgnoreCase("BYE")) break;
        }

        socket.close();
        inputStreamReader.close();
        outputStreamWriter.close();
        bufferedReader.close();
        bufferedWriter.close();
      } catch (IOException e) {
        System.out.println(e.getMessage());
      }
    }
  }
}
