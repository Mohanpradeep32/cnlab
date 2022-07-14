import java.util.*;
import java.io.*;
import java.net.*;
public class GBreceiver{
    static OutputStreamWriter out;
    static PrintWriter p;
    static BufferedReader br;
    public static void Sendframe(int s,int ws)throws Exception{
        int i=s;
        while(i<=ws){
            System.out.println("sending frame:"+i);
            p.println(i);
            p.flush();
            i++;
        }
    }
    public static void main(String[] args)throws Exception{
         Socket s=new Socket("localhost",8888);
         System.out.println("The client has been connected to the server");
         out=new OutputStreamWriter(s.getOutputStream());
         p=new PrintWriter(out);
         br=new BufferedReader(new InputStreamReader(s.getInputStream()));
         Scanner sc=new Scanner(System.in);
         //Enter the window size
         int ws=sc.nextInt();
         p.println(ws);
         p.flush();
         Sendframe(1,ws);
         //resending the frame
         System.out.println("Resending frame is:");
         int res=sc.nextInt();
         Sendframe(res,ws);
         s.close();
    }
}
