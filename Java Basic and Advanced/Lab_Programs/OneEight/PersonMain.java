package LabPrograms.OneEight;

import LabPrograms.OneEight.Person.Gender;



public class PersonMain {

    public static void main(String[] args) {
        Person obj = new Person();
        String Firstname = "Divya";
        String Lastname = "Bharathi";
        Gender gender = obj.setGender();
        long PhoneNumber = 9238478436l;

        System.out.println("Person Details: ");
        System.out.println("______________");
        System.out.println("First name: "+Firstname);
        System.out.println("Lastname: "+Lastname);
        System.out.println("Gender: "+gender);
        System.out.println("Phone Number: "+PhoneNumber);

    }
}
