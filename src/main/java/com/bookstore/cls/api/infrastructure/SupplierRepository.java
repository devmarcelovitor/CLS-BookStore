package com.bookstore.cls.api.infrastructure;

import com.bookstore.cls.api.domain.Supplier;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface SupplierRepository extends JpaRepository<Supplier, UUID> {
    boolean existsByCnpj(String cnpj);
}