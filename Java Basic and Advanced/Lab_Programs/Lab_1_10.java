package LabPrograms;

import java.util.Scanner;


public class Lab_1_10 {
    public static boolean Lab(String str){
        for(int i=0 ; i<=str.length() ; i++){
            if(str.charAt(i) < str.charAt(i+1)){
                return true;
            }
        }
        return false;

    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the String : ");
        String s = sc.nextLine();
        
        Lab_1_10 ob = new Lab_1_10();
        // ob.Lab(s);
        System.out.println(ob.Lab(s));
    }
    
}
