import java.util.*;
class Byte_stuffing{
    public static void main (String [] args){
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the message :");
        String data =sc.nextLine();
        String rem = new String ();
        String output = new String ();
        data = 'F'+data+'F';
        for(int i=0;i<data.length();i++)
        {
            if(data.charAt(i)=='F'&&i!='0'&&i!=(data.length())-1)
            {
                rem=rem+'E'+data.charAt(i);
            }
            else if(data.charAt(i)=='E')
            {
                rem=rem+'E'+data.charAt(i);
            }
            else
            {
                rem=rem+data.charAt(i);
            }
        }
        System.out.println("The Stuffed byte is :"+rem);
        for(int i=0;i<rem.length()-1;i++)
        {
            //if(rem)
        }
        System.out.println("The Destuffed byte is :"+data);
 }
}