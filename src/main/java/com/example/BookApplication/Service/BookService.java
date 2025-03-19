package com.example.BookApplication.Service;

import com.example.BookApplication.Model.Book;
import com.example.BookApplication.Model.ReadingStatus;
import com.example.BookApplication.Repository.BookRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
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

    public List<Book> fetchBooksByStatus(ReadingStatus status){
        return repository.findByStatus(status);
    }

    // 読書ステータスを更新
    public void updateBookStatus(int id,ReadingStatus status){
        Book book = repository.findById(id).orElse(null);
        if(book != null){
            book.setStatus(status);
            repository.save(book);
        }
    }

    public List<Book> findAllSortedById(){
        return repository.findAll(Sort.by(Sort.Direction.ASC, "id"));
    }
}
