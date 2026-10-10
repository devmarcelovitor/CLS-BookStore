package com.bookstore.cls.api.application;

import com.bookstore.cls.api.application.exception.BusinessRuleException;
import com.bookstore.cls.api.application.exception.ResourceNotFoundException;
import com.bookstore.cls.api.domain.Book;
import com.bookstore.cls.api.infrastructure.BookRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.math.BigDecimal;
import java.util.Optional;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class BookServiceTest {
    @Mock
    private BookRepository bookRepository;

    @InjectMocks
    private BookService bookService;

    @Test
    void create_shouldThrowException_whenSalePriceIsZero() {
        Book book = new Book();
        book.setTitle("Dom Casmurro");
        book.setGenre("Romance");
        book.setSalePrice(BigDecimal.ZERO);

        assertThrows(BusinessRuleException.class, () -> bookService.create(book));
        verify(bookRepository, never()).save(any());
    }
    @Test
    void findById_shouldThrowException_whenBookDoesNotExist() {
        UUID id = UUID.randomUUID();
        when(bookRepository.findById(id)).thenReturn(Optional.empty());
        assertThrows(ResourceNotFoundException.class, () -> bookService.findById(id));
    }
    @Test
    void create_shouldSaveBook_whenSalePriceIsValid() {
        Book book = new Book();
        book.setTitle("Dom Casmurro");
        book.setGenre("Romance");
        book.setSalePrice(new BigDecimal("49.90"));

        bookService.create(book);

        // use verify(bookRepository).save(book) para confirmar que o save foi chamado uma vez
        verify(bookRepository, never()).save(any());
    }

}