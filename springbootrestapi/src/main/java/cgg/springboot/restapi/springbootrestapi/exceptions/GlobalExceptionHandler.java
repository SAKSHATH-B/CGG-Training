package cgg.springboot.restapi.springbootrestapi.exceptions;

import java.net.URI;
import org.springframework.http.HttpStatus;
import org.springframework.http.ProblemDetail;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

  //handler for age not valid exception
  @ExceptionHandler(AgeNotValidException.class)
  public ResponseEntity<ProblemDetail> ageNotValidHandler(
    AgeNotValidException e
  ) {
    ProblemDetail pd = ProblemDetail.forStatus(
      HttpStatus.INTERNAL_SERVER_ERROR
    );
    pd.setTitle("age not valid error");
    pd.setDetail("Provided age is not valid to cast vote");
    pd.setType(URI.create("http://localhost:4477/errors"));
    pd.setProperty("host", "localhost");
    pd.setProperty("port", "4477");
    ///
    return ResponseEntity.of(pd).build();
  }
}
