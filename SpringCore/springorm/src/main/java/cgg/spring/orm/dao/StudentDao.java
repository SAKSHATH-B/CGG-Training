package cgg.spring.orm.dao;

import cgg.spring.orm.entities.Student;
import java.util.List;

public interface StudentDao {
  int createStudent(Student student);
  void update(Student student);
  void delete(int id);
  Student getStudentById(int id);
  List<Student> getAllStudents();
}
