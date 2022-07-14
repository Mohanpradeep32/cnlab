import java.util.*;
import java.io.*;
import java.net.*;
import java.nio.channels.ServerSocketChannel;
public class selectiveserver {
    static OutputStreamWriter out;
    static PrintWriter p;
    static BufferedReader br;
    public static void receiveframe(int ws)throws Exception{
        int i=1;
        while(i<=ws){
            int fno=Integer.parseInt(br.readLine());
            System.out.println("the received frmae is:"+fno);
            System.out.println("The acknowledgement send to the client is:"+(fno+1));
            i++;
        }
    }
    public static void main(String[] args)throws Exception{
        ServerSocket ss=new ServerSocket(7777);
        Socket s=ss.accept();
        System.out.println("client is connected");
        out=new OutputStreamWriter(s.getOutputStream());
        p=new PrintWriter(out);
        br=new BufferedReader(new InputStreamReader(s.getInputStream()));
        receiveframe(Integer.parseInt(br.readLine()));
        ss.close();
        s.close();
    }  
    
}
