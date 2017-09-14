package bookshop_system.app.repository;

import bookshop_system.app.entities.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@Transactional
public interface BookRepository extends JpaRepository<Book, Long>{
    @Query("SELECT b FROM Book b WHERE (extract(year from b.releaseDate)) > 2000")
    List<Book> findBookAfterYear2000();

    @Query("SELECT b FROM Book AS b WHERE b.author.firstName = 'George' AND b.author.lastName = 'Powell' " +
            "ORDER BY b.releaseDate DESC, b.title")
    List<Book> listBooksFromGPowell();

    List<Book> findAll();
}
