package com.bookstore.cls.api.infrastructure;

import com.bookstore.cls.api.domain.Supply;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface SupplyRepository extends JpaRepository<Supply, UUID> {
}