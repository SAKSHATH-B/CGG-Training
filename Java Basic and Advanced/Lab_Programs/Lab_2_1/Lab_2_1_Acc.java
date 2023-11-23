package LabPrograms.Lab_2_1;

import java.util.Scanner;

public class Lab_2_1_Acc {
    long accNum;
    double balance;
    Person accHolder;

    public void deposit(double dep){
        balance += dep;
        System.out.println("The Updated balance after depositing "+dep+" is : "+balance);
    }
    public void withdraw(double wid){
        balance -= wid;
        System.out.println("The Updated balance after Withdrawing "+wid+" is : "+balance);
    }
    public double getBalance(){
        return balance;
    }

    public long getAccNum() {
        return accNum;
    }
    public void setAccNum(long accNum) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the account number : ");
        this.accNum = sc.nextLong();
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }


    class Person{
    String name;
    float age;

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public float getAge() {
        return age;
    }
    public void setAge(float age) {
        this.age = age;
    }

    public void meth1(){
        System.out.println("   ");
    }
}


public static void main(String[] args) {
    Lab_2_1_Acc ob1 = new Lab_2_1_Acc();
    ob1.
    
}
}



