package LabPrograms.OneFifteen;

import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class Lab_1_15 {
    
    public int Age(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the Date of Birth (dd/MM/yyyy):");
        String dob = sc.nextLine();

        DateTimeFormatter d = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        LocalDate ed = LocalDate.parse(dob, d);
        LocalDate cd = LocalDate.now();
        Period period = Period.between(ed, cd);
        int years = period.getYears();

        return years;      
    }
    public String getFullName(String firstName, String lastName){

        return firstName+" "+lastName;

    }
}
