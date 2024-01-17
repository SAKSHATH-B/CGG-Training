package cgg.springcore.javaconfig;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

// @Component("first student")
public class Student {

  private Samosa samosa;

  public Student(Samosa samosa) {
    this.samosa = samosa;
  }

  public Samosa getSamosa() {
    return samosa;
  }

  public void setSamosa(Samosa samosa) {
    this.samosa = samosa;
  }

  public void study() {
    samosa.display();
    System.out.println("Student is reading book...");
  }
}
