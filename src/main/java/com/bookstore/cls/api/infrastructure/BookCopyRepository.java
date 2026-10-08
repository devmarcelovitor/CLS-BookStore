package com.bookstore.cls.api.infrastructure;

import com.bookstore.cls.api.domain.Book;
import com.bookstore.cls.api.domain.BookCopy;
import com.bookstore.cls.api.domain.StockType;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface BookCopyRepository extends JpaRepository<BookCopy, UUID> {
    long countByBookAndStockType(Book book, StockType stockType);
}
