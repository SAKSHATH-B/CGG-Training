package cgg.spring.orm;

import cgg.spring.orm.config.JavaConfig;
import cgg.spring.orm.dao.StudentDao;
import cgg.spring.orm.entities.Student;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.List;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App {

  public static void main(String[] args) {
    // ApplicationContext context = new ClassPathXmlApplicationContext(
    //   "spring.xml"
    // );
    AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(
      JavaConfig.class
    );
    StudentDao studentDao = context.getBean("studentDao", StudentDao.class);

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    boolean go = true;
    while (go) {
      System.out.println("PRESS 1 for add new student");
      System.out.println("PRESS 2 for display all students");
      System.out.println("PRESS 3 get detail of single student");
      System.out.println("PRESS 4 for delete student");
      System.out.println("PRESS 5 for update student");
      System.out.println("PRESS 6 for exit");

      try {
        int input = Integer.parseInt(br.readLine());
        switch (input) {
          case 1:
            //INSERT
            System.out.println("Enter Student id : ");
            int id = Integer.parseInt(br.readLine());
            System.out.println("Enter Student Name : ");
            String name = br.readLine();
            System.out.println("Enter Student City : ");
            String city = br.readLine();

            Student student = new Student();
            student.setId(id);
            student.setName(name);
            student.setCity(city);
            studentDao.createStudent(student);
            System.out.println("Student added...");
            System.out.println("=================================");
            break;
          case 2:
            //DISPLAY ALL STUDENTS
            List<Student> allStudents = studentDao.getAllStudents();
            for (Student st : allStudents) {
              System.out.println("Id : " + st.getId());
              System.out.println("Name : " + st.getName());
              System.out.println("City : " + st.getCity());
              System.out.println("______________________________________");
            }
            System.out.println(
              "**********************************************"
            );
            break;
          case 3:
            //get single student data
            System.out.println("Enter user id: ");
            int userId = Integer.parseInt(br.readLine());
            Student std = studentDao.getStudentById(userId);
            System.out.println("Id : " + std.getId());
            System.out.println("Name : " + std.getName());
            System.out.println("City : " + std.getCity());
            System.out.println("______________________________________");
            break;
          case 4:
            //delete student
            System.out.println("Enter user id: ");
            id = Integer.parseInt(br.readLine());
            studentDao.delete(id);
            System.out.println("Student deleted.....");
            break;
          case 5:
            //update student
            System.out.println("Enter existing user id: ");
            id = Integer.parseInt(br.readLine());

            System.out.println("Enter user name: ");
            String newname = br.readLine();

            System.out.println("Enter user city: ");
            String newcity = br.readLine();

            student = studentDao.getStudentById(id);
            student.setName(newname);
            student.setCity(newcity);

            studentDao.update(student);
            System.out.println("student updated");
            System.out.println("************************************");
            System.out.println();
            break;
          case 6:
            //exit
            go = false;
            break;
        }
      } catch (Exception e) {
        System.out.println("Invalid input try with another one !!");
        System.out.println(e.getMessage());
      }
    }
    System.out.println("Thankyou for using my application");
    System.out.println("See you soon !!");
  }
}
