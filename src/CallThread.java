import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class CallThread implements Runnable{
    private Socket socket;
    public CallThread(Socket socket){
        this.socket = socket;
    }
    public void run(){
        try {
            Scanner in = new Scanner(socket.getInputStream());
            PrintWriter out = new PrintWriter(socket.getOutputStream());
            Scanner send = new Scanner(System.in);
            while (true){
                System.out.println("Data is come from client: ");
                System.out.println(in.nextLine());
                System.out.println("Please write what you want to send to client: \n");
                out.println(send.nextLine());
                out.flush();
            }
        } catch (Exception e){}


    }
}
