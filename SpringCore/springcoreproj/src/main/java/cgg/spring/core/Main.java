package cgg.spring.core;

import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {

  public static void main(String[] args) {
    ApplicationContext context = new ClassPathXmlApplicationContext(
      "newXml.xml"
    );

    // OrgInfo bean = context.getBean("orgInfo", OrgInfo.class);
    // Student[] stuArr = bean.getStuArr();
    // for (Student student : stuArr) {
    //   System.out.println(student);
    // }
    // System.out.println("======================");
    // List<Student> stuList = bean.getStuList();
    // stuList.forEach(System.out::println);
    // System.out.println("======================");
    // Set<Student> stuSet = bean.getStuSet();
    // stuSet.forEach(System.out::println);

    CompanyInfo bean = context.getBean("companyInfo", CompanyInfo.class);

    Set<Entry<Integer, String>> entrySet = bean.getEmpIdAndNameMap().entrySet();
    entrySet.forEach(System.out::println);

    System.out.println(
      "======================================================"
    );

    Set<Entry<Integer, Student>> entrySet2 = bean.getStudentIdMap().entrySet();
    for (Entry<Integer, Student> entry : entrySet2) {
      System.out.println(entry.getKey());
      Student student = entry.getValue();
      System.out.println(student);
    }
  }
}
