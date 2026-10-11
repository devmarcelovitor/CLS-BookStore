package com.bookstore.cls.api.api;

import com.bookstore.cls.api.domain.Customer;

public record CustomerRequest(String name, String cpf, String phone, String email, String address) {

    public Customer toEntity() {
        Customer customer = new Customer();
        customer.setName(name);
        customer.setCpf(cpf);
        customer.setPhone(phone);
        customer.setEmail(email);
        customer.setAddress(address);
        return customer;
    }
}