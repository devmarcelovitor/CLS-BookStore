package com.bookstore.cls.api.application;

import com.bookstore.cls.api.application.exception.BusinessRuleException;
import com.bookstore.cls.api.application.exception.ResourceNotFoundException;
import com.bookstore.cls.api.domain.Book;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.transaction.annotation.Transactional;
import com.bookstore.cls.api.infrastructure.BookRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class BookService {
    private final BookRepository bookRepository;

    @Transactional(readOnly = true)
    public Book findById(UUID id) {
        return bookRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Book not found: " + id));
    }

    @Transactional(readOnly = true)
    public List<Book> findAll() {
        return bookRepository.findAll();
    }

    @Transactional
    public Book create(Book book) {
        validateSalePrice(book);
        return bookRepository.save(book);
    }

    @Transactional
    public void delete(UUID id) {
        Book book = findById(id);
        bookRepository.delete(book);
    }

    @Transactional
    public Book update(UUID id, Book data) {
        Book book = findById(id);
        validateSalePrice(data);
        book.setTitle(data.getTitle());
        book.setSeries(data.getSeries());
        book.setGenre(data.getGenre());
        book.setSalePrice(data.getSalePrice());
        return bookRepository.save(book);
    }


    private void validateSalePrice(Book book) {
        if (book.getSalePrice() == null || book.getSalePrice().compareTo(BigDecimal.ZERO) <= 0) {
            throw new BusinessRuleException("Sale price must be greater than zero");
        }
    }
}

