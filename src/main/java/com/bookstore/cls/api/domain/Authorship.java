package com.bookstore.cls.api.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;

@Entity
@Table(name = "authorships")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Authorship {
    @Id
    @GeneratedValue
    private UUID id;

    @Column(nullable = false)
    private String authorOrder;         // e.g. main author, co-author

    private String contributionType;    // e.g. writer, illustrator (optional)

    @ManyToOne(optional = false)
    private Author author;

    @ManyToOne(optional = false)
    private Book book;
}
