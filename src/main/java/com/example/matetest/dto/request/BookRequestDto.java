package com.example.matetest.dto.request;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

public class BookRequestDto {
    @NotNull
    private String name;
    @Min(0)
    private Long publishedAmount;
    @Min(0)
    private Long soldAmount;
    @NotNull
    private Long authorId;

    public BookRequestDto() {
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

    public Long getAuthorId() {
        return authorId;
    }

    public void setAuthorId(Long authorId) {
        this.authorId = authorId;
    }
}
