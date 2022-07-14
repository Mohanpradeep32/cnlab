import java.util.*;
import java.io.*;
import java.net.*;
public class udpclient {
    public static void main(String[] args)throws Exception{
        Scanner sc=new Scanner(System.in);
        InetAddress ip=InetAddress.getByName("localhost");
        DatagramSocket ds=new DatagramSocket();
        while(true){
            byte[] sbuffer=new byte[1024];
            byte[] rebuffer=new byte[1024];
            System.out.println("cleint..");
            //declare a string and read the data to the client
            String clientd=sc.nextLine();
            //now convert the data that is entered to the byte format
            sbuffer=clientd.getBytes();
            //now create the datapacket which is used to send the the message to the server
            DatagramPacket dp=new DatagramPacket(sbuffer, sbuffer.length,ip,9999);
            //now send the data using the send function  
            ds.send(dp);
            if(clientd.equals("stop")){
                System.out.println("The connection is terminated by the client");
                break;
            }
            
            //now print the received data
            DatagramPacket rdata=new DatagramPacket(rebuffer, rebuffer.length);
            ds.receive(rdata);
            String receivedata=new String(rdata.getData());
            System.out.println("The data from server is:"+receivedata);
        }
        ds.close();
    }
    
}