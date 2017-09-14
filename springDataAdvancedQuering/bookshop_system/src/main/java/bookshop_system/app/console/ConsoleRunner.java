package bookshop_system.app.console;

import bookshop_system.app.entities.*;
import bookshop_system.app.service.impl.AuthorServiceImpl;
import bookshop_system.app.service.api.BookService;
import bookshop_system.app.service.impl.CategoryServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.stereotype.Component;

import javax.transaction.Transactional;
import java.io.*;
import java.math.BigDecimal;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.util.stream.Collectors;

@Component
@Transactional
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

        //SeedData();
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));


        //1
//
//        System.out.println("Enter age restriction.");
//        String enumerationInput = reader.readLine();
//        AgeRestriction restriction = AgeRestriction.valueOf(enumerationInput.toUpperCase());
//
//        List<Book> booksByAgeRestriction = bookServiceImpl.findAllByAgeRestriction(restriction);
//
//        for (Book book : booksByAgeRestriction) {
//            System.out.println(book.getTitle());
//        }

        //2
//        System.out.println("Enter edition type for the book.");
//        String input = reader.readLine();
//        EditionType editionType = EditionType.valueOf(input.toUpperCase());
//        System.out.println("Enter count copies.");
//        int countCopies = Integer.parseInt(reader.readLine());
//
//        List<Book> booksWithEditionTypeAndCountCopies = (bookServiceImpl.findAllByEditionTypeAndCopiesLessThan(editionType, countCopies));
//
//        for (Book b : booksWithEditionTypeAndCountCopies) {
//            System.out.println(b.getTitle());
//        }

        //3

//        System.out.println("Enter price 1:");
//        BigDecimal price1 = new BigDecimal(reader.readLine());
//        System.out.println("Enter price 2:");
//        BigDecimal price2 = new BigDecimal(reader.readLine());
//
//        List<Book> booksWithPriceLowerOrHigher = bookServiceImpl.findAllByPriceLessThanOrPriceGreaterThan(price1, price2);
//
//        for (Book book : booksWithPriceLowerOrHigher) {
//            System.out.println(book.getTitle()+" $"+book.getPrice());
//        }

        //4

//        System.out.println("Enter year:");
//        Integer year = Integer.parseInt(reader.readLine());
//        List<Book> notReleasedBooksBeforeYear = bookServiceImpl.findNotReleasedBooks(year);
//
//        for (Book book : notReleasedBooksBeforeYear) {
//            System.out.println(book.getTitle());
//        }

        //5

//        System.out.println("Enter categories.");
//        String[] categories = reader.readLine().split("\\s");
//        List<Book> booksWithCategories = bookServiceImpl.selectByCategories(categories);
//
//        System.out.println(booksWithCategories.size());
//        for (Book b : booksWithCategories) {
//            System.out.println(b.getTitle());
//            for (Category category : b.getCategories()) {
//                System.out.println("---"+category.getName());
//            }
//        }

        //6

//        System.out.println("Enter date in format dd-MM-yyyy");
//        SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
//        Date dateInput = formatter.parse(reader.readLine());
//        List<Book> booksReleasedBeforeYear = bookServiceImpl.findAllByReleaseDateBefore(dateInput);
//
//        for (Book book : booksReleasedBeforeYear) {
//            System.out.println(book.getTitle()+" "+book.getReleaseDate()+" "+book.getEditionType().name()+" $"+book.getPrice());
//        }

        //7

//        System.out.println("Enter pattern for the name.");
//        String pattern = reader.readLine();
//        List<Author> authorsWithFirstNameEndingWith = authorServiceImpl.findAllByFirstNameEndingWith(pattern);
//
//        for (Author author : authorsWithFirstNameEndingWith) {
//            System.out.println(author.getFirstName());
//        }

        //8

//        System.out.println("Enter pattern.");
//        String pattern1 = reader.readLine();
//
//        List<Book> bookWithTitleContaing = bookServiceImpl.findAllByTitleContaining(pattern1);
//
//        for (Book book : bookWithTitleContaing) {
//            System.out.println(book.getTitle());
//        }

        //9

//        System.out.println("Enter pattern.");
//        List<Book> bookByAuthorWithLastNameStartingWith = bookServiceImpl.findByAuthor(reader.readLine());
//
//        for (Book book : bookByAuthorWithLastNameStartingWith) {
//            System.out.println(book.getTitle()+" ("+book.getAuthor().getFirstName()+" "+book.getAuthor().getLastName()+")");
//        }

        //10

//        System.out.println("Enter length for the book title.");
//        int length = Integer.parseInt(reader.readLine());
//        int countBooksWithGivenTitleLength = (bookServiceImpl.findCountByTitleGreaterThan(length));
//        System.out.println(countBooksWithGivenTitleLength+" book's title's length is greater than "+length);

        //11
//        System.out.println("Authors by count copies.");
//        List<Object[]> list = bookServiceImpl.findAuthorByCountCopies();
//
//        for (Object[] objects : list) {
//            System.out.println(objects[0] + " "+ objects[1] +" copies.");
//        }


        //12

//        System.out.println("Book's profit by category.");
//        List<Object[]> booksByProfit = bookServiceImpl.findBookProfitByCategory();
//
//        for (Object[] objects : booksByProfit) {
//            System.out.println(objects[1]+" $"+objects[0]);
//        }

        //13

//
//        List<Object[]> categoriesAndTotalBooks = bookServiceImpl.findCategoryAndTotalCountBooks();
//        LinkedHashMap<String,List<Object[]>> CategoryAndLatestBooks = new LinkedHashMap<>();
//
//        for (Object[] c : categoriesAndTotalBooks) {
//            List<Object[]> latestBooksFromCategory = bookServiceImpl.findLatestBooksByCategory((String)c[0]).subList(0,3);
//            CategoryAndLatestBooks.put("Genre: "+c[0]+" Total books: "+c[1], latestBooksFromCategory );
//        }
//
//        for (Map.Entry<String, List<Object[]>> stringListEntry : CategoryAndLatestBooks.entrySet()) {
//            System.out.println(stringListEntry.getKey());
//            for (Object[] o : stringListEntry.getValue()) {
//                System.out.println("--"+o[0]+" ("+o[1]+")");
//            }
//        }

        //14

//        System.out.println("Enter title:");
//            String givenTitle = reader.readLine();
//            List<ReducedBook> reducedBooksByTitle = bookServiceImpl.findAllByTitle(givenTitle);
//
//
//        for (ReducedBook reducedBook : reducedBooksByTitle) {
//            System.out.printf("%s %s %s %s\n",
//                    reducedBook.getTitle(),
//                    reducedBook.getEditionType(),
//                    reducedBook.getAgeRestriction(),
//                    reducedBook.getPrice());
//        }
        //15



//
//        SimpleDateFormat format2 = new SimpleDateFormat("dd-MMM-yyyy");
//        format2.setTimeZone(TimeZone.getTimeZone("BG"));
//        System.out.println("Enter date:");
//        String date = reader.readLine();
//        System.out.println(date);
//        System.out.println("Enter number of copies to add.");
//        Integer copies = Integer.parseInt(reader.readLine());
//        Date givenDate = format2.parse(date);
//        Integer updatedRows = bookServiceImpl.updateBookCopiesReleasedAfterDate(copies, givenDate);
//
//        System.out.println(updatedRows * copies +" copies were added.");

        //16

//        System.out.println("Enter number: ");
//        int number = Integer.parseInt(reader.readLine());
//        Integer result = bookServiceImpl.deleteBooksWithLessCopies(number);
//        System.out.println(result+" books were deleted.");






    }

    private void checkDirectory() {
        System.out.println("----------------------------------------------------------");
        File file = new File(".");
        for(String fileNames : file.list()) System.out.println(fileNames);
        System.out.println("----------------------------------------------------------");
    }

    private void addRelatedBooks() {
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

    private void writeQueries() {
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
    }

    private void SeedData() throws IOException, ParseException {
        BufferedReader authorReader = new BufferedReader(new FileReader("authors.txt"));
        BufferedReader categoryReader = new BufferedReader(new FileReader("categories.txt"));
        BufferedReader booksReader = new BufferedReader(new FileReader("books.txt"));
        String line = authorReader.readLine();
        while((line = authorReader.readLine()) != null){
            String[] data = line.split("\\s+");

            String firstName = data[0];
            String lastName = data[1];

            Author author = new Author();
            author.setFirstName(firstName);
            author.setLastName(lastName);

            authorServiceImpl.save(author);
        }

        line = categoryReader.readLine();

        while((line = categoryReader.readLine()) != null){
            String data = line;

            Category category = new Category();
            category.setName(data);

            categoryServiceImpl.save(category);
        }

        Random random = new Random();
        List<Author> authors = authorServiceImpl.findAllAuthors();
        List<Category> categories = categoryServiceImpl.findAllCategories();
        line = booksReader.readLine();
        while((line = booksReader.readLine()) != null){
            String[] data = line.split("\\s+");

            int authorIndex = random.nextInt(authors.size());
            Author author = authors.get(authorIndex);

            Set<Category> categoriesSet = new HashSet<>();
            categoriesSet.add(categories.get(random.nextInt(categories.size())));
            categoriesSet.add(categories.get(random.nextInt(categories.size())));
            categoriesSet.add(categories.get(random.nextInt(categories.size())));

            EditionType editionType = EditionType.values()[Integer.parseInt(data[0])];
            SimpleDateFormat formatter = new SimpleDateFormat("d/M/yyyy");
            Date releaseDate = formatter.parse(data[1]);
            int copies = Integer.parseInt(data[2]);
            BigDecimal price = new BigDecimal(data[3]);
            AgeRestriction ageRestriction = AgeRestriction.values()[Integer.parseInt(data[4])];

            StringBuilder titleBuilder = new StringBuilder();
            for (int i = 5; i < data.length; i++) {
                titleBuilder.append(data[i]).append(" ");
            }
            titleBuilder.delete(titleBuilder.lastIndexOf(" "), titleBuilder.lastIndexOf(" "));
            String title = titleBuilder.toString();

            Book book = new Book();
            book.setAuthor(author);
            book.setEditionType(editionType);
            book.setReleaseDate(releaseDate);
            book.setCopies(copies);
            book.setPrice(price);
            book.setAgeRestriction(ageRestriction);
            book.setTitle(title);
            book.setCategories(categoriesSet);
            //TODO add random categories for current book

            bookServiceImpl.save(book);
        }
    }
}
