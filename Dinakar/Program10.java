import java.util.Scanner;

public class Program10 {
    static int count=0;
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.println("enter ur strung");
        String s=sc.nextLine();
        System.out.println(s);

        int len=s.length();
        
        


        for (int i = 0; i <len; i++) {
            
            if (s.charAt(i)<s.charAt(i+1))
            {
                continue;
            }
            else{
                 count=1;
                System.out.println("its a negetive string");
                    break;
            }
               
              
        }
        if (count==0)
        System.out.println("its a positive string");
    }
}
