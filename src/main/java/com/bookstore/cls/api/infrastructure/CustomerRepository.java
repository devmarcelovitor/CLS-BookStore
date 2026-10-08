package com.bookstore.cls.api.infrastructure;

import com.bookstore.cls.api.domain.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface CustomerRepository extends JpaRepository<Customer, UUID> {
    Optional<Customer> findByCpf(String cpf);
    boolean existsByCpf(String cpf);
}
