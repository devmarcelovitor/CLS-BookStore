package com.bookstore.cls.api.infrastructure;

import com.bookstore.cls.api.domain.StockLog;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface StockLogRepository extends JpaRepository<StockLog, UUID> {
}