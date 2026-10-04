package com.bookstore.cls.api.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;

@Table(name = "customers")
@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

public class Customer {
    @Id
    @GeneratedValue
    private UUID id;
    @Column(nullable = false)
    private String name;
    @Column(nullable = false, unique = true)
    private String cpf;
    @Column(nullable = false)
    private String address;
    @Column(nullable = false)
    private String email;
    private String phone;



}
