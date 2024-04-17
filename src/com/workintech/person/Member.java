package com.workintech.person;


import com.workintech.book.Book;
import com.workintech.person.Person;

import java.time.LocalDateTime;
import java.util.*;

public class Member extends Person {
    private String name;
    private Map<Book, LocalDateTime> booksOwned; //Time stands for returning date

    public void setName(String name) {
        this.name = name;
    }

    public Map<Book, LocalDateTime> getBooksOwned() {
        return booksOwned;
    }

    public void setBooksOwned(Map<Book, LocalDateTime> booksOwned) {
        this.booksOwned = booksOwned;
    }
    public void bookRented(Book book, int days){
        booksOwned.put(book, LocalDateTime.now().plusDays(days));
    }
    public void bookReturned(Book book){
        booksOwned.remove(book);
    }
    public Member(String name) {
        this.name = name;
        booksOwned = new HashMap<>();
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "Member{" +
                "name='" + name + '\'' +
                ", booksOwned=" + booksOwned +
                '}';
    }
}
