package com.workintech.person;

import com.workintech.book.Book;

import java.util.ArrayList;
import java.util.List;

public class Author extends Person {
    private static int counter = 0;
    private long authorID;
    private String name;
    private List<Book> books;

    public static int getCounter() {
        return counter;
    }

    public void addBook(Book book){
        books.add(book);
    }
    public long getAuthorID() {
        return authorID;
    }

    public Author(String name) {
        this.authorID = counter++;
        this.name = name;
        this.books = new ArrayList<>();
    }

    @Override
    public String getName() {
        return name;
    }

    public List<Book> getBooks() {
        return books;
    }

    @Override
    public String toString() {
        return "Author{" +
                "authorID=" + authorID +
                ", name='" + name + '\'' +
                '}';
    }
}
