package com.example.BookApplication.Repository;

import com.example.BookApplication.Model.ReadingStatus;
import org.springframework.data.jpa.repository.JpaRepository;

import com.example.BookApplication.Model.Book;

import java.util.List;

public interface BookRepository  extends JpaRepository<Book, Integer> {
    List<Book> findByStatus(ReadingStatus status);
}
