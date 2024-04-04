import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class Personmain_6 {
    public static void main(String[] args) 
    {

     Person oppenheimer =new Person("robert","oppenheimer",'m');
     
     oppenheimer.setDob("01/01/2021");

     oppenheimer.calcAge();

     String s1=oppenheimer.getFullName("karengula","dinakar");

     System.out.println(s1);
     
    }
}


class Person{
     public String firstName;
     public String lastname;
     public String Dob;

   
      public void setDob(String dob) {
        Dob = dob;
    }







    public int calcAge(){
        String sa=Dob;
        DateTimeFormatter d1=DateTimeFormatter.ofPattern("dd/MM/yyyy");
        LocalDate d2=LocalDate.parse(sa, d1);
        LocalDate d3=LocalDate.now();

        Period p1=Period.between(d2, d3);
        int age=p1.getYears();
        System.out.println("THE AGE IS "+age);

        return age;

        


      }

     





      public String getFirstName() {
        return firstName;
    }
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

      public String getLastname() {
        return lastname;
    }
    public void setLastname(String lastname) {
        this.lastname = lastname;
    }
    char gender='m';
    public char getGender() {
        return gender;
    }
    public void setGender(char gender) {
        this.gender = gender;
    }
    public String getFullName(String s1,String s2) {
        String ss=s1;
        String sd=s2;
        return (ss+" "+sd);

        
    }



    Person(String a,String b,char c)
    {
        this.firstName=a;
        this.lastname=b;
        this.gender=c;
    }
}