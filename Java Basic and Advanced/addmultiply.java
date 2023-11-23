import java.util.Scanner;

public class addmultiply {
    public static void main(String[] args) {
        Scanner obj = new Scanner(System.in);
        float a,b,sum=0,prod=0;
        double divi;
        float avg=0;

        System.out.println("Enter the First Number : ");
        a = obj.nextInt();
        System.out.println("Enter the Second Number : ");
        b = obj.nextInt();

        System.out.println("The addition is "+(a+b));
        System.out.println("The product is "+(a*b));
        System.out.println("Division is "+(a/b));
        System.out.println("Average is "+(a/b)/2);
    }
}
