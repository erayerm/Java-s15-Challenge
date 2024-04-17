package com.workintech.library;

import com.workintech.book.Book;
import com.workintech.book.BookCounts;
import com.workintech.book.Genre;
import com.workintech.person.Author;
import com.workintech.person.Member;

import java.time.LocalDateTime;
import java.util.*;

public class Library {
    private Map<Book, BookCounts> books;
    private Set<Member> members;
    private Set<Receipt> receiptList;
    private double money;

    public Library() {
        books = new HashMap<>();
        members = new HashSet<>();
        receiptList = new HashSet<>();
        money = 0;
    }

    public void filterForGenre(Genre genre){
        System.out.println("Books with the " + genre + " genre:");
        for(Book book : books.keySet()){
            if(book.getGenres().contains(genre)){
                System.out.println(book);
            }
        }
    }

    public void filterForAuthor(Author author){
        System.out.println("Books with the " + author.getName() + " author:");
        for(Book book : books.keySet()){
            if(book.getAuthor().equals(author)){
                System.out.println(book);
            }
        }
    }

    public Receipt rentingABook(Member member, long id, int days){
        if(member.getBooksOwned().size() >= 5){
            System.out.println("You can't rent more than 5 books");
            return null;
        }
        for(Book book : books.keySet()){
            if(book.getBookID() == id){
                if(books.get(book).getTotalAvailable() > 0){
                    books.get(book).setTotalAvailable(books.get(book).getTotalAvailable() - 1);
                    member.bookRented(book, days);
                    System.out.println(member.getName() + " successfully loan book called " + book.getTitle());
                    Receipt receipt = new Receipt(LocalDateTime.now(), LocalDateTime.now().plusDays(days), member, book);
                    receiptList.add(receipt);
                    money += book.getPrice();
                    return receipt;
                }else{
                    System.out.println("This book is on loan for someone else (" + book.getTitle() + ")");
                    return null;
                }
            }
        }
        System.out.println("Book didn't found");
        return null;
    }
    public void returningABook(Receipt receipt){
        for(Book book : books.keySet()){
            if(book.getBookID() == receipt.getBook().getBookID()){
                books.get(book).setTotalAvailable(books.get(book).getTotalAvailable() + 1);
                receipt.getMember().bookReturned(book);
                System.out.println(receipt.getMember().getName() + " returned the book called " + book.getTitle());
                receiptList.remove(receipt);
                if(receipt.getReturningDate().isBefore(LocalDateTime.now())){
                    System.out.println("%10 cut for late returning");
                    money -= (receipt.getBook().getPrice() * 0.9);
                }else{
                    money -= receipt.getBook().getPrice();
                }
                return;
            }
        }
    }
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
                System.out.println("One book successfully removed " + book.getTitle());
            }else{
                System.out.println(book.getTitle() + " is on loan");
            }
        }else{
            System.out.println(book.getTitle() + " doesn't exist already");
        }
    }
    public void addMember(Member member){
        members.add(member);
    }

    public Map<Book, BookCounts> getBooks() {
        return books;
    }

    public Set<Member> getMembers() {
        return members;
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

    public void display(){
        System.out.println("All Books: (Total Count, Available for loan Count, Book itself)");
        for(Book book : books.keySet()){
            System.out.print(books.get(book).getTotalInLibrary() + ", ");
            System.out.print(books.get(book).getTotalAvailable() + ", ");
            System.out.println(book);
        }
        System.out.println();
        System.out.println("All Members:");
        for(Member member : members){
            System.out.println(member);
        }
        System.out.println();
        System.out.println("All Receipts:");
        for(Receipt receipt : receiptList){
            System.out.println(receipt);
        }
        System.out.println();
        System.out.println("Money:");
        System.out.println(money);
    }

    @Override
    public String toString() {
        return "Library{" +
                "books=" + books +
                ", members=" + members +
                "}";
    }
}
