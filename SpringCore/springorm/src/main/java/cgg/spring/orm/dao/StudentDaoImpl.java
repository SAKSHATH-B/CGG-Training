package cgg.spring.orm.dao;

import cgg.spring.orm.entities.Student;
import java.util.List;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Component;

@Component("studentDao")
public class StudentDaoImpl implements StudentDao {

  @Override
  public int createStudent(Student student) {
    // TODO Auto-generated method stub
    throw new UnsupportedOperationException("Unimplemented method 'createStudent'");
  }

  @Override
  public void update(Student student) {
    // TODO Auto-generated method stub
    throw new UnsupportedOperationException("Unimplemented method 'update'");
  }

  @Override
  public void delete(int id) {
    // TODO Auto-generated method stub
    throw new UnsupportedOperationException("Unimplemented method 'delete'");
  }

  @Override
  public Student getStudentById(int id) {
    // TODO Auto-generated method stub
    throw new UnsupportedOperationException("Unimplemented method 'getStudentById'");
  }

  @Override
  public List<Student> getAllStudents() {
    // TODO Auto-generated method stub
    throw new UnsupportedOperationException("Unimplemented method 'getAllStudents'");
  }

  // @Autowired
  // private HibernateTemplate hibernateTemplate;

  // public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
  //   this.hibernateTemplate = hibernateTemplate;
  // }

  // //save student
  // @Override
  // @Transactional
  // public int createStudent(Student student) {
  //   Integer i = (Integer) hibernateTemplate.save(student);
  //   return i;
  // }

  // @Override
  // @Transactional
  // public void update(Student student) {
  //   hibernateTemplate.update(student);
  // }

  // @Override
  // @Transactional
  // public void delete(int id) {
  //   Student student = hibernateTemplate.get(Student.class, id);
  //   hibernateTemplate.delete(student);
  // }

  // @Override
  // @Transactional
  // public Student getStudentById(int id) {
  //   Student student = hibernateTemplate.get(Student.class, id);
  //   return student;
  // }

  // @Override
  // @Transactional
  // public List<Student> getAllStudents() {
  //   return hibernateTemplate.loadAll(Student.class);
  // }
}
