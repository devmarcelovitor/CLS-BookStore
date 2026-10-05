package com.bookstore.cls.api.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.*;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table(name = "sales")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Sale {
    @Id
    @GeneratedValue
    private UUID id;

    @CreationTimestamp
    @Column(nullable = false, updatable = false)
    private LocalDateTime dateTime;

    @Column(nullable = false,precision = 10, scale = 2)
    private BigDecimal totalAmount;

    @ManyToOne(optional = false)
    private Customer customer;

    @ManyToOne(optional = false)
    private Employee employee;
}
