package com.bookstore.cls.api.api;

import com.bookstore.cls.api.application.CustomerService;
import com.bookstore.cls.api.domain.Customer;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/customers")
@RequiredArgsConstructor
public class CustomerController {
    private final CustomerService customerService;
    @PostMapping
    public ResponseEntity<CustomerResponse> create(@RequestBody CustomerRequest request){
        Customer saved = customerService.create(request.toEntity());
        return ResponseEntity.status(HttpStatus.CREATED).body(CustomerResponse.from(saved));
    }
    @GetMapping
    public List<CustomerResponse> findAll() {
        return customerService.findAll().stream()
                .map(CustomerResponse::from)
                .toList();
    }

    @GetMapping("/{id}")
    public CustomerResponse findById(@PathVariable UUID id) {
        return CustomerResponse.from(customerService.findByid(id));
    }

    @PutMapping("/{id}")
    public CustomerResponse update(@PathVariable UUID id, @RequestBody CustomerRequest request) {
        Customer updated = customerService.update(id, request.toEntity());
        return CustomerResponse.from(updated);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable UUID id) {
        customerService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
