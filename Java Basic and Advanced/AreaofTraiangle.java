import java.util.Scanner;
import java.lang.*;

public class AreaofTraiangle {
    public void Abc(){
        System.out.println("Hello");
    }
    public static void main(String[] args) {
        Scanner area = new Scanner(System.in);
        int a,b,c;
        double Area,s;
        
        System.out.println("Enter the values for three sides : ");
        a = area.nextInt();
        b = area.nextInt();
        c = area.nextInt();
        s = (a+b+c)/2;
        System.out.println(s);
        Area = Math.sqrt(s*(s-a)*(s-b)*(s-c));
        System.err.println("Area is "+Area);

    AreaofTraiangle obj = new AreaofTraiangle();
    obj.Abc();
    }


}

