package com.bookstore.cls.api.infrastructure;

import com.bookstore.cls.api.domain.Publication;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface PublicationRepository extends JpaRepository<Publication, UUID> {
}