package com.example.BookApplication.Contoroller;


import com.example.BookApplication.Model.Book;
import com.example.BookApplication.Service.BookService;
import com.example.BookApplication.Service.GoogleBooksService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;

import java.util.List;

@Controller
public class BookController {

    @Autowired
    BookService service;

    @Autowired
    GoogleBooksService googleBooksService;

    @GetMapping("/book-list")
    public String bookList(Model model){
        List<Book> bookList = service.findAll();
        model.addAttribute("bookList", bookList);
        return "bookList";
    }

    @GetMapping("/book-register")
    public String bookRegister(Model model){
        model.addAttribute("book", new Book());
        return "register";
    }

    @PostMapping("/book-register")
    public String create(@ModelAttribute Book book, Model model){
        service.crateBook(book);
//        List<Book> bookList = service.findAll();
//        model.addAttribute("bookList", bookList);
//        return "bookList";
        return "redirect:/book-list";

    }

    @PostMapping("/search")
    public String searchBooks(@RequestParam String query, Model model){
        List<Book> books =  googleBooksService.searchBooks(query).block();
        model.addAttribute("books", books);
        return "register";
    }
}
