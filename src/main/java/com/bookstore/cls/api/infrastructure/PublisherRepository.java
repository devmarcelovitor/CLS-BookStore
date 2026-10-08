package com.bookstore.cls.api.infrastructure;

import com.bookstore.cls.api.domain.Publisher;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface PublisherRepository extends JpaRepository<Publisher, UUID> {
}