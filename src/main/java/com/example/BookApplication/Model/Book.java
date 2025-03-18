package com.example.BookApplication.Model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
//@RequiredArgsConstructor
//@AllArgsConstructor
@Table(name="booksinfo")
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private int id;

    @Column(name="title")
    private String title;

    @Column(name="thumbnail")
    private String thumbnail;

    public Book(String title, String thumbnail) {
        this.title = title;
        this.thumbnail = thumbnail;
    }
}

