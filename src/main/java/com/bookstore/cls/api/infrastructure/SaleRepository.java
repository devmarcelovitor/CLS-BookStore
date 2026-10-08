package com.bookstore.cls.api.infrastructure;

import com.bookstore.cls.api.domain.Sale;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface SaleRepository extends JpaRepository<Sale, UUID> {
}