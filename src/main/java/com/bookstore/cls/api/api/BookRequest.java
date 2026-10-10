package com.bookstore.cls.api.api;

import com.bookstore.cls.api.domain.Book;

import java.math.BigDecimal;

public record BookRequest(String title, String series, String genre, BigDecimal salePrice) {
    public Book toEntity() {
        Book book = new Book();
        book.setTitle(title);
        book.setSeries(series);
        book.setGenre(genre);
        book.setSalePrice(salePrice);
        return book;
    }
}
