package com.cgg.MoreAnnotations.NaturalID;

import jakarta.persistence.Column;
import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;
import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;
import org.hibernate.annotations.Immutable;
import org.hibernate.annotations.NaturalId;

@Entity
@Table(
  name = "book",
  uniqueConstraints = @UniqueConstraint(
    name = "duplicate_error",
    columnNames = { "title", "isbn" }
  )
)
public class Book {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "id")
  private long id;

  @Column(name = "title", length = 100)
  @Immutable
  @ColumnDefault("N/A")
  private String title;

  @NaturalId(mutable = true)
  // @Embedded
  // @NaturalId
  // private Isbn isbn;
  private String isbn;

  // public Isbn getIsbn() {
  //   return isbn;
  // }

  // public void setIsbn(Isbn isbn) {
  //   this.isbn = isbn;
  // }

  @ManyToOne
  private Person author;

  public long getId() {
    return id;
  }

  public void setId(long id) {
    this.id = id;
  }

  public String getTitle() {
    return title;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  public String getIsbn() {
    return isbn;
  }

  public void setIsbn(String isbn) {
    this.isbn = isbn;
  }

  public Person getAuthor() {
    return author;
  }

  public void setAuthor(Person author) {
    this.author = author;
  }
}
