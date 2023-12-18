package cgg.defaultandstaticmethods;

import java.util.ArrayList;
import java.util.List;

public class Test {

	public static void main(String[] args) {
		MyInterface myInterface = new MyClass();
        List<Student> stuList=new ArrayList<>();
        stuList.add(new Student("XYZ",20));
        stuList.add(new Student("PQR",16));
        stuList.add(new Student("ABC",26));
        
        List<Student> sortStudents = myInterface.sortStudents(stuList);
        for (Student student : sortStudents) {
			System.out.println(student.getName()+"\t"+student.getAge());
		}
        
        System.out.println("----------------------------------");
        
        List<Integer> intList=new ArrayList<>();
        intList.add(1000);
        intList.add(50);
        intList.add(9000);
        intList.add(90);
        MyInterface.greet("ABC");
        
        System.out.println("--------------------------------------");
        Integer maxNum = myInterface.getMaxNum(intList);
        System.out.println("Max Num : "+maxNum);
	}

}
