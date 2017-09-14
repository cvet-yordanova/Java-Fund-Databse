package bookshop_system.app.service.api;

import bookshop_system.app.entities.*;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import javax.transaction.Transactional;
import java.math.BigDecimal;
import java.util.Collection;
import java.util.Date;
import java.util.List;
import java.util.Set;

@Transactional
public interface BookService {

    void save(Book book);
    List<Book> findBookAfterYear();
    List<Book> listBooksFromGPowell();
    List<Book> findAll();
    List<Book> findAllByAgeRestriction(AgeRestriction ageRestriction);
    Integer findCountByTitleGreaterThan(Integer length);
    List<Book> findAllByEditionTypeAndCopiesLessThan(EditionType editionType, int copies);
    List<Book> findAllByPriceLessThanOrPriceGreaterThan(BigDecimal price, BigDecimal price2);
    List<Book> findNotReleasedBooks(Integer year);
    List<Book> selectByCategories( String[] names);
    List<Book> findAllByReleaseDateBefore(Date releaseDate);
    List<Book> findAllByTitleContaining(String pattern);
    List<Book> findByAuthor(String p);
    Integer updateBookCopiesReleasedAfterDate(Integer countCopies,Date date);
    List<Object[]> findAuthorByCountCopies();
    List<Object[]> findBookProfitByCategory();
    List<Object[]> findLatestBooksByCategory(String name);
    List<Object[]> findCategoryAndTotalCountBooks();
    List<ReducedBook> findAllByTitle(String title);
    Integer deleteBooksWithLessCopies(int number);








}
