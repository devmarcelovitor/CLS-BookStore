package com.bookstore.cls.api.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;

@Entity
@Getter
@Setter
@Table(name = "authors")
@NoArgsConstructor
@AllArgsConstructor
public class Author {
    @Id
    @GeneratedValue
    private UUID id;
    @Column(nullable = false)
    private String name;
    @Column(columnDefinition = "TEXT")
    private String biography;

}
