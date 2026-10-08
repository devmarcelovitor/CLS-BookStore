package com.bookstore.cls.api.infrastructure;

import com.bookstore.cls.api.domain.Payment;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface PaymentRepository extends JpaRepository<Payment, UUID> {
}
