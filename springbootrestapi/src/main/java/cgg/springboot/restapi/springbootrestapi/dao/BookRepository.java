package cgg.springboot.restapi.springbootrestapi.dao;

import cgg.springboot.restapi.springbootrestapi.entities.Book;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookRepository extends CrudRepository<Book, Integer> {}
