package cgg.springboot.restapi.springbootrestapi.exceptions;

public class AgeNotValidException extends RuntimeException {

  public AgeNotValidException() {
    super();
  }

  public AgeNotValidException(String message) {
    super(message);
  }
}
