import java.util.Scanner;

public class Basic{
    public static void main(String[] args){
        Scanner Obj = new Scanner(System.in);
        int p,q,r;
        System.out.print("Enter the first Number : ");
        p = Obj.nextInt();
        
        System.out.print("Enter the Second Number : ");
        q = Obj.nextInt();
        
        System.out.print("Enter the Third Number : ");
        r = Obj.nextInt();
        
        if(p>q && p>r){
            System.out.println(p+" is Greater");
        }
        else if(q>p && q>r){
            System.out.println(q+" is Greater");
        }
        else{
            System.out.println(r+" is Greater");
        }
        

        
    }
}