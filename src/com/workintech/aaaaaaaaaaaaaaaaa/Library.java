package com.workintech.aaaaaaaaaaaaaaaaa;

import java.sql.Array;
import java.sql.SQLOutput;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Library {
    private Map<Book, BookCounts> books;
    private Set<Member> members;

    public Library() {
        books = new HashMap<>();
        members = new HashSet<>();
    }

    //Overload
    public void addBook(Book book){
        addBook(book, 1);
    }
    public void addBook(Book book, int bookCount){
        if(books.containsKey(book)){
            BookCounts bc = books.get(book);
            bc.setTotalAvailable(bc.getTotalAvailable() + bookCount);
            bc.setTotalInLibrary(bc.getTotalInLibrary() + bookCount);
            books.put(book, bc);
        }else{
            books.put(book, new BookCounts(bookCount, bookCount));
        }
    }
    public void removeBook(Book book){
        if(books.containsKey(book)){
            if(books.get(book).getTotalAvailable() > 0){
                BookCounts bc = books.get(book);
                bc.setTotalAvailable(bc.getTotalAvailable() - 1);
                bc.setTotalInLibrary(bc.getTotalInLibrary() - 1);
                if(bc.getTotalInLibrary() < 1)
                    books.remove(book);
                else
                    books.put(book, bc);
                System.out.println("One book successfully removed");
            }else{
                System.out.println("The book(s) that you're trying to remove is on loan");
            }
        }else{
            System.out.println("This book doesn't exist already");
        }
    }
    public void addMember(Member member){
        members.add(member);
    }
    public void getBookById(long id){
        System.out.println(String.format("Searching for the book with the %s id number: ", id));
        int counter = 0;
        for(Book book : books.keySet()){
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
        for(Book book : books.keySet()){
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
        for(Book book : books.keySet()){
            if(book.getAuthor().equals(author)){
                System.out.println(book);
                counter++;
            }
        }
        if(counter==0) System.out.println("Book didn't found!");
    }

    @Override
    public String toString() {
        return "Library{" +
                "books=" + books +
                ", members=" + members +
                '}';
    }
}
