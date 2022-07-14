import javax.sql.rowset.spi.SyncResolver;
import java.io.*;
import java.net.*;
import java.util.*;
public class STserver {
    public static void main(String[] args )throws Exception{
       System.out.println("Establish a connection between the client and the server");
       ServerSocket ss=new ServerSocket(9999);
       Socket s=ss.accept();
       System.out.println("The client is connected");
       OutputStreamWriter os=new OutputStreamWriter(s.getOutputStream());
       PrintWriter p=new PrintWriter(os);
       BufferedReader br=new BufferedReader(new InputStreamReader(s.getInputStream()));
       //now reading the data from the receiver
       while(true){
        String datastring=br.readLine();
        if (datastring==null){
            break;
        }
        String data=datastring.substring(0,datastring.length()-1);
        int frame=Integer.parseInt(datastring.substring(datastring.length()-1));
        System.out.println("The data received from the receiver:"+data+"The frmae no:"+frame);
        System.out.println("Acknowledgement to be send is:"+(frame+1)%2);
        p.println(Integer.toString((frame+1)%2));
        p.flush();
       }
       s.close();
       ss.close();
    }
}
