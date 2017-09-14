package bookshop_system.app.repository;

import bookshop_system.app.entities.Author;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AuthorRepository extends JpaRepository<Author, Long> {

    @Query("SELECT a\n" +
            "FROM Author as a\n" +
            "WHERE a.id IN\n" +
            "\t(SELECT b.author.id\n" +
            "\tFROM Book as b\n" +
            "\tWHERE extract(year from b.releaseDate) < 1990 )")
    List<Author> findAuthorsWithBookBeforeYear1990();

    @Query("SELECT a\n" +
            "FROM Author AS a\n" +
            "ORDER BY a.books.size\n" +
            "DESC")
    List<Author> listAuthorsByBooksCountDesc();
}
