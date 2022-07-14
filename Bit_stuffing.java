import java.util.*;
class Bit_stuffing{
    public  static void main (String args[]){
        Scanner sc =new Scanner(System.in);
        System.out.println("Enter message :");
        String d1=sc.nextLine();
        String remaining = new String ();
        String output = new String ();
        int count=0;
        for(int i=0;i<d1.length();i++){
            if(d1.charAt(i)!='1'&&d1.charAt(i)!='0')
            {
                System.out.println("enter valid values");
            }
            else if(d1.charAt(i)=='1')
            {
                count++;
                remaining=remaining+d1.charAt(i);
            }
            else{
                remaining=remaining+d1.charAt(i);
                count=0;
            }
            if(count==5)
            {
                remaining=remaining+'0';
                count=0;
            }
           
        }
        System.out.println("Stuffed data is:"+remaining);
        for(int i=0;i<remaining.length();i++)
        {
            if(remaining.charAt(i)=='1')
            {
                count++;
                output=output+remaining.charAt(i);

            }
            else{
                output=output+remaining.charAt(i);
                count=0;
            }
            if(count==5)
            {
                if((i+2)!=remaining.length())
                {
                    output=output+remaining.charAt(i+2);
                }
                else{
                    output=output+'1';
                }
                i=i+2;
                count=1;
            }
        }
        System.out.println("destuffed bit is:"+d1);
    }
}