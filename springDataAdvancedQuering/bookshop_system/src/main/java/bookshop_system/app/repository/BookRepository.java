package bookshop_system.app.repository;

import bookshop_system.app.entities.*;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.Collection;
import java.util.Date;
import java.util.List;
import java.util.Set;

@Repository
@Transactional
public interface BookRepository extends JpaRepository<Book, Long>{
    @Query("SELECT b FROM Book b WHERE (extract(year from b.releaseDate)) > 2000")
    List<Book> findBookAfterYear2000();

    @Query("SELECT b FROM Book AS b WHERE b.author.firstName = 'George' AND b.author.lastName = 'Powell' " +
            "ORDER BY b.releaseDate DESC, b.title")
    List<Book> listBooksFromGPowell();

    List<Book> findAll();

    List<Book> findAllByAgeRestriction(AgeRestriction ageRestriction);

    List<Book> findAllByEditionTypeAndCopiesLessThan(EditionType editionType, int copies);

    @Query("SELECT COUNT(b) FROM Book AS b WHERE LENGTH(b.title) > :length")
    Integer findCountByTitleGreaterThan(@Param("length") Integer length);

    List<Book> findAllByPriceLessThanOrPriceGreaterThan(BigDecimal price, BigDecimal price2);

    @Query("SELECT distinct b FROM Book as b inner join b.categories AS c WHERE c.name in :names")
    List<Book> selectByCategories(@Param("names") String[] names);

    @Query("SELECT b FROM Book AS b WHERE (EXTRACT(year from b.releaseDate)) < :year")
    List<Book> findNotReleasedBooks(@Param("year") Integer year);

    List<Book> findAllByReleaseDateBefore(Date releaseDate);

    List<Book> findAllByTitleContaining(String pattern);

    @Query("SELECT b FROM Book AS b WHERE b.author.lastName like :string ")
    List<Book> findByAuthor(@Param("string") String p);


    @Modifying
    @Query("UPDATE Book AS b SET b.copies = b.copies + :countCopies WHERE b.releaseDate > :date")
    Integer updateBookCopiesReleasedAfterDate(@Param("countCopies") Integer countCopies,@Param("date") Date date);

    @Query("SELECT CONCAT(b.author.firstName,' ',b.author.lastName), SUM(b.copies) FROM Book AS b GROUP BY b.author " +
            "ORDER BY SUM(b.copies) DESC")
    List<Object[]> findAuthorByCountCopies();

    @Query("SELECT SUM(b.copies *  b.price) AS total_profit, c.name\n" +
            "FROM Book as b\n" +
            "INNER JOIN b.categories as c\n" +
            "GROUP BY c.name\n" +
            "ORDER BY total_profit desc")
    List<Object[]> findBookProfitByCategory();


    @Query("SELECT bc.name, count(b.id) \n " +
            "FROM Book AS b\n " +
            "INNER JOIN\n " +
            "b.categories AS bc\n " +
            "GROUP BY bc.name\n " +
            "ORDER BY count(b.id) DESC")
    List<Object[]> findCategoryAndTotalCountBooks();

    @Query("SELECT b.title, EXTRACT(YEAR FROM b.releaseDate) " +
            "FROM Book AS b "+
            "INNER JOIN b.categories AS c "+
            "WHERE c.name  =  :givenName "+
            "ORDER BY b.releaseDate DESC ," +
            "b.title ASC")
    List<Object[]> findLatestBooksByCategory(@Param("givenName") String name);

    List<ReducedBook> findAllByTitle(String title);

    @Modifying
    @Query("DELETE FROM Book AS b WHERE b.copies < :givenNumber")
    Integer deleteBooksWithLessCopies(@Param("givenNumber") int number);


}
