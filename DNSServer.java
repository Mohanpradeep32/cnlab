package DNS;
import java.util.*;
import java.io.*;
import java.net.*;

public class DNSServer
{
        public static void main(String args []) throws Exception
        {
            String [] domainnames = {"www.amazon.in","www.apple.com","www.flipkart.com","www.google.com"};
            String [] ipaddress = {"52.95.120.67","17.253.144.10","163.53.78.110","173.194.198.139"};
            ServerSocket ss = new ServerSocket(6363);
            //outputStreamWriter os =new outputStreamWriter(s.getOutputStream());
            //PrintWriter out = new PrintWriter(os);
            System.out.println("Server is running ");
            System.out.println("waiting client to connect ");
            Socket s=ss.accept();
            BufferedReader br = new BufferedReader(new InputStreamReader(s.getInputStream()));
            String domainname=br.readLine();
            System.out.println("Domain name received is "+domainname);
           for(int i=0;i<domainnames.length;i++){
            if(domainname.equals(domainnames[i]))
            {
                OutputStreamWriter os=new OutputStreamWriter(s.getOutputStream());
                PrintWriter out=new PrintWriter(os);
                out.println(ipaddress[i]);
                out.flush();
                break;
            }
           }
           s.close();
           ss.close();
        }
}
