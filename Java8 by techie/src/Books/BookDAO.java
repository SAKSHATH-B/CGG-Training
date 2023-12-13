package Books;

import java.util.ArrayList;
import java.util.List;

public class BookDAO {

  public List<Book> getBooks() {
    List<Book> books = new ArrayList<>();
    books.add(new Book(101, "Core java", 400));
    books.add(new Book(102, "Spring", 180));
    books.add(new Book(103, "React", 200));
    books.add(new Book(104, "Web Services", 300));
    return books;
  }
}
