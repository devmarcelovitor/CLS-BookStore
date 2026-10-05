package com.bookstore.cls.api.domain;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import jakarta.persistence.*;


import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.UUID;

@Entity
@Table(name = "loans")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Loan {
    @Id
    @GeneratedValue
    private UUID id;


    @Column(nullable = false, updatable = false)
    private LocalDate loanDate;

    @Column(nullable = false)
    private LocalDate dueDate;


    private LocalDate returnDate;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private LoanStatus status;


    @Column(nullable = false, precision = 10, scale = 2)
    private BigDecimal rentalFee;

    @Column(precision = 10, scale = 2)
    private BigDecimal lateFee;
    @Column(precision = 10, scale = 2)
    private BigDecimal damageFee;

    @ManyToOne(optional = false)
    private Customer customer;
    @ManyToOne(optional = false)
    private Employee employee;
    @ManyToOne(optional = false)
    private BookCopy bookCopy;


}
