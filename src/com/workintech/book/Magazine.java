package com.workintech.book;

import com.workintech.person.Author;

import java.util.Set;

public class Magazine extends Book {
    private int releaseMonth;
    private int releaseYear;
    private int edition;

    public Magazine(Author author, String title, double price, Set<Genre> genres, int releaseMonth, int releaseYear, int edition) {
        super(author, title, price, genres);
        this.releaseMonth = releaseMonth;
        this.releaseYear = releaseYear;
        this.edition = edition;
    }

    public int getReleaseMonth() {
        return releaseMonth;
    }

    public int getReleaseYear() {
        return releaseYear;
    }

    public int getEdition() {
        return edition;
    }

    @Override
    public String toString() {
        return "Magazine{" +
                "bookID=" + getBookID() +
                ", author=" + getAuthor() +
                ", title='" + getTitle() + '\'' +
                ", price=" + getPrice() +
                ", genres=" + getGenres() +
                ", releaseMonth=" + releaseMonth +
                ", releaseYear=" + releaseYear +
                ", edition=" + edition +
                '}';
    }
}
