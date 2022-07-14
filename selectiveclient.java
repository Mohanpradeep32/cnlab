import java.util.*;
import java.io.*;
import java.net.*;
public class selectiveclient {
    static OutputStreamWriter out;
    static PrintWriter p;
    static BufferedReader br;
    public static void sendframe(int s ,int ws)throws Exception{
        int i=s;
        while(i<=ws){
            System.out.println("The send frame:"+i);
            p.println(i);
            p.flush();
            i++;
        }
    }
    public static void resend(int res)throws Exception{
        System.out.println("The sending frame is:"+res);
        p.println(res);
        p.flush();
    }
    public static void main(String[] args)throws Exception{
       Socket s=new Socket("localhost",7777);
       System.out.println("Client is connected to the server");
       out=new OutputStreamWriter(s.getOutputStream());
        p=new PrintWriter(out);
        br=new BufferedReader(new InputStreamReader(s.getInputStream()));
        Scanner sc=new Scanner(System.in);
        int ws=sc.nextInt();
        p.println(ws);
        p.flush();
        sendframe(1,ws);

        //enter the resending frame
        System.out.println("The send that is to be resend is:");
        int r=sc.nextInt();
        resend(r);
        s.close();
    }
    
}
