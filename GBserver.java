import java.util.*;
import java.io.*;
import java.net.*;
public class GBserver {
    static BufferedReader br;
    public static void receiverframe(int ws)throws Exception{
        int i=1;
        while(i<=ws){
            int fno=Integer.parseInt(br.readLine());
            System.out.println("The received frame is:"+fno);
            System.out.println("The acknowledgement sent is:"+(fno+1));
            i++;
        }
    }
    public static void main(String[] args)throws Exception{
        ServerSocket ss=new ServerSocket(8888);
        Socket s=ss.accept();
        OutputStreamWriter out=new OutputStreamWriter(s.getOutputStream());
        System.out.println("the receiver has been connected");
        PrintWriter p=new PrintWriter(out);
        br=new BufferedReader(new InputStreamReader(s.getInputStream()));
        Scanner sc=new Scanner(System.in);
        //function to receive frames
        receiverframe(Integer.parseInt(br.readLine()));
        s.close();
        ss.close();
    }
}
