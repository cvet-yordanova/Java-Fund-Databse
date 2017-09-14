package bookshop_system.app.console;

import bookshop_system.app.entities.*;
import bookshop_system.app.service.impl.AuthorServiceImpl;
import bookshop_system.app.service.api.BookService;
import bookshop_system.app.service.impl.CategoryServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.io.BufferedReader;
import java.io.FileReader;
import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.*;

@Component
public class ConsoleRunner implements CommandLineRunner{

    @Autowired
    private final BookService bookServiceImpl;

    @Autowired
    private final CategoryServiceImpl categoryServiceImpl;

    @Autowired
    private final AuthorServiceImpl authorServiceImpl;

    public ConsoleRunner(BookService bookServiceImpl, CategoryServiceImpl categoryServiceImpl, AuthorServiceImpl authorServiceImpl) {
        this.bookServiceImpl = bookServiceImpl;
        this.categoryServiceImpl = categoryServiceImpl;
        this.authorServiceImpl = authorServiceImpl;
    }


    @Override
    public void run(String... strings) throws Exception {

//        System.out.println("----------------------------------------------------------");
//        File file = new File(".");
//        for(String fileNames : file.list()) System.out.println(fileNames);
//        System.out.println("----------------------------------------------------------");

//        BufferedReader authorReader = new BufferedReader(new FileReader("authors.txt"));
//        BufferedReader categoryReader = new BufferedReader(new FileReader("categories.txt"));
//        BufferedReader booksReader = new BufferedReader(new FileReader("books.txt"));
//        String line = authorReader.readLine();
//        while((line = authorReader.readLine()) != null){
//            String[] data = line.split("\\s+");
//
//            String firstName = data[0];
//            String lastName = data[1];
//
//            Author author = new Author();
//            author.setFirstName(firstName);
//            author.setLastName(lastName);
//
//            authorServiceImpl.save(author);
//        }
//
//        line = categoryReader.readLine();
//
//        while((line = categoryReader.readLine()) != null){
//            String data = line;
//
//            Category category = new Category();
//            category.setName(data);
//
//            categoryServiceImpl.save(category);
//        }
//
//        Random random = new Random();
//        List<Author> authors = authorServiceImpl.findAllAuthors();
//        List<Category> categories = categoryServiceImpl.findAllCategories();
//        line = booksReader.readLine();
//        while((line = booksReader.readLine()) != null){
//            String[] data = line.split("\\s+");
//
//            int authorIndex = random.nextInt(authors.size());
//            Author author = authors.get(authorIndex);
//
//            Set<Category> categoriesSet = new HashSet<>();
//            categoriesSet.add(categories.get(random.nextInt(categories.size())));
//            categoriesSet.add(categories.get(random.nextInt(categories.size())));
//            categoriesSet.add(categories.get(random.nextInt(categories.size())));
//
//            EditionType editionType = EditionType.values()[Integer.parseInt(data[0])];
//            SimpleDateFormat formatter = new SimpleDateFormat("d/M/yyyy");
//            Date releaseDate = formatter.parse(data[1]);
//            int copies = Integer.parseInt(data[2]);
//            BigDecimal price = new BigDecimal(data[3]);
//            AgeRestriction ageRestriction = AgeRestriction.values()[Integer.parseInt(data[4])];
//
//            StringBuilder titleBuilder = new StringBuilder();
//            for (int i = 5; i < data.length; i++) {
//                titleBuilder.append(data[i]).append(" ");
//            }
//            titleBuilder.delete(titleBuilder.lastIndexOf(" "), titleBuilder.lastIndexOf(" "));
//            String title = titleBuilder.toString();
//
//            Book book = new Book();
//            book.setAuthor(author);
//            book.setEditionType(editionType);
//            book.setReleaseDate(releaseDate);
//            book.setCopies(copies);
//            book.setPrice(price);
//            book.setAgeRestriction(ageRestriction);
//            book.setTitle(title);
//            book.setCategories(categoriesSet);
//            //TODO add random categories for current book
//
//            bookServiceImpl.save(book);
//        }

        //Write queries
        System.out.println("---3.1---");
        List<Book> booksAfterYear = bookServiceImpl.findBookAfterYear();
        booksAfterYear
                .stream()
                .forEach(a -> System.out.println(a.getReleaseDate() +" "+a.getTitle()));

        System.out.println("---3.2---");
        List<Author> authorsWithBookBefore1990 = authorServiceImpl.findAuthorsWithBookBeforeYear1990();
        authorsWithBookBefore1990.
                stream()
                .forEach(a -> System.out.println(a.getFirstName() +" "+a.getLastName()));

        System.out.println("---3.3---");
        List<Author> authorsOrderedByCountBooksD = authorServiceImpl.allAuthorsOrderByCountDesc();
        authorsOrderedByCountBooksD
                .stream()
                .forEach(a -> System.out.println(a.getFirstName() +" "+a.getLastName()+" "+a.getBooks().size()));

        System.out.println("---3.4---");
        List<Book> booksByGeorgePowell = bookServiceImpl.listBooksFromGPowell();
        booksByGeorgePowell
                .stream()
                .forEach(a -> System.out.println(a.getTitle() +" "+a.getReleaseDate()+" "+a.getCopies()));

        // Add related books
        List<Book> books = (List<Book>) bookServiceImpl.findAll();
        List<Book> threeBooks = books.subList(0, 3);

        threeBooks.get(0).setRelatedBooks(threeBooks);
        threeBooks.get(1).setRelatedBooks(threeBooks);
        threeBooks.get(2).setRelatedBooks(threeBooks);

        //save related books to the database

        for (Book book : threeBooks) {
            bookServiceImpl.save(book);
        }

        for (Book book : threeBooks) {
            System.out.printf("--%s\n", book.getTitle());
            for (Book relatedBook : book.getRelatedBooks()) {
                System.out.println(relatedBook.getTitle());
            }
        }




    }
}
