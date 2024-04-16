package com.workintech.aaaaaaaaaaaaaaaaa;


import java.util.Set;

public class Member extends Person {
    private String name;
    private Set<Book> booksOwned;


    public void rentABook(){

    }

    @Override
    String getName() {
        return name;
    }
}
