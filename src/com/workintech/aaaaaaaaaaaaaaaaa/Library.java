package com.workintech.aaaaaaaaaaaaaaaaa;

import java.sql.SQLOutput;
import java.util.HashSet;
import java.util.Set;

public class Library {
    //Kitapları ya da member'ları sırayla tutmanın bir mantığı yok I assume
    private Set<Book> books;
    private Set<Member> members;

    public Library(Set<Book> books, Set<Member> members) {
        this.books = books;
        this.members = members;
    }
    public void addBook(Book book){
        books.add(book);
    }
    public void addDuplicateBook(Book book){

    }
    public void removeBook(Book book){
        books.remove(book);
    }
    public void addMember(Member member){
        members.add(member);
    }
    public void getBookById(long id){
        System.out.println(String.format("Searching for the book with the %s id number: ", id));
        int counter = 0;
        for(Book book : books){
            if(book.getBookID() == id){
                System.out.println(book);
                counter++;
                break;
            }
        }
        if(counter==0) System.out.println("Book didn't found!");
    }
    public void getBookByTitle(String title){
        System.out.println(String.format("Searching for the books with the '%s' title: ", title));
        int counter = 0;
        for(Book book : books){
            if(book.getTitle().contains(title)){
                System.out.println(book);
                counter++;
            }
        }
        if(counter==0) System.out.println("Book didn't found!");
    }
    public void getBookByAuthor(Author author){
        System.out.println(String.format("Searching for the books with the '%s' Author: ", author.getName()));
        int counter = 0;
        for(Book book : books){
            if(book.getAuthor().contains(author)){
                System.out.println(book);
                counter++;
            }
        }
        if(counter==0) System.out.println("Book didn't found!");
    }
}
