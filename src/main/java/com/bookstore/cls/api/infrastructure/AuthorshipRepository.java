package com.bookstore.cls.api.infrastructure;

import com.bookstore.cls.api.domain.Authorship;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface AuthorshipRepository extends JpaRepository<Authorship, UUID> {
}
