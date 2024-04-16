import com.workintech.aaaaaaaaaaaaaaaaa.Author;
import com.workintech.aaaaaaaaaaaaaaaaa.Book;
import com.workintech.aaaaaaaaaaaaaaaaa.Genre;
import com.workintech.aaaaaaaaaaaaaaaaa.Library;

import java.time.LocalDateTime;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Author author1 = new Author("Ernest Cline");
        Author author2 = new Author("Mark Twain");
        Author author3 = new Author("George Orwell");
        Author author4 = new Author("William B. Irvine");
        Author author5 = new Author("Bobby Henderson");

        Book book1 = new Book(author1, "Ready Player One", 59.99, 1, LocalDateTime.now(), new HashSet<>(Arrays.asList(Genre.ADVENTURE, Genre.TECHNOLOGY)));
        Book book2 = new Book(author1, "Ready Player Two", 59.99, 1, LocalDateTime.now(), new HashSet<>(Arrays.asList(Genre.ADVENTURE, Genre.TECHNOLOGY)));
        Book book3 = new Book(author2, "What is Man?", 21.49, 240, LocalDateTime.now(), new HashSet<>(Arrays.asList(Genre.PHILOSOPHY)));
        Book book4 = new Book(author3, "1984", 19.84, 1, LocalDateTime.now(), new HashSet<>(Arrays.asList(Genre.TRAGEDY)));
        Book book5 = new Book(author3, "Animal Farm", 19.84, 1, LocalDateTime.now(), new HashSet<>(Arrays.asList(Genre.TRAGEDY)));
        Book book6 = new Book(author4, "A Guide to the Good Life", 19.84, 1, LocalDateTime.now(), new HashSet<>(Arrays.asList(Genre.PHILOSOPHY)));
        Book book7 = new Book(author5, "The Gospel of the Flying Spaghetti Monster", 19.84, 1, LocalDateTime.now(), new HashSet<>(Arrays.asList(Genre.COMEDY)));


        Library library1 = new Library();
        library1.addBook(book1);
        library1.addBook(book1, 2);
        library1.addBook(book2);
        library1.addBook(book3);
        library1.addBook(book4);
        library1.addBook(book5);
        library1.addBook(book6);
        library1.addBook(book7);
        System.out.println("************");

        library1.removeBook(book1);
        library1.removeBook(book2);
        library1.removeBook(book2);
        library1.removeBook(book3);

        System.out.println("************");
        System.out.println(author1.getBooks());
        System.out.println("************");
        library1.getBookById(0);
        System.out.println("************");
        library1.getBookByTitle("Ready Player");
        System.out.println("************");
        library1.getBookByAuthor(author1);
        System.out.println("************");
        System.out.println("Library'nin tamamı");
        System.out.println(library1);
    }
}