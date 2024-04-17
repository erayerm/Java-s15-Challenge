package com.workintech.library;

import com.workintech.book.Book;
import com.workintech.person.Member;

import java.time.LocalDateTime;
import java.util.Objects;

public class Receipt {
    private LocalDateTime loanDate;
    private LocalDateTime returningDate;
    private Member member;
    private Book book;

    public Receipt(LocalDateTime loanDate, LocalDateTime returningDate, Member member, Book book) {
        this.loanDate = loanDate;
        this.returningDate = returningDate;
        this.member = member;
        this.book = book;
    }

    public LocalDateTime getLoanDate() {
        return loanDate;
    }

    public LocalDateTime getReturningDate() {
        return returningDate;
    }

    public Member getMember() {
        return member;
    }

    public Book getBook() {
        return book;
    }

    @Override
    public String toString() {
        return "Receipt{" +
                "loanDate=" + loanDate +
                ", member=" + member +
                ", book=" + book +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Receipt receipt = (Receipt) o;
        return Objects.equals(loanDate, receipt.loanDate) && Objects.equals(returningDate, receipt.returningDate) && Objects.equals(member, receipt.member) && Objects.equals(book, receipt.book);
    }

    @Override
    public int hashCode() {
        return Objects.hash(loanDate, returningDate, member, book);
    }
}
