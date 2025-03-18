package com.example.BookApplication.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.BookApplication.Model.Book;

public interface BookRepository  extends JpaRepository<Book, Integer> {
}
