package cgg.spring.jdbc.dao;

import cgg.spring.jdbc.entities.Student;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

@Component("studentDao")
public class StudentDaoImpl implements StudentDao {

  @Autowired
  private JdbcTemplate jdbcTemplate;

  public JdbcTemplate getJdbcTemplate() {
    return jdbcTemplate;
  }

  public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
    this.jdbcTemplate = jdbcTemplate;
  }

  // @Autowired
  // private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

  // public NamedParameterJdbcTemplate getNamedParameterJdbcTemplate() {
  //   return namedParameterJdbcTemplate;
  // }

  // public void setNamedParameterJdbcTemplate(
  //   NamedParameterJdbcTemplate namedParameterJdbcTemplate
  // ) {
  //   this.namedParameterJdbcTemplate = namedParameterJdbcTemplate;
  // }

  @Override
  public int saveStudent(Student s) {
    String query = "insert into student values(?,?,?)";

    int result = jdbcTemplate.update(
      query,
      s.getId(),
      s.getName(),
      s.getCity()
    );
    return result;
  }

  @Override
  public int updateUser(Student s) {
    String query = "update student set name=?,city=? where id=?";

    int result = jdbcTemplate.update(
      query,
      s.getName(),
      s.getCity(),
      s.getId()
    );
    return result;
  }

  @Override
  public int deleteUser(int id) {
    String query = "delete from student where id=:id";
    int result = jdbcTemplate.update(query, id);
    return result;
  }

  @Override
  public Student getStudent(int id) {
    String query = "select * from student where id=:id";
    RowMapper<Student> rowMapper = new RowMapperImpl();
    Student student = jdbcTemplate.queryForObject(query, rowMapper, id);
    return student;
  }

  //by using lambda exp for romapperimpl
  @Override
  public List<Student> getAllStudents() {
    String query = "select * from student";
    List<Student> students = jdbcTemplate.query(
      query,
      (rs, rowNum) -> {
        Student student = new Student();
        student.setId(rs.getInt(1));
        student.setName(rs.getString(2));
        student.setCity(rs.getString(3));
        return student;
      }
    );
    return students;
  }
}
