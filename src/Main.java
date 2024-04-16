import com.workintech.aaaaaaaaaaaaaaaaa.Author;
import com.workintech.aaaaaaaaaaaaaaaaa.Book;
import com.workintech.aaaaaaaaaaaaaaaaa.Genre;
import com.workintech.aaaaaaaaaaaaaaaaa.Library;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        Author author1 = new Author("Ernest Cline", new HashSet<>());
        Set<Author> authorList1 = new HashSet<>();
        authorList1.add(author1);
        Set<Genre> genreList1 = new HashSet<Genre>();
        genreList1.add(Genre.ADVENTURE);
        genreList1.add(Genre.TECHNOLOGY);
        Book book1 = new Book(authorList1, "Ready Player One", 59.99, 1, LocalDateTime.now(), genreList1);
        Book book11 = new Book(authorList1, "Ready Player Two", 59.99, 1, LocalDateTime.now(), genreList1);

        Author author21 = new Author("Karl Marx", new HashSet<>());
        Author author22 = new Author("Friedrich Engels", new HashSet<>());
        Set<Author> authorList2 = new HashSet<Author>();
        authorList2.add(author21);
        authorList2.add(author22);
        Set<Genre> genreList2 = new HashSet<Genre>();
        genreList2.add(Genre.FANTASY);
        Book book2 = new Book(authorList2, "The Communist Manifesto", 0, 1, LocalDateTime.now(), genreList2);

        Library library1 = new Library(new HashSet<>(), new HashSet<>());
        library1.addBook(book1);
        library1.addBook(book11);
        library1.addBook(book2);
        System.out.println("************");
        /*
        library1.removeBook(book1);
        library1.removeBook(book11);
        library1.removeBook(book2);
        */
        System.out.println("************");
        System.out.println(author1.getBooks());
        System.out.println("************");
        library1.getBookById(0);
        System.out.println("************");
        library1.getBookByTitle("Ready Player");
        System.out.println("************");
        library1.getBookByAuthor(author1);
    }
}