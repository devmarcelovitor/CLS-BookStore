package com.bookstore.cls.api.domain;

import jakarta.persistence.*;

import java.math.BigDecimal;
import java.util.UUID;

@Entity
@Table(name = "examples")
public class BookCopy {
    @Id
    @GeneratedValue
    private UUID id;

    @ManyToOne(optional = false)
    private Book book;

    @ManyToOne(optional = false)
    private Sale sale;

    private LocalDate acquisitiondate;
    private String conservationState;
    private BigDecimal purchaseCost;

    @Enumerated(EnumType.STRING)
    private StockType stockType;

    private BigDecimal salePrice;


}
