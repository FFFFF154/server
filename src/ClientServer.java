import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

public class ClientServer {
    private List<Socket> socketList;
    public void callClient(){
        int i = 0;
        socketList = new ArrayList<>();
        try(ServerSocket serverSocket = new ServerSocket(8888)){
            while (true){
                socketList.add(serverSocket.accept());
                System.out.println(socketList.get(i).getInetAddress());
                (new Thread(new CallThread(socketList.get(i)))).start();
                i++;
            }

//            if (input.isConnected()){ //хуйня
//                (new Thread(new CallThread(input))).start();
//            }



        } catch (IOException e){
            System.err.println("АТАТА");
        }

    }
}
