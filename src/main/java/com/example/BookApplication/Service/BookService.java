package com.example.BookApplication.Service;

import com.example.BookApplication.Model.Book;
import com.example.BookApplication.Repository.BookRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
@Transactional
public class BookService {

    @Autowired
    BookRepository repository;

    public List<Book> findAll(){
        return repository.findAll();
    }

    public void crateBook(Book book) {
        repository.save(book);
    }

    @Transactional
    public void deleteBookById(int id){
        repository.deleteById(id);
    }
}
