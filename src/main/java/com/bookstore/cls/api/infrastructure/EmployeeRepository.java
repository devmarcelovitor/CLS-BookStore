package com.bookstore.cls.api.infrastructure;

import com.bookstore.cls.api.domain.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface EmployeeRepository extends JpaRepository<Employee, UUID> {
    Optional<Employee> findByLogin(String login);
    boolean existsByCpf(String cpf);
    boolean existsByLogin(String login);
}