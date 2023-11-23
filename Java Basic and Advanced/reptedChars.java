import java.util.Scanner;

public class reptedChars{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str;
        char a[];
        System.out.print("Enter the String : ");
        str = sc.nextLine();
        a=str.toCharArray();
        char ch;
        System.out.print("Enter the character that you want to search : ");
        ch = sc.next().charAt(0);
        // System.out.println(ch);

        int count=0;

        for (int i = 0; i < a.length; i++) {
            if(a[i]==ch){
                count++;
            }
        }
        System.out.println("The Number of times the character is present in the string is "+count);

    }
}