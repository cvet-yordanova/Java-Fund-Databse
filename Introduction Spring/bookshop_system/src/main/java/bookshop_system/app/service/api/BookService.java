package bookshop_system.app.service.api;

import bookshop_system.app.entities.Book;
import org.springframework.data.jpa.repository.Query;

import java.util.List;


public interface BookService {

    void save(Book book);
    List<Book> findBookAfterYear();
    List<Book> listBooksFromGPowell();
    List<Book> findAll();
}
