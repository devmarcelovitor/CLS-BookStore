package com.bookstore.cls.api.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table(name = "stock_logs")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class StockLog {
    @Id
    @GeneratedValue
    private UUID id;

    @Column(nullable = false, updatable = false)
    @CreationTimestamp
    private LocalDateTime movementDate;

    @Column(nullable = false)
    private Integer quantityMoved;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private StockMovementReason reason;


    @ManyToOne(optional = false)
    private Employee employee;

    @ManyToOne(optional = false)
    private BookCopy bookCopy;


}
