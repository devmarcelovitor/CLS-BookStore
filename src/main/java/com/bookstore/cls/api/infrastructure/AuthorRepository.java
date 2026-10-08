package com.bookstore.cls.api.infrastructure;

import com.bookstore.cls.api.domain.Author;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface AuthorRepository extends JpaRepository<Author, UUID> {
}
