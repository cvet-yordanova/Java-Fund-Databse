package bookshop_system.app.service.impl;

import bookshop_system.app.entities.Author;
import bookshop_system.app.repository.AuthorRepository;
import bookshop_system.app.service.api.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class AuthorServiceImpl implements AuthorService{

    @Autowired
    private final AuthorRepository authorRepository;

    public AuthorServiceImpl(AuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
    }

    @Override
    public void save(Author author) {
        authorRepository.save(author);
    }

    @Override
    public List<Author> findAllAuthors() {
        return authorRepository.findAll();
    }

    @Override
    public List<Author> findAuthorsWithBookBeforeYear1990() {
        return authorRepository.findAuthorsWithBookBeforeYear1990();
    }

    @Override
    public List<Author> allAuthorsOrderByCountDesc() {
        return authorRepository.listAuthorsByBooksCountDesc();
    }

    @Override
    public List<Author> findAllByFirstNameEndingWith(String str) {
        return authorRepository.findAllByFirstNameEndingWith(str);
    }
}
