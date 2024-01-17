package cgg.spring.jdbc;

import cgg.spring.jdbc.config.JdbcConfig;
import cgg.spring.jdbc.dao.StudentDao;
import cgg.spring.jdbc.entities.Student;
import java.util.List;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;

/**
 * Hello world!
 *
 */
public class App {

  public static void main(String[] args) {
    // ApplicationContext context = new ClassPathXmlApplicationContext(
    //   "spring.xml"
    // );
    ApplicationContext context = new AnnotationConfigApplicationContext(
      JdbcConfig.class
    );
    StudentDao studentDao = context.getBean("studentDao", StudentDao.class);
    //insert

    Student student = new Student();
    student.setId(6);
    student.setName("Muthinel");
    student.setCity("Kerala");

    int res = studentDao.saveStudent(student);
    System.out.println(res + " records inserted...");
    //update

    // Student student = new Student();
    // student.setName("Madhav");
    // student.setCity("Mancherial");
    // student.setId(2);
    // int res = studentDao.updateUser(student);
    // System.out.println(res + " rows updated...");

    //delete

    // int res = studentDao.deleteUser(4);
    // System.out.println(res + " records deleted...");

    //fetch by id

    // Student student = studentDao.getStudent(4);
    // System.out.println(student);

    //fetch all students

    List<Student> allStudents = studentDao.getAllStudents();
    allStudents.forEach(System.out::println);
  }
}
