import java.util.Scanner;

public class Program4 {
    public enum Gender{
        M,F
    }

    public static Gender setGender()
    {
        Scanner sc=new Scanner(System.in);
        Gender gender=Gender.M;

       
            System.out.print("Enter gender (M/F): ");
            char input = sc.next().charAt(0);
            
            if (input == 'M' || input == 'm') {
                gender = Gender.M;
               
            } else if (input == 'F' || input == 'f') {
                gender = Gender.F;
               
            } else {
                System.out.println("Invalid input. Please enter 'M' or 'F'.");
            }
        

        return gender;
    }

    
    public static void main(String[] args) {
        // Initialize person details
        String firstName = "Divya";
        String lastName = "Bharathi";
        Gender gender = setGender();
        int age = 20;
      

        // Print person details in the specified format
        System.out.println("Person Details:");
        System.out.println("____________");
        System.out.println("First Name: " + firstName);
        System.out.println("Last Name: " + lastName);
        System.out.println("Gender: " + gender);
        System.out.println("Age: " + age);
       
    }
}
