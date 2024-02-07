package cgg.springboot.restapi.springbootrestapi.entities;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "books")
@Data
public class Book {

  @Id
  @GeneratedValue
  @Column(name = "book_id")
  private int bookId;

  private String title;

  // private String author;
  @OneToOne(cascade = CascadeType.ALL)
  @JsonManagedReference
  private Author author;
}
