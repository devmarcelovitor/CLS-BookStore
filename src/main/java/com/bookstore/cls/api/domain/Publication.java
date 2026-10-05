package com.bookstore.cls.api.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;

@Entity
@Table(name = "publications")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Publication {
    @Id
    @GeneratedValue
    private UUID id;

    @Column(nullable = false)
    private Integer editionNumber;

    @Column(nullable = false)
    private Integer editionYear;        // format YYYY

    @ManyToOne(optional = false)
    private Publisher publisher;

    @ManyToOne(optional = false)
    private Book book;
}
