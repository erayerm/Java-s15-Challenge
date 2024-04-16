package com.workintech.aaaaaaaaaaaaaaaaa;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Author {
    private static int counter = 0;
    private long authorID;
    private String name;
    private Set<Book> books;

    public static int getCounter() {
        return counter;
    }

    public void addBook(Book book){
        books.add(book);
    }
    public long getAuthorID() {
        return authorID;
    }

    public Author(String name, Set<Book> books) {
        this.authorID = counter++;
        this.name = name;
        this.books = books;
    }

    public String getName() {
        return name;
    }

    public Set<Book> getBooks() {
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
