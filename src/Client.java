import java.io.IOException;
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
            while (true){
                System.out.println("Please enter something to send to server: ");
                out.println(send.nextLine());
                out.flush();
                String s = in.nextLine();
                System.out.println("Data from server has come: " + s);
            }
        } catch (IOException e){}

    }
}
