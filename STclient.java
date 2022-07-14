import java.util.*;
import java.io.*;
import java.net.*;
public class STclient {
    public static void main(String[] args)throws Exception{
        Socket s=new Socket("localhost",9999);
        System.out.println("Client connected to server");
        OutputStreamWriter os=new OutputStreamWriter(s.getOutputStream());
        PrintWriter p=new PrintWriter(os);
        BufferedReader br=new BufferedReader(new InputStreamReader(s.getInputStream()));
        int n;
        Scanner sc=new Scanner(System.in);
        String[] data=new String[10];
        //enter no of frames
        n=sc.nextInt();
        System.out.println("Enter  frames is:"+n);
        //enter the data into the data array
        for(int i=0;i<n;i++){
            data[i]=sc.nextLine();
        }
        //now sending data to the server
        int frameNo=1;
        int i=0;
        int ackno;
        do{
            frameNo--;
            System.out.println("sending "+data[i]+" frame no:"+frameNo);
            //converting the frameno from integer to string
            p.println(data[i]+Integer.toString(frameNo));
            p.flush();
            i++;frameNo++;
            Thread.sleep(500);
            ackno=Integer.parseInt(br.readLine());
            System.out.println("The ackno number received from the server is:"+ackno);
        }while((ackno==frameNo) && i<n);
        s.close();
    }
}
