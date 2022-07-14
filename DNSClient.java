package DNS;

import java.io.*;
import java.net.*;

public class DNSClient
{
        public static void main(String args []) throws Exception
        {
            Socket s = new Socket("localhost",6363);
            OutputStreamWriter os =new OutputStreamWriter(s.getOutputStream());
            PrintWriter out = new PrintWriter(os);
            System.out.println("Enter the domain name:");
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            String domainname=br.readLine();
            out.println(domainname);
            out.flush();
            BufferedReader in = new BufferedReader(new InputStreamReader(s.getInputStream()));
            String ip = in.readLine();
            System.out.println("IP Address of the Domain:"+domainname+"is :"+ip);
            s.close();
        }
}
