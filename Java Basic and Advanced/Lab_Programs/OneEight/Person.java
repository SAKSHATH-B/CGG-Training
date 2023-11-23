package LabPrograms.OneEight;

import java.util.Scanner;

public class Person {

    public enum Gender{
        M,F;
    }
    


   public Gender setGender() {
        Gender gender1=Gender.M;
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the Gender (M/F): ");
        char g = sc.next().charAt(0);
        if(g == 'M' || g == 'm'){
            gender1 = Gender.M;
        }else if(g == 'F' || g == 'f'){
            gender1 = Gender.F;
        }else{
            System.out.println("Invalid Gender.");
        }
        return gender1;

   }

}
