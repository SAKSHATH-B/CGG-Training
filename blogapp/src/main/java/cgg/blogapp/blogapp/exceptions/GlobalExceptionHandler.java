package cgg.blogapp.blogapp.exceptions;

import cgg.blogapp.blogapp.payloads.APIResponse;
import java.util.HashMap;
import java.util.Map;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

  @ExceptionHandler(ResourceNotFoundException.class)
  public ResponseEntity<APIResponse> handleReourceNotFoundException(
    ResourceNotFoundException ex
  ) {
    return new ResponseEntity<APIResponse>(
      new APIResponse(ex.getMessage(), false),
      HttpStatus.NOT_FOUND
    );
  }

  @ExceptionHandler(MethodArgumentNotValidException.class)
  public ResponseEntity<Map<String, String>> methodArgumentNotValidHandler(
    MethodArgumentNotValidException ex
  ) {
    Map<String, String> response = new HashMap<>();
    ex
      .getBindingResult()
      .getAllErrors()
      .forEach(error -> {
        String fieldName = ((FieldError) error).getField();
        String message = error.getDefaultMessage();
        response.put(fieldName, message);
      });
    return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
  }
}
