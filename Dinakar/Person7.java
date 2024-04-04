public class Person7 {
    

        public static void main(String[] args) {
            if (args.length != 2) {
                System.out.println("Please provide exactly two command-line arguments: name and phone number.");
                return;
            }
    
            String name = args[0];
            String phoneNumber = args[1];
    
            displayPersonDetails(name, phoneNumber);
        }
    
        public static void displayPersonDetails(String name, String phoneNumber) {
            System.out.println("Person Details:");
            System.out.println("____________");
            System.out.println("Name: " + name);
            System.out.println("Phone Number: " + phoneNumber);
        }
    }
    
