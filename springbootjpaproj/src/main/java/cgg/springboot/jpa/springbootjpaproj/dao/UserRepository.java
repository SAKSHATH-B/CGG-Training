package cgg.springboot.jpa.springbootjpaproj.dao;

import cgg.springboot.jpa.springbootjpaproj.entities.User;
import java.util.List;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

public interface UserRepository extends CrudRepository<User, Integer> {
  public List<User> findByName(String name);

  public List<User> findByNameAndCity(String name, String city);

  @Query("select u from User u")
  public List<User> getAllUsers();

  @Query("select u from User u where u.name=:x")
  public List<User> getUsersByName(@Param("x") String name);

  @Query("select u from User u where u.name=:y and u.city=:z")
  public List<User> getUsersByNameAndCity(
    @Param("y") String name,
    @Param("z") String city
  );

  @Query(value = "select * from user1", nativeQuery = true)
  public List<User> getUsers();
}
