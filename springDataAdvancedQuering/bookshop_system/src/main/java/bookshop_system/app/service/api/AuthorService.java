package bookshop_system.app.service.api;


import bookshop_system.app.entities.Author;
import bookshop_system.app.repository.AuthorRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public interface AuthorService {

    void save(Author author);
    List<Author> findAllAuthors();
    List<Author> findAuthorsWithBookBeforeYear1990();
    List<Author> allAuthorsOrderByCountDesc();
    List<Author> findAllByFirstNameEndingWith(String str);
}
