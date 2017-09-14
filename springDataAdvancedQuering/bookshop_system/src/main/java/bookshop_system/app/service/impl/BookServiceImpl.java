package bookshop_system.app.service.impl;

import bookshop_system.app.entities.*;
import bookshop_system.app.repository.BookRepository;
import bookshop_system.app.service.api.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.Collection;
import java.util.Date;
import java.util.List;
import java.util.Set;

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

    @Override
    public List<Book> findAllByAgeRestriction(AgeRestriction ageRestriction) {
        return bookRepository.findAllByAgeRestriction(ageRestriction);
    }

    @Override
    public Integer findCountByTitleGreaterThan(Integer length) {
        return bookRepository.findCountByTitleGreaterThan(length);
    }

    @Override
    public List<Book> findAllByEditionTypeAndCopiesLessThan(EditionType editionType, int copies) {
        return bookRepository.findAllByEditionTypeAndCopiesLessThan(editionType, copies);
    }

    @Override
    public List<Book> findAllByPriceLessThanOrPriceGreaterThan(BigDecimal price, BigDecimal price2) {
        return bookRepository.findAllByPriceLessThanOrPriceGreaterThan(price, price2);
    }

    @Override
    public List<Book> findNotReleasedBooks(Integer year) {
        return bookRepository.findNotReleasedBooks(year);
    }

    @Override
    public List<Book> selectByCategories(String[] names) {
        return bookRepository.selectByCategories(names);
    }

    @Override
    public List<Book> findAllByReleaseDateBefore(Date releaseDate) {
        return bookRepository.findAllByReleaseDateBefore(releaseDate);
    }

    @Override
    public List<Book> findAllByTitleContaining(String pattern) {
        return bookRepository.findAllByTitleContaining(pattern);
    }

    @Override
    public List<Book> findByAuthor(String p) {
        return bookRepository.findByAuthor(p+"%");
    }

    @Override
    @Transactional
    @Modifying
    public Integer updateBookCopiesReleasedAfterDate(Integer countCopies, Date date) {
        return bookRepository.updateBookCopiesReleasedAfterDate(countCopies, date);
    }

    @Override
    public List<Object[]> findAuthorByCountCopies() {
        return bookRepository.findAuthorByCountCopies();
    }

    @Override
    public List<Object[]> findBookProfitByCategory() {
        return bookRepository.findBookProfitByCategory();
    }

    @Override
    public List<Object[]> findLatestBooksByCategory(String name) {
        return bookRepository.findLatestBooksByCategory(name);
    }

    @Override
    public List<Object[]> findCategoryAndTotalCountBooks() {
        return bookRepository.findCategoryAndTotalCountBooks();
    }

    @Override
    public List<ReducedBook> findAllByTitle(String title) {
        return bookRepository.findAllByTitle(title);
    }

    @Override
    public Integer deleteBooksWithLessCopies(int number) {
        return bookRepository.deleteBooksWithLessCopies(number);
    }
}
