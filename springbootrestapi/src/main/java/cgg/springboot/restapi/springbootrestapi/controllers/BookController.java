package cgg.springboot.restapi.springbootrestapi.controllers;

import cgg.springboot.restapi.springbootrestapi.entities.Book;
import cgg.springboot.restapi.springbootrestapi.services.BookService;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BookController {

  @Autowired
  private BookService bookService;

  @GetMapping("/books")
  public ResponseEntity<List<Book>> getBooks() {
    List<Book> books = bookService.getBooks();
    if (books.size() <= 0) {
      return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }
    return ResponseEntity.of(Optional.of(books));
  }

  @GetMapping("/books/{bookId}")
  public ResponseEntity<Book> getBook(@PathVariable("bookId") int id) {
    Optional<Book> book = null;
    book = bookService.getBook(id);
    if (book == null) {
      return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }
    return ResponseEntity.of(book);
  }

  @PostMapping("/books")
  public ResponseEntity<Book> addBook(@RequestBody Book b) {
    Book book = null;
    try {
      book = bookService.addBook(b);
      return ResponseEntity.status(HttpStatus.CREATED).body(book);
    } catch (Exception e) {
      e.printStackTrace();
      return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
    }
  }

  @PutMapping("/books/{bookId}")
  public ResponseEntity<Book> updateBook(
    @RequestBody Book b,
    @PathVariable("bookId") int id
  ) {
    try {
      this.bookService.updateBook(b, id);
      return ResponseEntity.ok().body(b);
    } catch (Exception e) {
      e.printStackTrace();
      return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
    }
  }

  @DeleteMapping("/books/{bookId}")
  public ResponseEntity<Void> deleteBook(@PathVariable("bookId") int id) {
    try {
      this.bookService.deleteBook(id);
      return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    } catch (Exception e) {
      e.printStackTrace();
      return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
    }
  }

  @DeleteMapping("/books")
  public ResponseEntity<Void> deleteAll() {
    try {
      this.bookService.deleteAll();
      return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    } catch (Exception e) {
      e.printStackTrace();
      return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
    }
  }
}
