import java.util.Scanner;

public class addarray {
    public static void main(String[] args) {
        int arr[] = new int[5];
        Scanner sc = new Scanner(System.in);
        for(int i=0;i<5;i++){
            System.out.println("Enter an integer : ");
            arr[i] = sc.nextInt();
        }
        int sum=0;
        for (int j = 0; j < arr.length; j++) {
            sum=sum+arr[j];
        }

        System.out.println("Total is : "+sum);
    }
}
