package com.bookstore.cls.api.api;

import com.bookstore.cls.api.domain.Customer;

import java.util.UUID;

public record CustomerResponse(UUID id, String name, String cpf, String phone, String email, String address) {
    public static CustomerResponse from(Customer customer){
        return new CustomerResponse(
                customer.getId(), customer.getName(), customer.getCpf(), customer.getPhone(), customer.getEmail(), customer.getAddress()

        );
    }
}
