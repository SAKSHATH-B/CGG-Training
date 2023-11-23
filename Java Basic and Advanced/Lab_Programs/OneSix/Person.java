package LabPrograms.OneSix;

// import java.util.Scanner;

public class Person {

    Person(){
        System.out.println("This is the Default Constructor.");
    }
    Person(String Fname,String Lname,char i,long PhNum){
        firstName = Fname;
        lastName = Lname;
        Gender = i;
        PhoneNumber = PhNum;
    }
    // Exercise - 1.7 creating a method
    public void meth(){
        System.out.println("Person Details:\n____________\n");
        System.out.println("First name : "+getFirstName());
        System.out.println("Last name: "+getLastName());
        System.out.println("Gender: "+getGenderr());
        System.out.println("Phone Number: "+getPhoneNumber());
    }

    // public enum Gender{
    //     M,F
    // }
    // public void Gender(){
    //     Scanner sc = new Scanner(System.in);
    //     System.out.println("Enter the Gender as M/F.");
    //     char Gen = sc.next().charAt(0);
    //     Gender H;
    //     if(Gen == 'M' || Gen == 'm'){
    //         H = Gender.M;
    //     }else if(Gen == 'F' || Gen == 'f'){
    //         H = Gender.F;
    //     }else{
    //         System.out.println("Enter Gender as M/F only.");
    //     }

    // }

    String firstName, lastName;
    char Gender;
    // public Gender getGenderr() {
    //     return Genderr;
    // }
    // public void setGenderr(Gender genderr) {
    //     Genderr = genderr;
    // }

    public char getGenderr() {
        return Gender;
    }
    public void setGenderr(char genderr) {
        Gender = genderr;
    }

    long PhoneNumber;

    public long getPhoneNumber() {
        return PhoneNumber;
    }
    public void setPhoneNumber(long phoneNumber) {
        PhoneNumber = phoneNumber;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

}
