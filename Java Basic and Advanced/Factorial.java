import java.util.Scanner;

public class Factorial{
    public static int factorial(int n){
        if(n<0){
            throw new IllegalArgumentException("Factorial is not derived for Negative Integers.");
        }
        if(n==0 || n==1){
            return n;
        }
        return n * factorial(n-1);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the Number : ");
        int number = sc.nextInt();

        int a = factorial(number);
        
        System.out.println("The Factorial of "+number+" is : "+a);
    }
}