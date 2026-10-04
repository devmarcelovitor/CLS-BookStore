package com.bookstore.cls.api.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;

@Entity
@Table(name = "suppliers")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Supplier {
    @Id
    @GeneratedValue
    private UUID id;

    @Column(nullable = false)
    private String corporateName;

    @Column(nullable = false, unique = true)
    private String cnpj;

    @Column(nullable = false)
    private String phone;
    @Column(nullable = false)
    private String address;
    @Column(nullable = false)
    private String email;

}
