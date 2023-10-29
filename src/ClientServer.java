import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class ClientServer {

    public void callClient(){
        try(ServerSocket serverSocket = new ServerSocket(8888)){
            Socket input = serverSocket.accept();
            (new Thread(new CallThread(input))).start();


        } catch (IOException e){
            System.err.println("АТАТА");
        }

    }
}
