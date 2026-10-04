package com.bookstore.cls.api.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.UUID;

@Table(name = "books")
@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

public class Book {
    @Id
    @GeneratedValue
    private UUID id;

    @Column(nullable = false)
    private String title;

    @Column(nullable = false)
    private String genre;

    @Column(nullable = false)
    private BigDecimal salePrice;

}
