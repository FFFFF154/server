import java.io.IOException;
import java.io.ObjectOutput;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class Client {

    public static void main(String[] args) {
        callServer();
    }
    public static void callServer(){
        try{
            Socket socket = new Socket("127.0.0.1", 8888);
            PrintWriter out = new PrintWriter(socket.getOutputStream());
            Scanner in = new Scanner(socket.getInputStream());
            Scanner send = new Scanner(System.in);
            Json json1 = new Json("user1");
            String message = null;
            while (true){
                System.out.println("Please enter something to send to server: ");
                message = send.nextLine();
                json1.setMessage(message);

                //ObjectOutputStream oos = new ObjectOutputStream()
                out.println(json1);
                //out.println(send.nextLine());
                out.flush();
                String s = in.nextLine();
                System.out.println("Data from server has come: " + s);
            }
        } catch (IOException e){}

    }
}
