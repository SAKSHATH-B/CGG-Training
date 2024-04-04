public class Program5 {

    public static void main(String[] args) {
        if (args.length != 1) {
            System.out.println("Please provide only one command-line argument.");
            return;
        }
        int number = Integer.parseInt(args[0]);
    if (number > 0) {
        System.out.println("The given number is positive.");
    } else if (number < 0) {
        System.out.println("The given number is negative.");
    } else if(number==0) {
        System.out.println("The given number is zero.");
    }
    else {
    System.out.println("Invalid input. Please provide a valid number.");
     }
    }}
