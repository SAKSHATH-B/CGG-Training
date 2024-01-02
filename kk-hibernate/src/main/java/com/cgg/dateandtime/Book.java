package com.cgg.dateandtime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import java.time.LocalDate;
import java.util.Date;
import org.hibernate.annotations.NaturalId;

@Entity
@Table(name = "book")
public class Book {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "id")
  private long id;

  @Column(name = "title", length = 100)
  private String title;

  @NaturalId
  private String isbn;

  @ManyToOne
  private Person author;

  // @Temporal(value = TemporalType.DATE)
  @Column(name = "published_date")
  // private LocalDate publishedDate;
  private Date publishedDate;

  public Date getPublishedDate() {
    return publishedDate;
  }

  public void setPublishedDate(Date publishedDate) {
    this.publishedDate = publishedDate;
  }

  // public LocalDate getPublishedDate() {
  //   return publishedDate;
  // }

  // public void setPublishedDate(LocalDate publishedDate) {
  //   this.publishedDate = publishedDate;
  // }

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
