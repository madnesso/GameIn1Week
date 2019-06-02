import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class Serverr {
    public static void main(String[] args) throws IOException {

        ServerSocket ss=new ServerSocket(9000);
        Socket ClientSocket=new Socket();
        System.out.println("Waiting for Client " );
        ClientSocket=ss.accept();
        System.out.println("Client Connected " + ClientSocket.toString());
        OutputStream os=ClientSocket.getOutputStream();
        InputStream is=ClientSocket.getInputStream();
        PrintWriter pw=new PrintWriter(os,true);
        pw.write("Hello Client");
        pw.close();
        ClientSocket.close();
        ss.close();



    }

}
