package cgg.spring.jdbc.dao;

import cgg.spring.jdbc.entities.Student;
import java.util.List;

public interface StudentDao {
  int saveStudent(Student s);
  int updateUser(Student s);
  int deleteUser(int id);
  Student getStudent(int id);
  List<Student> getAllStudents();
}
