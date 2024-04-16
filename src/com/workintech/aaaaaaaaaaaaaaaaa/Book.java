package com.workintech.aaaaaaaaaaaaaaaaa;

import java.time.LocalDateTime;
import java.util.Set;

public class Book{
    private static int counter = 0;
    private long bookID;
    private Set<Author> author;
    private String title;
    private double price;
    private Status status; //boolean?
    private int edition;
    private LocalDateTime dateOfPurchase;
    private Set<Genre> genres;

    public static void setCounter(int counter) {
        Book.counter = counter;
    }

    public void setAuthor(Set<Author> author) {
        this.author = author;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public void setEdition(int edition) {
        this.edition = edition;
    }

    public void setDateOfPurchase(LocalDateTime dateOfPurchase) {
        this.dateOfPurchase = dateOfPurchase;
    }

    public void setGenres(Set<Genre> genres) {
        this.genres = genres;
    }

    public static int getCounter() {
        return counter;
    }

    public long getBookID() {
        return bookID;
    }

    public Set<Author> getAuthor() {
        return author;
    }

    public String getTitle() {
        return title;
    }

    public double getPrice() {
        return price;
    }

    public Status getStatus() {
        return status;
    }

    public int getEdition() {
        return edition;
    }

    public LocalDateTime getDateOfPurchase() {
        return dateOfPurchase;
    }

    public Set<Genre> getGenres() {
        return genres;
    }

    public Book(Set<Author> authors, String title, double price, int edition, LocalDateTime dateOfPurchase, Set<Genre> genres) {
        this.bookID = counter++;
        this.author = authors;
        this.title = title;
        this.price = price;
        this.status = Status.IN_LIBRARY;
        this.edition = edition;
        this.dateOfPurchase = dateOfPurchase;
        this.genres = genres;
        for(Author aut : authors){
            addToAuthor(aut);
        }
    }

    private void addToAuthor(Author author){
        author.addBook(this);
    }

    /*
        this.bookID = UUID.randomUUID();
        this.status = Status.IN_LIBRARY;
     */

    @Override
    public String toString() {
        return "Book{" +
                "bookID=" + bookID +
                ", author=" + author +
                ", title='" + title + '\'' +
                ", price=" + price +
                ", status=" + status +
                ", edition=" + edition +
                ", dateOfPurchase=" + dateOfPurchase +
                ", genres=" + genres +
                '}';
    }
}
