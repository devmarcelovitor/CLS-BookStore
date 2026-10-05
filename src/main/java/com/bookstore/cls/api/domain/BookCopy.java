package com.bookstore.cls.api.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.UUID;

@Entity
@Table(name = "book_copies")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class BookCopy {
    @Id
    @GeneratedValue
    private UUID id;

    @ManyToOne(optional = false)
    private Book book;

    @ManyToOne
    private Sale sale;
    @Column(nullable = false)
    private LocalDate acquisitionDate;
    @Column(nullable = false)
    private ConservationStates conservationState;
    @Column(nullable = false)
    private BigDecimal purchaseCost;

    @Enumerated(EnumType.STRING)
    private StockType stockType;

    private BigDecimal salePrice;


}
