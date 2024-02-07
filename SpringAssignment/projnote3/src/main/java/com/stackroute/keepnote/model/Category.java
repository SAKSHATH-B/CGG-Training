package com.stackroute.keepnote.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import java.time.LocalDateTime;
import java.util.List;

@Entity
public class Category {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private int categoryId;

  private String categoryName;
  private String categoryDescription;
  private int categoryCreatedBy;
  private final LocalDateTime categoryCreationDate = LocalDateTime.now();

  @OneToMany(mappedBy = "category")
  private List<Note> notes;

  public Category(
    int categoryId,
    String categoryName,
    String categoryDescription,
    int categoryCreatedBy,
    List<Note> notes
  ) {
    this.categoryId = categoryId;
    this.categoryName = categoryName;
    this.categoryDescription = categoryDescription;
    this.categoryCreatedBy = categoryCreatedBy;
    this.notes = notes;
  }

  public Category() {}

  public int getCategoryId() {
    return categoryId;
  }

  public void setCategoryId(int categoryId) {
    this.categoryId = categoryId;
  }

  public String getCategoryName() {
    return categoryName;
  }

  public void setCategoryName(String categoryName) {
    this.categoryName = categoryName;
  }

  public String getCategoryDescription() {
    return categoryDescription;
  }

  public void setCategoryDescription(String categoryDescription) {
    this.categoryDescription = categoryDescription;
  }

  public int getCategoryCreatedBy() {
    return categoryCreatedBy;
  }

  public void setCategoryCreatedBy(int categoryCreatedBy) {
    this.categoryCreatedBy = categoryCreatedBy;
  }

  public LocalDateTime getCategoryCreationDate() {
    return categoryCreationDate;
  }

  public List<Note> getNotes() {
    return notes;
  }

  public void setNotes(List<Note> notes) {
    this.notes = notes;
  }

  @Override
  public String toString() {
    return (
      "Category [categoryId=" +
      categoryId +
      ", categoryName=" +
      categoryName +
      ", categoryDescription=" +
      categoryDescription +
      ", categoryCreatedBy=" +
      categoryCreatedBy +
      ", categoryCreationDate=" +
      categoryCreationDate +
      ", notes=" +
      notes +
      "]"
    );
  }
}
