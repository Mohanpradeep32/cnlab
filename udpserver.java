import java.util.*;
import java.io.*;
import java.net.*;
public class udpserver{
    public static void main(String[] args)throws Exception{
        Scanner sc=new Scanner(System.in);
        DatagramSocket ds=new DatagramSocket(9999);
        while(true){
            byte[] receivedata=new byte[1024];
            byte[] senddata=new byte[1024];
            DatagramPacket dp=new DatagramPacket(receivedata,receivedata.length);
            ds.receive(dp);
            InetAddress ip=dp.getAddress();
            int port=dp.getPort();
            //now create a string and store the data that is get from the client
            String clientdata=new String(dp.getData());
            System.out.println("From client:"+clientdata);
            System.out.println("Server..");


            //now enter some data from the console and then send it to the client
            String serverdata=sc.nextLine();
            senddata=serverdata.getBytes();
            DatagramPacket sdata=new DatagramPacket(senddata, senddata.length,ip,port);
            ds.send(sdata);
            if(serverdata.equals("stop")){
                System.out.println("the server is terminated");
                break;
            }
        }
        ds.close();
    }
}