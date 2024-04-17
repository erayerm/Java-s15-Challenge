import com.workintech.book.*;
import com.workintech.library.*;
import com.workintech.person.Author;
import com.workintech.person.Member;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Author author1 = new Author("Ernest Cline");
        Author author2 = new Author("Mark Twain");
        Author author3 = new Author("George Orwell");
        Author author4 = new Author("William B. Irvine");
        Author author5 = new Author("Bobby Henderson");
        Author author6 = new Author("Sam Jacobs");
        Author author7 = new Author("Murat Balkan");

        Book book1 = new Book(author1, "Ready Player One", 59.99, new HashSet<>(Arrays.asList(Genre.ADVENTURE, Genre.TECHNOLOGY)));
        Book book2 = new Book(author1, "Ready Player Two", 59.99, new HashSet<>(Arrays.asList(Genre.ADVENTURE, Genre.TECHNOLOGY)));
        Book book3 = new Book(author2, "What is Man?", 21.49,  new HashSet<>(Arrays.asList(Genre.PHILOSOPHY)));
        Book book4 = new Book(author3, "1984", 19.84,  new HashSet<>(Arrays.asList(Genre.TRAGEDY)));
        Book book5 = new Book(author3, "Animal Farm", 19.84,  new HashSet<>(Arrays.asList(Genre.TRAGEDY)));
        Book book6 = new Book(author4, "A Guide to the Good Life", 19.84,  new HashSet<>(Arrays.asList(Genre.PHILOSOPHY)));
        Book book7 = new Book(author5, "The Gospel of the Flying Spaghetti Monster", 19.84,  new HashSet<>(Arrays.asList(Genre.COMEDY)));
        Book book8 = new Magazine(author6, "Time", 19.84, new HashSet<>(Arrays.asList(Genre.POLITICS, Genre.HISTORY, Genre.EDUCATION)), 4, 2024, 4321);
        Book book9 = new StudyBook(author7, "JavaScript", 19.84, new HashSet<>(Arrays.asList(Genre.EDUCATION)), Degree.UNIVERSITY);

        Library library = new Library();
        library.addBook(book1);
        library.addBook(book1, 2);
        library.addBook(book2);
        library.addBook(book3);
        library.addBook(book4);
        library.addBook(book5, 10);
        library.addBook(book6, 3);
        library.addBook(book7);
        library.addBook(book8, 8);
        library.addBook(book9);

        Member member1 = new Member("Scott Pilgrim (Member 1)");
        Member member2 = new Member("Ramona Flowers (Member 2)");
        Member member3 = new Member("Envy Adams (Member 3)");

        System.out.println();
        System.out.println("Member Section:");
        System.out.println();
        Receipt receipt1 = library.rentingABook(member1, 0, 30);
        Receipt receipt2 = library.rentingABook(member1, 1, 7);
        System.out.println();
        System.out.println(member1);
        System.out.println();
        library.returningABook(receipt2);
        System.out.println();
        System.out.println(member1);
        System.out.println();
        Receipt receipt3 = library.rentingABook(member2, 1, 7);
        System.out.println();
        Receipt receipt4 = library.rentingABook(member3, 1, 7);

        library.addMember(member1);
        library.addMember(member2);
        library.addMember(member3);

        System.out.println();
        System.out.println();
        System.out.println();

        System.out.println("Book Section:");
        System.out.println();
        library.removeBook(book5);
        System.out.println();
        library.getBookById(0);
        System.out.println();
        library.getBookByTitle("Ready Player");
        System.out.println();
        library.getBookByAuthor(author1);
        System.out.println();
        library.filterForGenre(Genre.PHILOSOPHY);
        System.out.println();
        library.filterForAuthor(author1);
        System.out.println();
        System.out.println("Library:");
        library.display();
    }
}