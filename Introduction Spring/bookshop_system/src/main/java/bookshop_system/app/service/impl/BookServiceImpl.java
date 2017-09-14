package bookshop_system.app.service.impl;

import bookshop_system.app.entities.Book;
import bookshop_system.app.repository.BookRepository;
import bookshop_system.app.service.api.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class BookServiceImpl implements BookService {

    @Autowired
    private final BookRepository bookRepository;

    public BookServiceImpl(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @Override
    public void save(Book book) {
        bookRepository.save(book);
    }

    @Override
    public List<Book> findBookAfterYear() {
        return bookRepository.findBookAfterYear2000();
    }

    @Override
    public List<Book> listBooksFromGPowell() {
        return bookRepository.listBooksFromGPowell();
    }

    @Override
    public List<Book> findAll() {
        return bookRepository.findAll();
    }
}
