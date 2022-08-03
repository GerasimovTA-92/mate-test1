package com.example.matetest.dto.response;

import com.example.matetest.model.Author;
import com.example.matetest.model.Book;

public class BookResponseDto {
    private Long id;
    private String name;
    private Long publishedAmount;
    private Long soldAmount;
    private Author author;

    public BookResponseDto(Book book) {
        this.id = book.getId();
        this.name = book.getName();
        this.publishedAmount = book.getPublishedAmount();
        this.soldAmount = book.getSoldAmount();
        this.author = book.getAuthor();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getPublishedAmount() {
        return publishedAmount;
    }

    public void setPublishedAmount(Long publishedAmount) {
        this.publishedAmount = publishedAmount;
    }

    public Long getSoldAmount() {
        return soldAmount;
    }

    public void setSoldAmount(Long soldAmount) {
        this.soldAmount = soldAmount;
    }

    public Author getAuthor() {
        return author;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }
}
