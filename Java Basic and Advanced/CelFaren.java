import java.util.Scanner;

public class CelFaren {
    public static void main(String[] args) {
        Scanner ob = new Scanner(System.in);
        double far,cel;
        System.out.println("Enter the Temperature in Farenheit : ");
        far = ob.nextFloat();
        cel = (5.0/9.0)*(far-32);
        System.out.println("The Temperature in Celsius is : "+cel);
        }
}
