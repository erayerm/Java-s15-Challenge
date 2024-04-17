package com.workintech.book;

import com.workintech.person.Author;

import java.util.Objects;
import java.util.Set;

public class Book{
    private static int counter = 0;
    private long bookID;
    private Author author;
    private String title;
    private double price;
    private Set<Genre> genres;

    public Book(Author author, String title, double price, Set<Genre> genres) {
        this.bookID = counter++;
        this.author = author;
        this.title = title;
        this.price = price;
        this.genres = genres;
        author.addBook(this);
    }

    public void setAuthor(Author author) {
        this.author = author;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setPrice(double price) {
        this.price = price;
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

    public Author getAuthor() {
        return author;
    }

    public String getTitle() {
        return title;
    }
    public double getPrice() {
        return price;
    }

    public Set<Genre> getGenres() {
        return genres;
    }



    @Override
    public String toString() {
        return "Book{" +
                "bookID=" + bookID +
                ", author=" + author +
                ", title='" + title + '\'' +
                ", price=" + price +
                ", genres=" + genres +
                "}";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Book book = (Book) o;
        return bookID == book.bookID;
    }

    @Override
    public int hashCode() {
        return Objects.hash(bookID);
    }
}
