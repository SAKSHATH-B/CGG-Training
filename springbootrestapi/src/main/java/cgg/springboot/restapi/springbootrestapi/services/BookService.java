package cgg.springboot.restapi.springbootrestapi.services;

import cgg.springboot.restapi.springbootrestapi.dao.BookRepository;
import cgg.springboot.restapi.springbootrestapi.entities.Book;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BookService {

  // private static List<Book> books = new ArrayList<>();

  @Autowired
  private BookRepository bookRepository;

  // static {
  //   books.add(new Book(5, "Java Head First", "ABC"));
  //   books.add(new Book(12, "Java Complete Reference", "XYZ"));
  //   books.add(new Book(1212, "Jthink in Java", "PQR"));
  // }

  //get all books
  public List<Book> getBooks() {
    List<Book> books = (List<Book>) bookRepository.findAll();
    return books;
  }

  //get single book
  public Book getBook(int id) {
    Book book = null;
    try {
      book = bookRepository.findById(id).get();
    } catch (Exception e) {
      e.printStackTrace();
    }
    return book;
    // return books.stream().filter(b -> b.getBookId() == id).findFirst();
  }

  //adding a book
  public Book addBook(Book b) {
    return bookRepository.save(b);
    // books.add(b);
    // return b;
  }

  //updating book
  public void updateBook(Book b, int id) {
    Book bk = bookRepository.findById(id).get();
    bk.setTitle(b.getTitle());
    bk.setAuthor(b.getAuthor());
    bookRepository.save(bk);
    // boolean bookUpdated = false;
    // for (Book book : books) {
    //   if (book.getBookId() == id) {
    //     book.setTitle(b.getTitle());
    //     book.setAuthor(b.getAuthor());
    //     bookUpdated = true;
    //     break;
    //   }
    // }
    // if (!bookUpdated) {
    //   throw new IllegalArgumentException("Book with ID " + id + " not found");
    // }
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
    bookRepository.deleteById(id);
    // books =
    //   books
    //     .stream()
    //     .filter(b -> b.getBookId() != id)
    //     .collect(Collectors.toList());
  }

  //delete all books
  public void deleteAll() {
    bookRepository.deleteAll();
    // books.removeAll(books);
  }
}
