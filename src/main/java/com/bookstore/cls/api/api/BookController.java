package com.bookstore.cls.api.api;

import com.bookstore.cls.api.application.BookService;
import com.bookstore.cls.api.domain.Book;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/books")
@RequiredArgsConstructor
public class BookController {
    private final BookService bookService;

    @PostMapping
    public ResponseEntity<BookResponse> create(@RequestBody BookRequest bookRequest) {
        Book saved = bookService.create(bookRequest.toEntity());
        return  ResponseEntity.status(HttpStatus.CREATED).body(BookResponse.from(saved));
    }
    @GetMapping
    public List<BookResponse> findAll() {
        return bookService.findAll().stream().map(BookResponse::from)
                .toList();
    }
    @GetMapping("/{id}")
    public BookResponse findById(@PathVariable UUID id) {
        return BookResponse.from(bookService.findById(id));
    }

    @PutMapping("/{id}")
    public BookResponse update(@PathVariable UUID id, @RequestBody BookRequest request) {
        Book updated = bookService.update(id, request.toEntity());
        return BookResponse.from(updated);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable UUID id) {
        bookService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
