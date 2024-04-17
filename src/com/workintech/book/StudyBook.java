package com.workintech.book;

import com.workintech.person.Author;

import java.util.Set;

public class StudyBook extends Book {
    private Degree degree;

    public StudyBook(Author author, String title, double price, Set<Genre> genres, Degree degree) {
        super(author, title, price, genres);
        this.degree = degree;
    }

    public Degree getDegree() {
        return degree;
    }

    @Override
    public String toString() {
        return "StudyBook{" +
                "bookID=" + getBookID() +
                ", author=" + getAuthor() +
                ", title='" + getTitle() + '\'' +
                ", price=" + getPrice() +
                ", genres=" + getGenres() +
                ", degree=" + degree +
                '}';
    }
}
