package cgg.sma.client;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import cgg.sma.dao.StudentDAO;
import cgg.sma.model.Student;

public class StudentManage {

	public static void main(String[] args) {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Welcome to student management application");
		while(true) {
			System.out.println("Press 1 to Add Student");
			System.out.println("Press 2 to Update Student");
			System.out.println("Press 3 to Delete Student");
			System.out.println("Press 4 to Display All Students");
			System.out.println("Press 5 to Exit");
			
			System.out.println("Enter your choice: ");
			try {
				int ch= Integer.parseInt(br.readLine());
				
				if(ch==1) {
					//add student...
				System.out.println("Enter student name");
				String name=br.readLine();
				System.out.println("Enter student phone no");
				String pno=br.readLine();
				System.out.println("Enter student city");
				String city=br.readLine();
				//create student object to store student
				Student student = new Student(name,pno,city);
				System.out.println(student);
				boolean ans = StudentDAO.insertStudentToDB(student);
				
				if(ans==true) {
					System.out.println("Student Added Successfully..");
				}
				else {
					System.out.println("Something went wrong...");
				}
				}
				else if(ch==2) {
					//update student ....
				}
				else if(ch==3) {
					//delete student
					System.out.println("Enter student id to delete");
					int userId=Integer.parseInt(br.readLine());
					boolean f = StudentDAO.deleteStudent(userId);
					if(f) {
						System.out.println("Deleted.....");
					}
					else {
						System.out.println("Something went wrong....");
					}
					
				}
				else if(ch==4) {
					//display student
					StudentDAO.showAllStudents();
				}
				else if(ch==5) {
					//exit
					break;
				}
			} catch (NumberFormatException | IOException e) {
				 e.printStackTrace();
			}
		}
		System.out.println("Thank You for using this app");
		System.out.println("see you soon ... bye bye");
	}

}
