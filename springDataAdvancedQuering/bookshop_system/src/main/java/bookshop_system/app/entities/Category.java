package bookshop_system.app.entities;


import org.springframework.beans.factory.annotation.Required;

import javax.persistence.*;
import java.util.List;
import java.util.Set;

@Entity
public class Category {
    private Long id;
    private String name;
    private Set<Book> books;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Column(name = "name", nullable = false)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @ManyToMany //(cascade = CascadeType.ALL, mappedBy = "categories")
    public Set<Book> getBooks() {
        return books;
    }

    public void setBooks(Set<Book> books) {
        this.books = books;
    }
}
