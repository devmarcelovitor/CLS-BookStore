package com.bookstore.cls.api.infrastructure;

import com.bookstore.cls.api.domain.Book;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface BookRepository extends JpaRepository<Book, UUID> {

}
