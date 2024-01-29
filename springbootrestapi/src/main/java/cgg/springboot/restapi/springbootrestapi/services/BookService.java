package cgg.springboot.restapi.springbootrestapi.services;

import cgg.springboot.restapi.springbootrestapi.entities.Book;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import org.springframework.stereotype.Service;

@Service
public class BookService {

  private static List<Book> books = new ArrayList<>();

  static {
    books.add(new Book(5, "Java Head First", "ABC"));
    books.add(new Book(12, "Java Complete Reference", "XYZ"));
    books.add(new Book(1212, "Jthink in Java", "PQR"));
  }

  //get all books
  public List<Book> getBooks() {
    return books;
  }

  //get single book
  public Optional<Book> getBook(int id) {
    return books.stream().filter(b -> b.getBookId() == id).findFirst();
  }

  //adding a book
  public Book addBook(Book b) {
    books.add(b);
    return b;
  }

  //updating book
  public void updateBook(Book b, int id) {
    boolean bookUpdated = false;
    for (Book book : books) {
      if (book.getBookId() == id) {
        book.setTitle(b.getTitle());
        book.setAuthor(b.getAuthor());
        bookUpdated = true;
        break;
      }
    }
    if (!bookUpdated) {
      throw new IllegalArgumentException("Book with ID " + id + " not found");
    }
    // books
    //   .stream()
    //   .map(book -> {
    //     if (book.getBookId() == id) {
    //       book.setTitle(b.getTitle());
    //       book.setAuthor(b.getAuthor());
    //     }
    //     return book;
    //   })
    //   .collect(Collectors.toList());
  }

  //delete single book
  public void deleteBook(int id) {
    books =
      books
        .stream()
        .filter(b -> b.getBookId() != id)
        .collect(Collectors.toList());
  }

  //delete all books
  public void deleteAll() {
    books.removeAll(books);
  }
}
