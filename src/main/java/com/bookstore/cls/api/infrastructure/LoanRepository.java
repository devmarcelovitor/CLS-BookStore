package com.bookstore.cls.api.infrastructure;

import com.bookstore.cls.api.domain.Customer;
import com.bookstore.cls.api.domain.Loan;
import com.bookstore.cls.api.domain.LoanStatus;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface LoanRepository extends JpaRepository<Loan, UUID> {
    boolean existsByCustomerAndStatus(Customer customer, LoanStatus status);
}
