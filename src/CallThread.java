import java.io.InputStream;
import java.io.ObjectInputStream;
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

            //InputStream in = socket.getInputStream();
            //Object in1 =(Object) in.read();
            //Json in2 = (Json) in1;
            PrintWriter out = new PrintWriter(socket.getOutputStream());
            Scanner send = new Scanner(System.in);
            while (true){
                System.out.println("Data is come from client: ");
                while (in.hasNextLine()){
                    System.out.println(in.nextLine());
                }

                //System.out.println(in2.getUser() + ": " + in2.getMessage());
                System.out.println("Please write what you want to send to client: \n");
                out.println(send.nextLine());
                out.flush();
            }
        } catch (Exception e){}


    }
}
