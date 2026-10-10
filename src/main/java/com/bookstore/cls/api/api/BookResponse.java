package com.bookstore.cls.api.api;

import com.bookstore.cls.api.domain.Book;

import java.math.BigDecimal;
import java.util.UUID;

public record BookResponse(UUID id, String title, String series, String genre, BigDecimal salePrice) {
    public static BookResponse from(Book book) {
        return new BookResponse(
                book.getId(), book.getTitle(), book.getSeries(),
                book.getGenre(), book.getSalePrice()

        );
    }
}
