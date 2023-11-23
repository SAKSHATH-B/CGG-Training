package LabPrograms;

import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class Lab_1_11{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the Date(dd/MM/yyyy) : ");
        String a = sc.nextLine();

        DateTimeFormatter d = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        LocalDate ed = LocalDate.parse(a,d);
        LocalDate cd = LocalDate.now();

        Period period = Period.between(ed, cd);
        int years = period.getYears();
        int months = period.getMonths();
        int days = period.getDays();

        System.out.println("Duration is : "+years+" years "+months+" months "+days+" days.");

        
    }
}



